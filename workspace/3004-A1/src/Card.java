public class Card implements Comparable<Card> {
	private int cardRank = 0;
	private String suit = "";
	private String rank = "";

	
	public Card(int cr, String ra, String su){
		cardRank = cr;
		suit = su;
		rank = ra;
		
	}

	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}

	public int getCardRank() {
		return cardRank;
	}

	@Override
	public int compareTo(Card o) {
		return Integer.compare(o.getCardRank(), this.getCardRank());
	}
}