import static org.junit.Assert.*;

import org.junit.*;

public class CardTest {
	Game g = new Game();

	@Test
	public void testRank() {
		Card c = g.verifyNewCard("TwoSpades");
		assertEquals("Two", c.getRank());
	}

	@Test
	public void testSuit() {
		Card c = g.verifyNewCard("TwoSpades");
		assertEquals("Spades", c.getSuit());
	}

	@Test
	public void testCardRank() {
		Card c = g.verifyNewCard("TwoSpades");
		assertEquals(2, c.getCardRank());
	}

	public void checkCardValidity() {
		assertEquals(true, g.verifyNewCard("TwoSpades"));
	}

	public void checkCardValidity2() {
		Card c = g.verifyNewCard("TwoSpades");
		assertEquals(false, g.verifyNewCard("TwoSpades"));
	}

	public void checkCardValidity3() {
		assertEquals(null, g.verifyNewCard("TwoSpiders"));
	}

	public void checkCardValidity4() {
		assertEquals(null, g.verifyNewCard("OneSpades"));
	}
}