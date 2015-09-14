
public class Card {

	Card(String s){
		
		String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten", "Jack","Queen","King"};
		String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
		for (String w : ranks) {
		    int index = s.indexOf(w);
		    if (index >= 0) {
		        s = s.substring(0, index) + s.substring(index + w.length());
		        rank = w;
		    }
		}
		for (String w : suits) {
		    int index = s.indexOf(w);
		    if (index >= 0) {
		        s = s.substring(0, index) + s.substring(index + w.length());
		        suit = w;
		    }
		}
	}
	
	public String getSuit(){
		return suit;
	}
	
	public String getRank(){
		return rank;
	}
	
	private String suit = "";
	private String rank = "";
}
