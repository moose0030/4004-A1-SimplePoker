import java.util.Arrays;

public class Round {
	Hand[] players;

	public Round(int n) {
		players = new Hand[n];
	}

	public void addPlayerHand(int i, String s, Card[] cards) {
		players[i] = new Hand(cards, s);
	}

	public String betterHand(Hand[] h) {
		Arrays.sort(h);
		String s = "";
		int i = 1;
		for (int j =0; j<h.length;j++){
			if(j+1<h.length){
				if(h[j].compareTo(h[j+1])== 0){
					s += "Tie" + " | " + h[j].getID() + " | " + h[j].getHand() + " | " + h[j].getPokerHand() + " " + h[j].getHandRank() + "\n";
				
				}
				else{
					s += i + " | " + h[j].getID() + " | " + h[j].getHand() + " | " + h[j].getPokerHand() + " " + h[j].getHandRank() + "\n";
				}
						
					i++;
			}
		
			else if(j>0){
				if(h[j].compareTo(h[j-1])== 0)
					s += "Tie" + " | " + h[j].getID() + " | " + h[j].getHand() + " | " + h[j].getPokerHand() + " " + h[j].getHandRank() + "\n";
				else
					s += i + " | " + h[j].getID() + " | " + h[j].getHand() + " | " + h[j].getPokerHand() + " " + h[j].getHandRank() + "\n";
				i++;
			}
		
			
			//i++;
		}
		s = s.trim();
		return s;
	}
}
