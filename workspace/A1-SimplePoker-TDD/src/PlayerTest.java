import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testId(){
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		Player p = new Player("Matt",h);
		
		assertEquals("Matt",p.getId());
	}
	
	@Test
	public void testHand(){
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		Player p = new Player("Matt",h);
		System.out.println(p.getHand().getHand());
		assertEquals("TwoSpades,TwoSpades,TwoSpades,TwoSpades,TwoSpades",p.getHand().getHand());
	}
	
	@Test
	public void testStringConstuctor(){
		String[] s = new String[]{"0", "TwoSpades", "TwoSpades", "TwoSpades", "TwoSpades", "TwoSpades"};
		Player p = new Player(s);
		assertEquals("TwoSpades,TwoSpades,TwoSpades,TwoSpades,TwoSpades",p.getHand().getHand());
	}


}
