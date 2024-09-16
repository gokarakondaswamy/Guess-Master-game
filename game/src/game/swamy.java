package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class game{
	ArrayList<String> al= new ArrayList<String>();
	public abstract void addelements();
	public ArrayList<String> getal() {
		return al;
	}
}
class Animal extends game{

	@Override
	public void addelements() {
		 al.add("Lion");
	     al.add("Tiger");
	     al.add("Elephant");	
	}
}
class birds extends game{

	@Override
	public void addelements() {
		al.add("Sparrow");
        al.add("Eagle");
        al.add("Parrot");	
	}
	
}
class countries extends game{

	@Override
	public void addelements() {
		al.add("United States");
        al.add("India");
        al.add("Germany");
        al.add("Australia");
		
	}
	
}
class factory{
	static Scanner scan= new Scanner(System.in);
	public static game getgame(int choice){
		if(choice==1) {
			game an=new Animal();
			an.addelements();
			return an;
		}
		else if (choice==2) {
			game bi=new birds();
			bi.addelements();
			return bi;
			
		}
		else {
			game co=new countries();
			co.addelements();
			return co;
		}
		
	}
}
public class swamy {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		Random random=new Random();
		System.out.println("Enter your choice\n 1 Animal \n 2 birds \n 3 countires");
		int choice=scan.nextInt();
		game g;
		ArrayList<String>al = null;
		if(choice==1||choice==2||choice==3) {
			g=factory.getgame(choice);
			al=g.getal();
		}
		int randomindex=random.nextInt(al.size());

		String randomelement=al.get(randomindex);
		String blank="";
		System.out.println("you have 6 chance to find");
		char[] charc=new char[randomelement.length()];
		for(int i=0;i<randomelement.length();i++) {
			System.out.print("-"+" ");
			charc[i]='-';
		}
		int incorrectGuesses=0;
		int MAX_INCORRECT_GUESSES=6;
		System.out.println();
		while(new String(charc).contains("-") && incorrectGuesses < MAX_INCORRECT_GUESSES) {
			String s=scan.next();
			char ch=s.charAt(0);
			boolean corectguess=false;
			for(int i=0;i<randomelement.length();i++) {
				if(ch==Character.toLowerCase(randomelement.charAt(i))) {
					charc[i]=randomelement.charAt(i);
					corectguess=true;
				}
			}
			if (!corectguess) {
                incorrectGuesses++;
                System.out.println("Wrong guess! You have " + (MAX_INCORRECT_GUESSES - incorrectGuesses) + " attempts left.");
            }
			System.out.println(String.valueOf(charc));
			
		}
		if (new String(charc).equals(randomelement)) {
            System.out.println("Congratulations! You guessed the word: " + randomelement);
        } else {
            System.out.println("Game over! The correct word was: " + randomelement);
        }
	}

}
