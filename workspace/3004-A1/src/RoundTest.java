import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest {

	@Test
	public void testAddPlayerHand() {
		Round r = new Round(2);
		for (int i = 0; i < 2; i++) {
			r.addPlayerHand(i, "Jim", new Card[] { new Card("ThreeSpades"), new Card("ThreeSpades"),
					new Card("ThreeSpades"), new Card("ThreeSpades"), new Card("ThreeSpades") });
		}
		assertEquals(2, r.players.length);
	}

	@Test
	public void testBetterHand() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { new Card("TwoSpades"), new Card("TwoSpades"), new Card("ThreeHearts"),
				new Card("ThreeSpades"), new Card("TwoSpades") });
		Hand h2 = new Hand(new Card[] { new Card("TwoSpades"), new Card("AceSpades"), new Card("ThreeSpades"),
				new Card("ThreeSpades"), new Card("TwoSpades") });
		Hand[] hs = new Hand[] { h1, h2 };
		// need to fix for straigh and flush
		System.out.println(r.betterHand(hs));
		assertEquals(
				"1 | null | TwoSpades TwoSpades ThreeHearts ThreeSpades TwoSpades | Full House 7\n2 | null | TwoSpades AceSpades ThreeSpades ThreeSpades TwoSpades | Flush 5",
				r.betterHand(hs));
	}

	@Test
	public void testBetterHandSameRank() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { new Card("TwoSpades"), new Card("TwoSpades"), new Card("ThreeHearts"),
				new Card("ThreeSpades"), new Card("TwoSpades") });
		Hand h2 = new Hand(new Card[] { new Card("FourSpades"), new Card("FourSpades"), new Card("ThreeHearts"),
				new Card("ThreeSpades"), new Card("FourSpades") });
		Hand[] hs = new Hand[] { h1, h2 };
		 System.out.println(r.betterHand(hs));
		assertEquals(
				"1 | null | FourSpades FourSpades ThreeHearts ThreeSpades FourSpades | Full House 7\n2 | null | TwoSpades TwoSpades ThreeHearts ThreeSpades TwoSpades | Full House 7",
				r.betterHand(hs));
	}
	
	@Test
	public void testBetterHandSameHands() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { new Card("TwoSpades"), new Card("TwoSpades"), new Card("ThreeHearts"),
				new Card("ThreeSpades"), new Card("TwoSpades") });
		Hand h2 = new Hand(new Card[] { new Card("TwoSpades"), new Card("TwoSpades"), new Card("ThreeHearts"),
				new Card("ThreeSpades"), new Card("TwoSpades") });
		Hand[] hs = new Hand[] { h1, h2 };
		assertEquals(
				"Tie | null | TwoSpades TwoSpades ThreeHearts ThreeSpades TwoSpades | Full House 7\nTie | null | TwoSpades TwoSpades ThreeHearts ThreeSpades TwoSpades | Full House 7",
				r.betterHand(hs));
	}

}
