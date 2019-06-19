public class Card {

	private int val;
	private String faceVal = "";
	private String suitVal = "";

	public Card(int value, String suitVal) {
		val = value;
		this.suitVal = suitVal;
		if(val == 11)
			faceVal = "Jack";
		if(val == 12)
			faceVal = "Queen";
		if(val == 13)
			faceVal = "King";
		if(val == 14)
			faceVal = "Ace";
		if(val == 2)
			faceVal = "Two";
		if(val == 3)
			faceVal = "Three";
		if(val == 4)
			faceVal = "Four";
		if(val == 5)
			faceVal = "Five";
		if(val == 6)
			faceVal = "Six";
		if(val == 7)
			faceVal = "Seven";
		if(val == 8)
			faceVal = "Eight";
		if(val == 9)
			faceVal = "Nine";
		if(val == 10)
			faceVal = "Ten";
	}

	public int getVal() {
		return val;
	}

	public String getFaceVal() {
		return faceVal;
	}

	public String getSuitVal() {
		return suitVal;
	}
	public String toString() {
		return faceVal + suitVal;
	}
}