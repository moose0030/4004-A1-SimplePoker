import static org.junit.Assert.*;

import org.junit.*;

public class CardTest {

	@Test
	public void testRank() {
		Card c = new Card("TwoSpades");
		assertEquals("Two", c.getRank());
	}

	@Test
	public void testSuit() {
		Card c = new Card("TwoSpades");
		assertEquals("Spades", c.getSuit());
	}

	@Test
	public void testCardRank() {
		Card c = new Card("TwoSpades");
		assertEquals(2, c.getCardRank());
	}
	
	public void checkCardValidity(){
		Card c = new Card("TwoSpades");
		assertEquals(true, c.checkCardValidity("TwoSpades"));
	}
	
	public void checkCardValidity2(){
		Card c = new Card("TwoSpiders");
		assertEquals(false, c.checkCardValidity("TwoSpades"));
	}
	
	public void checkCardValidity3(){
		Card c = new Card("OneSpades");
		assertEquals(false, c.checkCardValidity("TwoSpades"));
	}
	
	

}
