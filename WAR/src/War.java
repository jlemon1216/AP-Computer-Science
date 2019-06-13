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
		numPlayers();
		theDeck = new Deck();

	}

	public void numPlayers() {
		System.out.println("Enter the number of players: ");
		int x = s.nextInt();
		for (int i = 1; i <= x; i++) {
			System.out.println("Enter name for Player " + i);
			String name = s.nextLine();
			Player y = new Player(name);
			playerList.add(y);
		}
	}

	public void deal() {
		int i = 0;
		while(theDeck.theDeck.size()> 0) {
				if(i == playerList.size())
					i = 0;
				playerList.get(i).hand.add(theDeck.getCard());
				i++;
			}
	}

	public void play() {
		ArrayList<Card> playedCards = new ArrayList<Card>();
		for(int i = 0; i < playerList.size(); i++) {
			playedCards.add(playerList.get(i).getCard());
		}

	}
	public void findWinner(ArrayList<Card> x) {
		Card winner = x.get(0);
		for(int i = 1; i < playerList.size(); i++) {
			int y = x.get(i).getVal();
			if(x.get(i).getVal() == 1)
				y = 14;
			if(x.get(i).getVal() > winner.getVal()) {
				winner = x.get(i);
			}
			if(x.get(i).getVal() == winner.getVal()) {
				war();
			}
		}
	}

	public void war(ArrayList<Player> tempPlayer) {
		

	}
}