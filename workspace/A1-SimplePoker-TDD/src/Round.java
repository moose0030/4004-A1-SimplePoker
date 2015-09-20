import java.util.Arrays;
public class Round {
	Hand[] players;
	
	public Round(int n){
		players = new Hand[n];
	}
	
	public void addPlayerHand(int id, Card[] cards){
		players[id] = new Hand(cards,id);
	}
	
	public String betterHand(Hand[] hands){
		Arrays.sort(hands);
		String s="";
		for(Hand h: hands){
			s+=h.getHand() + " " + h.getPokerHand() + " " +h.getHandRank() + " " + String.valueOf(h.getHighCardRank()) + "\n";
		}
		s = s.trim();
		return s;
	}	
}
