import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void testRank() {
		Card c = new Card("TwoSpades");
		assertEquals("Two",c.getRank());
	}
	
	@Test
	public void testSuit() {
		Card c = new Card("TwoSpades"); 
		assertEquals("Spades",c.getSuit());
	}
	
	@Test
	public void testCardRank(){
		Card c = new Card("TwoSpades");
		assertEquals(2,c.getCardRank());
	}

}
