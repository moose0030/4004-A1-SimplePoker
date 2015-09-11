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
		System.out.println(h.getHand());
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

}
