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

}
