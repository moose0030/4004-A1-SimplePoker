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
		String s = "";
		s += "Rank |    ID    |                     Hand                   |\n";
		int i = 1;
		for(Hand h: hands){
			s += "  " + i + "  | "+ h.getID() + " | " + h.getHand() + " " + h.getPokerHand() + " " +h.getHandRank() + " " + String.valueOf(h.getHighCardRank()) + "\n";
			i++;
		}
		s = s.trim();
		return s;
	}	
}
