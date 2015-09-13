import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void testGetHand(){
		Card[] cards = new Card[5];
		for(int i=0;i<5;i++){
			Card c = new Card("TwoSpades");
			cards[i]=c;
		}
		
		Hand h = new Hand(cards);
		assertEquals("TwoSpades,TwoSpades,TwoSpades,TwoSpades,TwoSpades",h.getHand());
		
	}
	@Test
	public void testNumberTwos(){	
		Card[] cards = new Card[5];
		for(int i=0;i<5;i++){
			Card c = new Card("TwoSpades");
			cards[i]=c;
		}
		Hand h = new Hand(cards);
		
		assertEquals(5,h.printDups(2));
	}
	@Test
	public void testRoyalFlush(){
		Card a = new Card("AceSpades");
		Card k = new Card("KingSpades");
		Card q = new Card("QueenSpades");
		Card j = new Card("JackSpades");
		Card t = new Card("TenSpades");
		
		Card[] cards = {a,k,q,j,t};
		
		
		Hand h = new Hand(cards);
		assertEquals("Royal Flush",h.getPokerHand());
	}
	
	@Test
	public void test4OAK(){
		Card[] cards = new Card[5];
		for(int i=0;i<4;i++){
			Card c = new Card("TwoSpades");
			cards[i]=c;
		}
		Card c = new Card("ThreeHearts");
		cards[4]=c;
		
		Hand h = new Hand(cards);
		assertEquals("4 of a Kind",h.getPokerHand());
	}
	
	@Test
	public void test3OAK(){
		Card[] cards = new Card[5];
		for(int i=0;i<3;i++){
			Card c = new Card("TwoSpades");
			cards[i]=c;
		}
		Card c = new Card("ThreeHearts");
		cards[3]=c;
		c = new Card("FiveHearts");
		cards[4]=c;
		
		Hand h = new Hand(cards);
		assertEquals("3 of a Kind",h.getPokerHand());
	}
	
	@Test
	public void testFullHouse(){
		Card[] cards = new Card[5];
		for(int i=0;i<3;i++){
			Card c = new Card("TwoSpades");
			cards[i]=c;
		}
		Card c = new Card("ThreeHearts");
		cards[3]=c;
		c = new Card("ThreeHearts");
		cards[4]=c;
		
		Hand h = new Hand(cards);
		assertEquals("Full House",h.getPokerHand());
	}
	
	public void testFlush(){
		Card o = new Card("AceSpades");
		Card t = new Card("ThreeSpades");
		Card f = new Card("FiveSpades");
		Card s = new Card("SevenSpades");
		Card n = new Card("NineSpades");
		
		Card[] cards ={o,t,f,s,n};
		Hand h = new Hand(cards);
		assertEquals("Flush",h.getPokerHand());
	}
	@Test
	public void testStraightFlush(){
		Card o = new Card("TwoSpades");
		Card t = new Card("ThreeSpades");
		Card f = new Card("FiveSpades");
		Card s = new Card("FourSpades");
		Card n = new Card("SixSpades");
		
		Card[] cards ={o,t,f,s,n};
		Hand h = new Hand(cards);
		
		assertEquals("Straight Flush",h.getPokerHand());
	}
	
	@Test
	public void testStraight(){
		Card o = new Card("TwoHearts");
		Card t = new Card("ThreeSpades");
		Card f = new Card("FiveSpades");
		Card s = new Card("FourSpades");
		Card n = new Card("SixSpades");
		
		Card[] cards ={o,t,f,s,n};
		Hand h = new Hand(cards);
		
		assertEquals("Straight",h.getPokerHand());
	}
	
	@Test
	public void test2Pair(){
		Card o = new Card("TwoHearts");
		Card t = new Card("TwoSpades");
		Card f = new Card("FiveSpades");
		Card s = new Card("FiveHearts");
		Card n = new Card("SixSpades");
		
		Card[] cards ={o,t,f,s,n};
		Hand h = new Hand(cards);
		
		assertEquals("Two Pair",h.getPokerHand());
	}
	
	@Test
	public void test1Pair(){
		Card o = new Card("TwoHearts");
		Card t = new Card("TwoSpades");
		Card f = new Card("EightSpades");
		Card s = new Card("FiveHearts");
		Card n = new Card("SixSpades");
		
		Card[] cards ={o,t,f,s,n};
		Hand h = new Hand(cards);
		
		assertEquals("One Pair",h.getPokerHand());
	}

}
