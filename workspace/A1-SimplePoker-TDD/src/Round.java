import java.util.Arrays;
public class Round {
	Hand[] players;
	
	public Round(int n){
		players = new Hand[n];
	}
	
	public void addPlayerHand(int i,String s, Card[] cards){
		players[i] = new Hand(cards,s);
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
