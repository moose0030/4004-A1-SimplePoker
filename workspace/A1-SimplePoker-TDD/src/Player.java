
public class Player {
	String id;
	Hand hand;
	
	public Player(String i, Hand h){
		id = i;
		hand = h;
	}

	public String getId() {
		return id;
	}

	public Hand getHand() {
		return hand;
	}
	
}
