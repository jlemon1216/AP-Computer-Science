import java.util.ArrayList;

public class Deck {

	ArrayList<Card> theDeck = new ArrayList<Card>();
	
	public Deck(){
		for(int c = 0; c < 4; c++) {
			for(int numVal = 1; numVal < 14; numVal++) {
				if(c == 0)
					theDeck.add(new Card(numVal, "Spades"));
				else if(c == 1)
					theDeck.add(new Card(numVal, "Hearts"));
				else if(c == 2)
					theDeck.add(new Card(numVal, "Diamonds"));
				else if(c == 3)
					theDeck.add(new Card(numVal, "Clubs"));
			}
		}
	}
	public void shuffle() {
		
		for(int shuffle = 0; shuffle < 10; shuffle++) {
			for(int swap = 0; swap < 101; swap++) {
				int flip1 = (int)Math.random()*53;
				int flip2 = (int)Math.random()*53;
				Card temp = theDeck.get(flip2);
				theDeck.set(flip1, temp);
				theDeck.remove(flip2);
				theDeck.set(flip2, theDeck.get(flip1));
			}
		}
		
	}
	public Card getCard() {
		return theDeck.remove(0);
		
	}
	public void setCard(Card x) {
		theDeck.add(52, x);  
	}
	public int getSize(ArrayList<Card> x) {
		return theDeck.size();
	}
}