public class Card implements Comparable<Card> {
	private int cardRank = 0;
	private String suit = "";
	private String rank = "";

	public Card(String s) {
		String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		for (String w : ranks) {
			int index = s.indexOf(w);
			if (index >= 0) {
				switch (w) {
				case "Ace":
					cardRank = 14;
					break;
				case "Two":
					cardRank = 2;
					break;
				case "Three":
					cardRank = 3;
					break;
				case "Four":
					cardRank = 4;
					break;
				case "Five":
					cardRank = 5;
					break;
				case "Six":
					cardRank = 6;
					break;
				case "Seven":
					cardRank = 7;
					break;
				case "Eight":
					cardRank = 8;
					break;
				case "Nine":
					cardRank = 9;
					break;
				case "Ten":
					cardRank = 10;
					break;
				case "Jack":
					cardRank = 11;
					break;
				case "Queen":
					cardRank = 12;
					break;
				case "King":
					cardRank = 13;
					break;
				}
				rank = w;
			}
		}
		for (String w : suits) {
			int index = s.indexOf(w);
			if (index >= 0) {
				suit = w;
			}
		}
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