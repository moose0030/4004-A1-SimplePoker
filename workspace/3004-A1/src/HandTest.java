import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {
	Game g = new Game();

	@Test
	public void testGetHand() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), Game.verifyNewCard("TwoDiamonds"),
				g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoClubs"), g.verifyNewCard("ThreeHearts") });
		assertEquals("TwoSpades TwoDiamonds TwoHearts TwoClubs ThreeHearts", h.getHand());
	}

	@Test
	public void testGetID() {
		Hand h = new Hand(
				new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("ThreeSpades"),
						g.verifyNewCard("FourSpades"), g.verifyNewCard("AceSpades"), g.verifyNewCard("JackSpades") },
				"2");
		assertEquals("2", h.getID());
	}

	@Test
	public void testNumberTwos() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("TwoDiamonds"),
				g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoClubs"), g.verifyNewCard("ThreeHearts") });
		assertEquals(4, h.getCardArrayAtIndex(1));
	}

	@Test
	public void testRoyalFlush() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("AceSpades"), g.verifyNewCard("QueenSpades"),
				g.verifyNewCard("KingSpades"), g.verifyNewCard("JackSpades"), g.verifyNewCard("TenSpades") });
		assertEquals("Royal Flush", h.getPokerHand());
	}

	@Test
	public void test4OAK() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("ThreeHearts"), g.verifyNewCard("TwoSpades"),
				g.verifyNewCard("TwoClubs"), g.verifyNewCard("TwoDiamonds"), g.verifyNewCard("TwoHearts") });
		assertEquals("Four of a Kind", h.getPokerHand());
	}

	@Test
	public void test3OAK() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("ThreeHearts"), g.verifyNewCard("KingClubs"),
				g.verifyNewCard("TwoClubs"), g.verifyNewCard("TwoDiamonds"), g.verifyNewCard("TwoHearts") });
		assertEquals("Three of a Kind", h.getPokerHand());
	}

	@Test
	public void testFullHouse() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("ThreeHearts"), g.verifyNewCard("ThreeDiamonds"),
				g.verifyNewCard("TwoClubs"), g.verifyNewCard("TwoDiamonds"), g.verifyNewCard("TwoSpades") });
		assertEquals("Full House", h.getPokerHand());
	}

	@Test
	public void testFlush() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("AceSpades"), g.verifyNewCard("TwoSpades"),
				g.verifyNewCard("FourSpades"), g.verifyNewCard("SevenSpades"), g.verifyNewCard("TenSpades") });
		assertEquals("Flush", h.getPokerHand());
	}

	@Test
	public void testStraightFlush() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("ThreeSpades"),
				g.verifyNewCard("FiveSpades"), g.verifyNewCard("FourSpades"), g.verifyNewCard("SixSpades") });
		assertEquals("Straight Flush", h.getPokerHand());
	}

	@Test
	public void testStraight() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("ThreeSpades"),
				g.verifyNewCard("FiveSpades"), g.verifyNewCard("FourSpades"), g.verifyNewCard("SixSpades") });
		assertEquals("Straight", h.getPokerHand());
	}

	@Test
	public void test2Pair() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoSpades"), g.verifyNewCard("TwoClubs"),
				g.verifyNewCard("ThreeSpades"), g.verifyNewCard("ThreeHearts"), g.verifyNewCard("AceHearts") });
		assertEquals("Two Pair", h.getPokerHand());
	}

	@Test
	public void test1Pair() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("AceDiamonds"), g.verifyNewCard("AceClubs"),
				g.verifyNewCard("ThreeClubs"), g.verifyNewCard("FiveHearts"), g.verifyNewCard("SevenSpades") });
		assertEquals("One Pair", h.getPokerHand());
	}

	@Test
	public void testPrint() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoSpades"),
				g.verifyNewCard("EightSpades"), g.verifyNewCard("FiveHearts"), g.verifyNewCard("SixSpades") });
		assertEquals("TwoHearts TwoSpades EightSpades FiveHearts SixSpades One Pair", h.print());
	}

	@Test
	public void testOnePairRank() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoSpades"),
				g.verifyNewCard("EightSpades"), g.verifyNewCard("FiveHearts"), g.verifyNewCard("SixSpades") });
		assertEquals(2, h.getHandRank());
	}

	@Test
	public void testSorted() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoSpades"),
				g.verifyNewCard("EightSpades"), g.verifyNewCard("FiveHearts"), g.verifyNewCard("SixSpades") });
		h.sortCardsDesc();
		assertEquals("EightSpades SixSpades FiveHearts TwoHearts TwoSpades One Pair", h.print());
	}

	@Test
	public void testCompareTo() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("FourHearts"), g.verifyNewCard("EightHearts"),
				g.verifyNewCard("TwoClubs"), g.verifyNewCard("ThreeSpades"), g.verifyNewCard("SixSpades") });
		Hand o = new Hand(new Card[] { g.verifyNewCard("EightDiamonds"), g.verifyNewCard("FourSpades"),
				g.verifyNewCard("TwoDiamonds"), g.verifyNewCard("ThreeClubs"), g.verifyNewCard("NineSpades") });
		assertEquals(1, h.compareTo(o));
		assertEquals(-1, o.compareTo(h));
	}

	@Test
	public void testCompareToFullHouse() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("TwoSpades"),
				g.verifyNewCard("SevenHearts"), g.verifyNewCard("SevenSpades"), g.verifyNewCard("SevenClubs") });
		Hand o = new Hand(new Card[] { g.verifyNewCard("ThreeSpades"), g.verifyNewCard("ThreeClubs"),
				g.verifyNewCard("SixDiamonds"), g.verifyNewCard("SixClubs"), g.verifyNewCard("SixHearts") });
		assertEquals(-1, h.compareTo(o));
		assertEquals(1, o.compareTo(h));
	}

	public void testCompareToStraight() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("TwoHearts"), g.verifyNewCard("ThreeHearts"),
				g.verifyNewCard("FourDiamonds"), g.verifyNewCard("FiveHearts"), g.verifyNewCard("SixSpades") });
		Hand o = new Hand(new Card[] { g.verifyNewCard("SevenHearts"), g.verifyNewCard("ThreeClubs"),
				g.verifyNewCard("FourSpades"), g.verifyNewCard("FiveClubs"), g.verifyNewCard("SixDiamonds") });
		assertEquals(1, h.compareTo(o));
		assertEquals(-1, o.compareTo(h));
	}

	@Test
	public void testCompareTo4OAK2() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("SixSpades"), g.verifyNewCard("SixDiamonds"),
				g.verifyNewCard("SixClubs"), g.verifyNewCard("JackClubs"), g.verifyNewCard("SixHearts") });
		Hand o = new Hand(new Card[] { g.verifyNewCard("SevenSpades"), g.verifyNewCard("SevenDiamonds"),
				g.verifyNewCard("SevenClubs"), g.verifyNewCard("JackDiamonds"), g.verifyNewCard("SevenHearts") });
		assertEquals(1, h.compareTo(o));
		assertEquals(-1, o.compareTo(h));
	}

	@Test
	public void testCompareToRoyalFlushEq() {
		Hand h = new Hand(new Card[] { g.verifyNewCard("AceHearts"), g.verifyNewCard("KingHearts"),
				g.verifyNewCard("TenHearts"), g.verifyNewCard("JackHearts"), g.verifyNewCard("QueenHearts") });
		Hand o = new Hand(new Card[] { g.verifyNewCard("AceDiamonds"), g.verifyNewCard("KingDiamonds"),
				g.verifyNewCard("TenDiamonds"), g.verifyNewCard("JackDiamonds"), g.verifyNewCard("QueenDiamonds") });
		assertEquals(0, h.compareTo(o));
		assertEquals(0, o.compareTo(h));
	}
	
	@Test
	public void testGetCardsSize(){
		Hand h = new Hand(new Card[] { g.verifyNewCard("AceHearts"), g.verifyNewCard("KingHearts"),
				g.verifyNewCard("TenHearts"), g.verifyNewCard("JackHearts"), g.verifyNewCard("QueenHearts") });
		assertEquals(5, h.getCardsSize());
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
