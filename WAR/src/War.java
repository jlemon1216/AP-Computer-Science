import java.util.ArrayList;
import java.util.Scanner;

public class War {

	Scanner s = new Scanner(System.in);
	War game = new War();
	ArrayList<Player> playerList = new ArrayList<Player>();
	Deck theDeck;
	ArrayList<Card> faceDown = new ArrayList<Card>();
	
	public War() {
		
	}
	public void runGame() {
		
	}
	public void numPlayers() {
		System.out.println("Enter the number of players: ");
		int x = s.nextInt();
		for(int i = 1; i <= x; i++) {
			System.out.println("Enter name for Player " + i);
			String name = s.nextLine();
			Player y = new Player(name);
			playerList.add(y);
		}
	}
	public void deal() {
		for(int i = 0; i < playerList.size(); i++) {
			playerList.get(i).hand.add(theDeck.get(0));
		}
		
		
	}
	public void play() {
		
	}
	public void war(ArrayList<Player> tempPlayer) {
		
	}
}