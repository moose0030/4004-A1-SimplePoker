import java.util.Arrays;

public class Round {
	Player[] players;
	
	public Round(int n){
		players = new Player[n];
	}
	
	public void addPlayerHand(int id, Card[] cards){
		players[id] = new Player(String.valueOf(id),new Hand(cards));
	}
	
	public String betterHand(Hand[] hands){
		Arrays.sort(hands);
		String s="";
		for(Hand h: hands){
			s+=h.getHand() +" "+h.getPokerHand()+" " +h.getHandRank() + "\n";
		}
		return s;
	}
	
}
