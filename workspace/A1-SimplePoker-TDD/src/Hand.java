
public class Hand {

	public Hand(Card[] c){
		cards = c;
		for(int i =0; i<c.length;i++){
			switch(c[i].getRank()){
			case "Two":cardArray[0]++;break;
			case "Three":cardArray[1]++;break;
			case "Four":cardArray[2]++;break;
			case "Five":cardArray[3]++;break;
			case "Six":cardArray[4]++;break;
			case "Seven":cardArray[5]++;break;
			case "Eight":cardArray[6]++;break;
			case "Nine":cardArray[7]++;break;
			case "Ten":cardArray[8]++;break;
			case "Jack":cardArray[9]++;break;
			case "Queen":cardArray[10]++;break;
			case "King":cardArray[11]++;break;
			case "Ace":cardArray[12]++;break;
			}
		}
	}
	
	public String getHand(){
		String value = "";
		for(int i=0; i<cards.length;i++){
			value += cards[i].getRank();
			value += cards[i].getSuit();
			if(i<cards.length-1)
				value += " ";
		}
		return value;
	}
	
	//Two is 0, Ace is 12
	public int printDups(int n){
		if(n>1 && n<(cardArray.length+3))
		  return cardArray[n-2];
		return 0;
	}
	
	
	private int[] cardArray= new int[13];
	private Card[] cards;
	public String getPokerHand() {
		
		//royal flush
		if(cardArray[12] == 1 && cardArray[11] == 1 && cardArray[10] == 1 && cardArray[9] == 1 && cardArray[8] == 1){
			if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit())
				return "Royal Flush";
		}
		
		//straight flush
		if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit()){
			int run = 0;
			for(int i=0;i<cardArray.length;i++){
				if(cardArray[i]==1)
					run++;
				else if(cardArray[i]==0)
					run = 0;
				if(run == 5)
					return "Straight Flush";
			}
		}
		
		//4OAK
		//3OAK
		//Full House
		for(int i=0;i<cardArray.length;i++){
			if(printDups(i) == 4){
				return "4 of a Kind";
			}
			
			if(printDups(i) == 3){
				for(int j=0;j<cardArray.length;j++){
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
		int run = 0;
		for(int i=0;i<cardArray.length;i++){
			if(cardArray[i]==1)
				run++;
			else if(cardArray[i]==0)
				run = 0;
			if(run == 5)
				return "Straight";
		}
	
		
		//2Pair
		//1Pair
		int pairs = 0;
		for(int i=0;i<cardArray.length; i++){
			System.out.println(pairs);
			if(cardArray[i]==2)
				pairs++;
			if(pairs == 2)
				return "Two Pair";
		}
		
		if(pairs == 1)
			return "One Pair";
		
		
		//HighCard
		return "High Card";
	}
	
	public String print(){
		return "" + getHand() + " " + getPokerHand();
		
	}
}
