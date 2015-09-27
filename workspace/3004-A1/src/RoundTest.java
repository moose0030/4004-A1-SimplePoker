import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest {
	Game g = new Game();
	@Test
	public void testAddPlayerHand() {
		Round r = new Round(2);
		r.addPlayerHand(0, "Jim", new Card[] { g.verifyNewCard("ThreeSpades"), g.verifyNewCard("FourSpades"),g.verifyNewCard("FiveSpades"), g.verifyNewCard("SixSpades"), g.verifyNewCard("SevenSpades") });
		r.addPlayerHand(1, "Jane", new Card[] { g.verifyNewCard("ThreeClubs"), g.verifyNewCard("FourClubs"),g.verifyNewCard("FiveClubs"), g.verifyNewCard("SixClubs"), g.verifyNewCard("SevenClubs") });
		assertEquals(2, r.players.length);
	}

	@Test
	public void testBetterHand() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoDiamonds"), g.verifyNewCard("ThreeHearts"),g.verifyNewCard("ThreeSpades"), g.verifyNewCard("TwoClubs") });
		Hand h2 = new Hand(new Card[] { g.verifyNewCard("FiveSpades"), g.verifyNewCard("AceSpades"), g.verifyNewCard("FourSpades"),g.verifyNewCard("SevenSpades"), g.verifyNewCard("JackSpades") });
		Hand[] hs = new Hand[] { h1, h2 };
		assertEquals("1 | null | TwoHearts TwoDiamonds ThreeHearts ThreeSpades TwoClubs | Full House 7\n2 | null | FiveSpades AceSpades FourSpades SevenSpades JackSpades | Flush 5",r.betterHand(hs));
	}

	@Test
	public void testBetterHandSameRank() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("TwoClubs"), g.verifyNewCard("ThreeHearts"),g.verifyNewCard("ThreeSpades"), g.verifyNewCard("FiveSpades") });
		Hand h2 = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoDiamonds"), g.verifyNewCard("ThreeClubs"),g.verifyNewCard("ThreeDiamonds"), g.verifyNewCard("FourSpades") });
		Hand[] hs = new Hand[] { h1, h2 };
		assertEquals("1 | null | TwoSpades TwoClubs ThreeHearts ThreeSpades FiveSpades | Two Pair 3\n2 | null | TwoHearts TwoDiamonds ThreeClubs ThreeDiamonds FourSpades | Two Pair 3",r.betterHand(hs));
	}
	
	@Test
	public void testBetterHandSameHands() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("TwoClubs"), g.verifyNewCard("ThreeHearts"),g.verifyNewCard("ThreeSpades"), g.verifyNewCard("FiveSpades") });
		Hand h2 = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoDiamonds"), g.verifyNewCard("ThreeClubs"),g.verifyNewCard("ThreeDiamonds"), g.verifyNewCard("FiveClubs") });
		Hand[] hs = new Hand[] { h1, h2 };
		assertEquals("Tie | null | TwoSpades TwoClubs ThreeHearts ThreeSpades FiveSpades | Two Pair 3\nTie | null | TwoHearts TwoDiamonds ThreeClubs ThreeDiamonds FiveClubs | Two Pair 3",r.betterHand(hs));
	}

}
