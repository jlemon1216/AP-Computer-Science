import java.util.Random;
import java.util.Scanner;
public class EightBall {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the 8 Ball! Please ask your question.");
		String s = scan.nextLine();
		Random eightball = new Random();
		while(!s.equals("")){
		int i = eightball.nextInt(9);
		
		if(i == 1)
			System.out.println("Try Again Later.");
		else if(i == 2)
			System.out.println("Yes");
		else if(i == 3)
			System.out.println("No");
		else if(i == 4)
			System.out.println("There's an obvious answer.");
		else if(i == 5)
			System.out.println("You will never find out.");
		else if(i == 6)
			System.out.println("I don't know I'm just a ball");
		else if(i == 7)
			System.out.println("Maybe");
		else if(i == 8)
			System.out.println("Go away.");
		scan.nextLine();
		}
		
	}
}