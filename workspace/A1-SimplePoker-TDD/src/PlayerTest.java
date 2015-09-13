import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testId(){
		Hand h = new Hand(new Card[]{new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades"),new Card("TwoSpades")});
		Player p = new Player("Matt",h);
		
		assertEquals("Matt",p.getId());
	}

}
