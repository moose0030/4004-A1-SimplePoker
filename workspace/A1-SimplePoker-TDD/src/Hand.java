import java.util.Arrays;
public class Hand implements Comparable<Hand>{
	private int[] cardArray= new int[13];
	private Card[] cards;
	private int handRank = 0;
	private int highCardRank =0;
	
	public Hand(Card[] c){
		cards = c;
		for(int i =0; i<c.length;i++){
			switch(c[i].getRank()){
			case "Two":  cardArray[0]++; break;
			case "Three":cardArray[1]++; break;
			case "Four": cardArray[2]++; break;
			case "Five": cardArray[3]++; break;
			case "Six":  cardArray[4]++; break;
			case "Seven":cardArray[5]++; break;
			case "Eight":cardArray[6]++; break;
			case "Nine": cardArray[7]++; break;
			case "Ten":  cardArray[8]++; break;
			case "Jack": cardArray[9]++; break;
			case "Queen":cardArray[10]++;break;
			case "King": cardArray[11]++;break;
			case "Ace":  cardArray[12]++;break;
			}
		}
		calculateHand();
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
	public int printCardArray(int n){
		if(n>1 && n<(cardArray.length+3))
		  return cardArray[n-2];
		return 0;
	}
	
	public void calculateHand() {
		if(isRoyalFlush()){
			return;
		}
		if(isStraightFlush()){
			return;
		}
		if(isOAKFullHouse()){
			return;
		}
		if(isFlush()){	
			return;
		}
		if(isStraight()){
			return;
		}
		if(isPairs()){
			return;
		}		
		handRank = 1;
	}
	
	private boolean isPairs() {
		int pairs = 0;
		for(int i=0;i<cardArray.length; i++){
			if(cardArray[i]==2)
				pairs++;
			if(pairs == 2){
				handRank = 3;
				return true;
			}
		}
		if(pairs == 1)
		{
			handRank = 2;
			return true;
		}
		return false;
	}

	private boolean isOAKFullHouse() {
		for(int i=0;i<cardArray.length;i++){
			if(printCardArray(i) == 4){
				handRank = 8;
				return true;
			}
			
			if(printCardArray(i) == 3){
				for(int j=0;j<cardArray.length;j++){
					if(printCardArray(j) == 2){
						handRank = 7;
						return true;
					}
				}
				handRank = 6;
				return true;
			}
		}
		return false;
	}

	private boolean isStraight(){
		int run = 0;
		for(int i=0;i<cardArray.length;i++){
			if(cardArray[i]==1)
				run++;
			else if(cardArray[i]==0)
				run = 0;
			if(run == 5){
				handRank=4;
				return true;
			}
		}
		return false;
	}
	
	private boolean isStraightFlush() {
		if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit()){
			int run = 0;
			for(int i=0;i<cardArray.length;i++){
				if(cardArray[i]==1)
					run++;
				else if(cardArray[i]==0)
					run = 0;
				if(run == 5){
					handRank = 9;
					return true;
				}
			}
		}
		return false;
	}

	private boolean isRoyalFlush(){
		if(cardArray[12] == 1 && cardArray[11] == 1 && cardArray[10] == 1 && cardArray[9] == 1 && cardArray[8] == 1){
			if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit()){
				handRank = 10;
				return true;
			}
		}
		return false;
	}
	
	private boolean isFlush(){
		if(cards[0].getSuit() == cards[1].getSuit() && cards[0].getSuit() == cards[2].getSuit() && cards[0].getSuit() == cards[3].getSuit() && cards[0].getSuit() == cards[4].getSuit()){
			handRank = 5;
			return true;
		}
		return false;
	}
	
	public String getPokerHand(){
		switch(handRank){
		case 1:return "High Card";
		case 2:return "One Pair";
		case 3:return "Two Pair";
		case 4:return "Straight";
		case 5:return "Flush";
		case 6:return "Three of a Kind";
		case 7:return "Full House";
		case 8:return "Four of a Kind";
		case 9:return "Straight Flush";
		case 10:return "Royal Flush";
		default: return "";
		}
		
	}
	
	public String print(){
		return "" + getHand() + " " + getPokerHand();
	}

	public int getHandRank() {
		return handRank;
	}

	public int getHighCardRank(){	
		for(int i=cardArray.length-1;i>0;i--)
		{
			if(cardArray[i]==1){
				highCardRank =(i+2);
				return highCardRank;
			}
		}
		return 0;
	}
	
	public void sortCardsDesc(){
		Arrays.sort(cards);
		for(int i=0;i<cards.length;i++){
			System.out.println(cards[i].getCardRank());
		}	
	}

	@Override
	public int compareTo(Hand o) {
		return Integer.compare(this.handRank, o.handRank);
	}
}