import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest {
	Game g = new Game();

	@Test
	public void testNumberOfPlayersMax(){
		Round r = new Round(4);
		assertEquals(4,r.getPlayersSize());
	}
	@Test
	public void testNumberOfPlayersMin(){
		Round r = new Round(2);
		assertEquals(2,r.getPlayersSize());
	}
	@Test
	public void testAddPlayerHand() {
		Round r = new Round(2);
		r.addPlayerHand(0, "Jim", new Card[] { g.verifyNewCard("ThreeSpades"), g.verifyNewCard("FourSpades"),
				g.verifyNewCard("FiveSpades"), g.verifyNewCard("SixSpades"), g.verifyNewCard("SevenSpades") });
		r.addPlayerHand(1, "Jane", new Card[] { g.verifyNewCard("ThreeClubs"), g.verifyNewCard("FourClubs"),
				g.verifyNewCard("FiveClubs"), g.verifyNewCard("SixClubs"), g.verifyNewCard("SevenClubs") });
		assertEquals(2, r.players.length);
	}

	@Test
	public void testBetterHand() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoDiamonds"),
				g.verifyNewCard("ThreeHearts"), g.verifyNewCard("ThreeSpades"), g.verifyNewCard("TwoClubs") });
		Hand h2 = new Hand(new Card[] { g.verifyNewCard("FiveSpades"), g.verifyNewCard("AceSpades"),
				g.verifyNewCard("FourSpades"), g.verifyNewCard("SevenSpades"), g.verifyNewCard("JackSpades") });
		Hand[] hs = new Hand[] { h1, h2 };
		assertEquals(
				"1 | null | TwoHearts TwoDiamonds ThreeHearts ThreeSpades TwoClubs | Full House 7\n2 | null | FiveSpades AceSpades FourSpades SevenSpades JackSpades | Flush 5",
				r.betterHand(hs));
	}

	@Test
	public void testBetterHandSameRank() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("TwoClubs"),
				g.verifyNewCard("ThreeHearts"), g.verifyNewCard("ThreeSpades"), g.verifyNewCard("FiveSpades") });
		Hand h2 = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoDiamonds"),
				g.verifyNewCard("ThreeClubs"), g.verifyNewCard("ThreeDiamonds"), g.verifyNewCard("FourSpades") });
		Hand[] hs = new Hand[] { h1, h2 };
		assertEquals(
				"1 | null | TwoSpades TwoClubs ThreeHearts ThreeSpades FiveSpades | Two Pair 3\n2 | null | TwoHearts TwoDiamonds ThreeClubs ThreeDiamonds FourSpades | Two Pair 3",
				r.betterHand(hs));
	}

	@Test
	public void testBetterHandSameHands() {
		Round r = new Round(2);
		Hand h1 = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("TwoClubs"),
				g.verifyNewCard("ThreeHearts"), g.verifyNewCard("ThreeSpades"), g.verifyNewCard("FiveSpades") });
		Hand h2 = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoDiamonds"),
				g.verifyNewCard("ThreeClubs"), g.verifyNewCard("ThreeDiamonds"), g.verifyNewCard("FiveClubs") });
		Hand[] hs = new Hand[] { h1, h2 };
		assertEquals(
				"Tie | null | TwoSpades TwoClubs ThreeHearts ThreeSpades FiveSpades | Two Pair 3\nTie | null | TwoHearts TwoDiamonds ThreeClubs ThreeDiamonds FiveClubs | Two Pair 3",
				r.betterHand(hs));
	}
	
	@Test
	public void testAllHandsRankings(){
		Hand h1 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(13,"King","Spades"),new Card(12,"Queen","Spades"),new Card(11,"Jack","Spades"),new Card(10,"Ten","Spades")});
		Hand h2 = new Hand(new Card[]{new Card(9,"Nine","Spades"),new Card(13,"King","Spades"),new Card(12,"Queen","Spades"),new Card(11,"Jack","Spades"),new Card(10,"Ten","Spades")});
		Hand h3 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(14,"Ace","Diamonds"),new Card(14,"Ace","Clubs"),new Card(14,"Ace","Hearts"),new Card(10,"Ten","Spades")});
		Hand h4 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(14,"Ace","Diamonds"),new Card(14,"Ace","Clubs"),new Card(13,"King","Hearts"),new Card(13,"King","Spades")});
		Hand h5 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(14,"Ace","Diamonds"),new Card(14,"Ace","Clubs"),new Card(13,"King","Hearts"),new Card(12,"Queen","Spades")});
		Hand h6 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(13,"King","Spades"),new Card(12,"Queen","Spades"),new Card(11,"Jack","Spades"),new Card(8,"Eight","Spades")});
		Hand h7 = new Hand(new Card[]{new Card(9,"Nine","Diamonds"),new Card(13,"King","Spades"),new Card(12,"Queen","Spades"),new Card(11,"Jack","Spades"),new Card(10,"Ten","Spades")});
		Hand h8 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(14,"Ace","Diamonds"),new Card(13,"King","Hearts"),new Card(13,"King","Spades"),new Card(12,"Queen","Spades")});
		Hand h9 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(14,"Ace","Diamonds"),new Card(2,"Two","Hearts"),new Card(3,"Three","Spades"),new Card(12,"Queen","Spades")});
		Hand h10 = new Hand(new Card[]{new Card(14,"Ace","Spades"),new Card(8,"Eight","Diamonds"),new Card(2,"Two","Hearts"),new Card(3,"Three","Spades"),new Card(12,"Queen","Spades")});
		
		assertEquals(-1,h1.compareTo(h2));
		assertEquals(-1,h2.compareTo(h3));
		assertEquals(-1,h3.compareTo(h4));
		assertEquals(-1,h4.compareTo(h5));
		assertEquals(-1,h5.compareTo(h6));
		assertEquals(-1,h6.compareTo(h7));
		assertEquals(-1,h7.compareTo(h8));
		assertEquals(-1,h8.compareTo(h9));
		assertEquals(-1,h9.compareTo(h10));
	}
}