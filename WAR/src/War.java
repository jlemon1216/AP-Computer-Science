import java.util.ArrayList;
import java.util.Scanner;

public class War {

	Scanner s = new Scanner(System.in);
	ArrayList<Player> playerList = new ArrayList<Player>();
	Deck theDeck;
	ArrayList<Card> faceDown = new ArrayList<Card>();
	ArrayList<Card> playedCards = new ArrayList<Card>();
	ArrayList<Player> warPlayers = new ArrayList<Player>();
	boolean tie = false;

	public War() {

	}

	public void runGame() {
		numPlayers();
		theDeck = new Deck();
		theDeck.shuffle();
		deal();
		play();

	}

	public void numPlayers() {
		System.out.println("Enter the number of players: ");
		int x = s.nextInt();
		for (int i = 0; i < x; i++) {
			System.out.println("Enter a name for the player");
			String name = s.next();
			Player y = new Player(name);
			playerList.add(y);

		}
	}

	public void deal() {
		int i = 0;
		while (theDeck.theDeck.size() > 0) {
			if (i == playerList.size())
				i = 0;
			playerList.get(i).hand.add(theDeck.getCard());
			i++;
		}
	}

	public void play() {
		for (int i = 0; i < playerList.size(); i++) {
			playedCards.add(playerList.get(i).getCard());
			System.out.println();
			System.out.println(playerList.get(i).name + " Played: " + playedCards.get(i) + " 		" + playerList.get(i).hand.size() + " Cards remaining." );
		}
		boolean b = result();
		if (!b) {
			System.out.println("\nWAR!\n");
			war();
		} else {
			System.out.println("Winner of Round: " + warPlayers.get(0));
			warPlayers.get(0).setCard(playedCards);
			playedCards.removeAll(playedCards);
			warPlayers.remove(0);
		}
		for (int x = 0; x < playerList.size(); x++) {
			if (playerList.get(x).hand.size() == 0) {
				System.out.println("\n" + playerList.get(x) + " Is Out!\n");
				playerList.remove(x);
				x=0;
			}
		}
		if (playerList.size() == 1) {
			System.out.println(playerList.get(0) + " Wins!");
		}
	}

	public boolean result() {
		int max = findMax(playedCards);
		for (int i = 0; i < playedCards.size(); i++) {
			if (playedCards.get(i).getVal() == max) {
				warPlayers.add(playerList.get(i));
			}
		}
		if (warPlayers.size() > 1)
			return false;
		return true;
	}
	public boolean warResult() {
		int max = findMax(playedCards);
		for (int i = 0; i < playedCards.size(); i++) {
			if (playedCards.get(i).getVal() != max) {
				faceDown.add(playedCards.get(i));
				playedCards.remove(i);
				warPlayers.remove(i);
			}
		}
		if (warPlayers.size() > 1)
			return false;
		return true;
	}

	public int findMax(ArrayList<Card> x) { // takes array of currently played cards, finds maximum value
		Card max = x.get(0);
		for (int i = 0; i < x.size(); i++) {
			if (max.getVal() <= x.get(i).getVal()) {
				max = x.get(i);
			}
		}
		return max.getVal();
	}

	public void war() {
		faceDown.addAll(playedCards);
		playedCards.removeAll(playedCards);
		for (int i = 0; i < warPlayers.size(); i++) {
			int x = 0;
			while (x < 3 && (warPlayers.get(i).hand.size() > 1)) {
				faceDown.add(warPlayers.get(i).getCard());
				x++;
			}
			System.out.println(warPlayers.get(i) + " Has placed face-down cards!");
			x = 0;
		}
		for (int z = 0; z < warPlayers.size(); z++) {
			playedCards.add(warPlayers.get(z).getCard());
			System.out.println();
			System.out.println(warPlayers.get(z).name + " Played: " + playedCards.get(z));
		}
		boolean b = warResult();
		if (!b) {
			for(int y = 0; y < warPlayers.size(); y++) {
				if(warPlayers.get(y).hand.size() == 0) {
					warPlayers.remove(warPlayers.get(y));
				}
			}
			faceDown.addAll(playedCards);
			playedCards.removeAll(playedCards);
			System.out.println("\nWAR AGAIN!\n");
			war();
		} else {
			System.out.println("\nWinner of Round: " + warPlayers.get(0));
			warPlayers.get(0).setCard(playedCards);
			warPlayers.get(0).setCard(faceDown);
			playedCards.removeAll(playedCards);
			warPlayers.remove(0);
			
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		War game = new War();
		game.runGame();
		while (true) {
			System.out.println("\nType \"F\" to play the next Round!");
			String input = scan.next();
			if (input.equalsIgnoreCase("F")) {
				game.play();
			}

		}

	}
}