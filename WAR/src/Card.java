public class Card {

	private int val;
	private String faceVal = "";
	private String suitVal = "";

	public Card(int value, String suitVal) {
		value = val;
		this.suitVal = suitVal;
	}

	public int getVal() {
		return val;
	}

	public String getFaceVal() {
		if(val == 11)
			faceVal = "J";
		else if(val == 12)
			faceVal = "Q";
		else if(val == 13)
			faceVal = "K";
		else if(val == 1)
			faceVal = "A";
			
		return faceVal;
	}

	public String getSuitVal() {
		return suitVal;
	}
}