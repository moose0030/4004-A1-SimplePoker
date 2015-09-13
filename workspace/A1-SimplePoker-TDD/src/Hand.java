
public class Hand {

	public Hand(Card[] c){
		cards = c;
		for(int i =0; i<c.length;i++){
			switch(c[i].getRank()){
			case "Two":duplicates[0]++;break;
			case "Three":duplicates[1]++;break;
			case "Four":duplicates[2]++;break;
			case "Five":duplicates[3]++;break;
			case "Six":duplicates[4]++;break;
			case "Seven":duplicates[5]++;break;
			case "Eight":duplicates[6]++;break;
			case "Nine":duplicates[7]++;break;
			case "Ten":duplicates[8]++;break;
			case "Jack":duplicates[9]++;break;
			case "Queen":duplicates[10]++;break;
			case "King":duplicates[11]++;break;
			case "Ace":duplicates[12]++;break;
			}
		}
	}
	
	public String getHand(){
		String value = "";
		for(int i=0; i<cards.length;i++){
			value += cards[i].getRank();
			value += cards[i].getSuit();
			if(i<cards.length-1)
				value += ",";
		}
		return value;
	}
	
	//Two is 0, Ace is 12
	public int printDups(int n){
		if(n>1 && n<(duplicates.length+3))
		  return duplicates[n-2];
		return 0;
	}
	
	
	private int[] duplicates = new int[13];
	private Card[] cards;
	public String getPokerHand() {
		
		//royal flush
		if(duplicates[12] == 1 && duplicates[11] == 1 && duplicates[10] == 1 && duplicates[9] == 1 && duplicates[8] == 1){
			if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit())
				return "Royal Flush";
		}
		
		//straight flush
		
		//4OAK
		//3OAK
		//Full House
		for(int i=0;i<duplicates.length;i++){
			if(printDups(i) == 4){
				return "4 of a Kind";
			}
			
			if(printDups(i) == 3){
				for(int j=0;j<duplicates.length;j++){
					if(printDups(j) == 2){
						return "Full House";
					}
				}
				return "3 of a Kind";
			}
		}
		
		
		//flush
		if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit())
			return "Flush";
		
		//straight
		
		//2Pair
		
		//1Pair
		
		//HighCard
		
		return "High Card";
	} 
}
