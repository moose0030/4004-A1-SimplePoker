import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest {

	@Test
	public void testAddPlayerHand() {
		Round r = new Round(2);
		for(int i=0;i<2;i++){
			r.addPlayerHand(i,new Card[]{new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades")});
		}
		assertEquals(2,r.players.length);
	}
	
	@Test
	public void testBetterHand(){
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("ThreeHearts"),new Card("ThreeSpades"),new Card("TwoSpades")});
		Hand h2 = new Hand(new Card[]{new Card("TwoSpades"),new Card("AceSpades"),new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("TwoSpades")});
		Hand[] hs = new Hand[]{h1,h2}; 
		System.out.println("Actual " + r.betterHand(hs));
		assertEquals("Full House",r.betterHand(hs));	
	}

}
