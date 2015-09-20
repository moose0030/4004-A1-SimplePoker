/*public class Player {
	String id;
	Hand hand;
	
	public Player(String i, Hand h){
		id = i;
		hand = h;
	}
	
	public Player(String[] strings){
		if(strings.length == 6){
			id = strings[0];
			hand = new Hand(new Card[]{new Card(strings[1]),new Card(strings[2]),new Card(strings[3]),new Card(strings[4]),new Card(strings[5])});
		}
		else
		{
			id = null;
			hand = null;
		}
	}

	public String getId() {
		return id;
	}

	public Hand getHand() {
		return hand;
	}
	
}
*/