import java.util.ArrayList;

public class Player {

	ArrayList<Card> hand = new ArrayList<Card>();
	String name = "";
	
	public Player(String name) {
		this.name = name;
	}
	public Card getCard(){
		return hand.get(0);
	}
	public void setCard(Card x){
		x = hand.get(0);
		hand.set(hand.size(), x);
	}
	public void setCard(ArrayList<Card> x) {
		 
	}
}