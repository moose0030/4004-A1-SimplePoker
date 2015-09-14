
public class Round {
	Player[] players;
	
	public Round(int n){
		players = new Player[n];
	}
	
	public void addPlayerHand(int id, Card[] cards){
		players[id] = new Player(String.valueOf(id),new Hand(cards));
	}
	
}
