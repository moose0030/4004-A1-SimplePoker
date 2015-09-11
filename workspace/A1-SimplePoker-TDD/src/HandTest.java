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

}
