import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void testGetHand(){
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		assertEquals("TwoSpades TwoSpades TwoSpades TwoSpades TwoSpades",h.getHand());	
	}
	@Test
	public void testGetID(){
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")},2);
		assertEquals(2,h.getID());	
	}
	@Test
	public void testNumberTwos(){	
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		assertEquals(5,h.getCardArrayAtIndex(2));
	}
	@Test
	public void testRoyalFlush(){
		Hand h = new Hand(new Card[]{new Card("AceSpades"),new Card("QueenSpades"),new Card("KingSpades"),new Card("JackSpades"),new Card("TenSpades")});
		assertEquals("Royal Flush",h.getPokerHand());
	}
	@Test
	public void test4OAK(){
		Hand h = new Hand(new Card[]{new Card("ThreeHearts"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		assertEquals("Four of a Kind",h.getPokerHand());
	}
	@Test
	public void test3OAK(){
		Hand h = new Hand(new Card[]{new Card("ThreeHearts"),new Card("KingClubs"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		assertEquals("Three of a Kind",h.getPokerHand());
	}
	@Test
	public void testFullHouse(){
		Hand h = new Hand(new Card[]{new Card("ThreeHearts"),new Card("ThreeHearts"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		assertEquals("Full House",h.getPokerHand());
	}
	@Test
	public void testFlush(){
		Hand h = new Hand(new Card[]{new Card("AceSpades"),new Card("TwoSpades"),new Card("FourSpades"),new Card("SevenSpades"),new Card("TenSpades")});
		assertEquals("Flush",h.getPokerHand());
	}
	@Test
	public void testStraightFlush(){
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("ThreeSpades"),new Card("FiveSpades"),new Card("FourSpades"),new Card("SixSpades")});
		assertEquals("Straight Flush",h.getPokerHand());
	}
	@Test
	public void testStraight(){
		Hand h = new Hand(new Card[]{new Card("TwoHearts"),new Card("ThreeSpades"),new Card("FiveSpades"),new Card("FourSpades"),new Card("SixSpades")});
		assertEquals("Straight",h.getPokerHand());
	}
	@Test
	public void test2Pair(){
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoClubs"),new Card("ThreeSpades"),new Card("ThreeHearts"),new Card("AceHearts")});
		assertEquals("Two Pair",h.getPokerHand());
	}
	@Test
	public void test1Pair(){
		Hand h = new Hand(new Card[]{new Card("AceHearts"),new Card("AceDiamonds"),new Card("ThreeClubs"),new Card("FiveHearts"),new Card("SevenClubs")});
		assertEquals("One Pair",h.getPokerHand());
	}
	@Test
	public void testPrint(){
		Hand h = new Hand(new Card[]{new Card("TwoHearts"),new Card("TwoSpades"),new Card("EightSpades"),new Card("FiveHearts"),new Card("SixSpades")});
		assertEquals("TwoHearts TwoSpades EightSpades FiveHearts SixSpades One Pair",h.print());
	}
	@Test
	public void testOnePairRank(){
		Hand h = new Hand(new Card[]{new Card("TwoHearts"),new Card("TwoSpades"),new Card("EightSpades"),new Card("FiveHearts"),new Card("SixSpades")});
		assertEquals(2,h.getHandRank());
	}
	@Test
	public void testHighCardRank(){
		Hand h = new Hand(new Card[]{new Card("TwoHearts"),new Card("TwoSpades"),new Card("EightSpades"),new Card("FiveHearts"),new Card("SixSpades")});
		assertEquals(8,h.getHighCardRank());
	}
	@Test
	public void testHighCardRank2(){
		Hand h1 = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("ThreeHearts"),new Card("ThreeSpades"),new Card("TwoSpades")});
		Hand h2 = new Hand(new Card[]{new Card("FourSpades"),new Card("FourSpades"),new Card("ThreeHearts"),new Card("ThreeSpades"),new Card("FourSpades")});
		assertEquals(3,h1.getHighCardRank());
		assertEquals(4,h2.getHighCardRank());
	}
	@Test
	public void testSorted(){
		Hand h = new Hand(new Card[]{new Card("TwoHearts"),new Card("TwoSpades"),new Card("EightSpades"),new Card("FiveHearts"),new Card("SixSpades")});
		h.sortCardsDesc();
		assertEquals("EightSpades SixSpades FiveHearts TwoHearts TwoSpades One Pair",h.print());
	}
}
