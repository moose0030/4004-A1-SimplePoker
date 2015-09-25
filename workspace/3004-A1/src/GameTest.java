import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	Game game = new Game();
	@Test
	public void test() {
		// fail("Not yet implemented");
	}
	
	@Test public void getDeckFirstCard(){
		assertEquals("AceSpades",game.getDeck(0));
	}
	
	/*@Test public void getTwoSameCards(){
		String s ="TwoSpades";
		boolean b = game.verifyNewCard(s);
		b = game.verifyNewCard(s);
		
		assertEquals(false,b);
	}*/
	
	@Test public void findCard(){
		String s = "TwoSpades";
		assertEquals(true,game.verifyNewCard(s));
	}
	
	@Test public void findCard2(){
		String s = "TwoSpades";
		game.verifyNewCard(s);
		
		assertEquals(false,game.verifyNewCard(s));
	}
	
	@Test public void findCard3(){
		String s = "TwoSpdes";
		assertEquals(true,game.verifyNewCard(s));
	}
	
	
	
	

}
