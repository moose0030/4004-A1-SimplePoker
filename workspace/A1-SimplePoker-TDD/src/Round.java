
public class Round {
	Player[] players;
	
	public Round(int n){
		players = new Player[n];
	}
	
	public void addPlayerHand(int id, Card[] cards){
		players[id] = new Player(String.valueOf(id),new Hand(cards));
	}
	
	public String betterHand(Hand[] hands){
		/*System.out.println(hands[0].getPokerHand());
		System.out.println(hands[1].getPokerHand());
		Hand[] possibleHands = new Hand[10];
		
		for(int i=0; i<hands.length;i++){
			switch(hands[i].getPokerHand()){
			case "Royal Flush": possibleHands[0] = hands[i];break;
			case "Straight Flush": possibleHands[1] = hands[i];break;
			case "Four of a Kind": possibleHands[2] = hands[i];break;
			case "Full House": possibleHands[3] = hands[i];break;
			case "Flush": possibleHands[4] = hands[i];break;
			case "Straight": possibleHands[5] = hands[i];break;
			case "Three of a Kind": possibleHands[6] = hands[i];break;
			case "Two Pair": possibleHands[7] = hands[i];break;
			case "One Pair": possibleHands[8] = hands[i];break;
			case "High Card": possibleHands[9] = hands[i];break;
			}
		}
		
		System.out.println(possibleHands.length);
		for(int i=0; i<possibleHands.length; i++){
			System.out.println(possibleHands[i].getPokerHand());
		*/
			
		//}
		return "Invalid Hand";
		
	}
	
}
