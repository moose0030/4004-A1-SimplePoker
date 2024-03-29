import java.util.Arrays;
public class Hand implements Comparable<Hand>{
	private int[] cardArray= new int[13];
	private Card[] cards;
	private int handRank = 0;
	private String id;
	
	public Hand(Card[] c){
		cards = c;
		for(int i =0; i<c.length;i++){
			cardArray[(c[i].getCardRank()-2)]++;
		}
		calculateHand();
	}
	
	public Hand(Card[] c, String s){
		cards = c;
		id = s;
		for(int i =0; i<c.length;i++){
			cardArray[(c[i].getCardRank()-2)]++;
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
	public String getID(){
		return id;
	}
	
	//Two is 0, Ace is 12
	public int getCardArrayAtIndex(int n){
		if(n>-1 && n<cardArray.length)
		  return cardArray[n];
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
			if(getCardArrayAtIndex(i) == 4){
				handRank = 8;
				return true;
			}
			
			if(getCardArrayAtIndex(i) == 3){
				for(int j=0;j<cardArray.length;j++){
					if(getCardArrayAtIndex(j) == 2){
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

	
	
	public void sortCardsDesc(){
		Arrays.sort(cards);
	}		

	@Override
	public int compareTo(Hand o){
		//compare hand rank
		int n = Integer.compare(o.handRank,this.handRank);
		int n1=0,n2=0,oIndex=0,thisIndex = 0;
		if(n == 0)
		{
			//go through all cards for 4,3,2,1
			for(int c=4;c>1;c--){
			for(int i=12; i>0;i--){
				oIndex = o.getCardArrayAtIndex(i);
				thisIndex = this.getCardArrayAtIndex(i);
			
				if(oIndex == c){
					n1 = oIndex;
				}
				if(thisIndex == c){
					n2 = thisIndex;
				}
			if(Integer.compare(n1,n2)!=0){
				return Integer.compare(n1, n2);
			}
			}
		}
			
		}
		return n;
	}
}