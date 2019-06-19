import java.util.ArrayList;

public class Deck {

	ArrayList<Card> theDeck = new ArrayList<Card>();

	public Deck() {
		for (int c = 0; c < 4; c++) {
			for (int numVal = 2; numVal < 15; numVal++) {
				if (c == 0)
					theDeck.add(new Card(numVal, " of Spades"));
				if (c == 1)
					theDeck.add(new Card(numVal, " of Hearts"));
				if (c == 2)
					theDeck.add(new Card(numVal, " of Diamonds"));
				if (c == 3)
					theDeck.add(new Card(numVal, " of Clubs"));
			}
		}
	}

	public void shuffle() {
		for (int shuffle = 0; shuffle < 10; shuffle++) {
			for (int swap = 0; swap < 100; swap++) {
				double flip1 = Math.random() * 52;
				int flip2 = (int)flip1;
				Card temp = theDeck.get(0);
				theDeck.remove(0);
				theDeck.add(flip2, temp);
			}
		}

	}

	public Card getCard() {
		return theDeck.remove(0);

	}

	public void setCard(Card x) {
		theDeck.add(52, x);
	}

	public int getSize() {
		return theDeck.size();
	}
}