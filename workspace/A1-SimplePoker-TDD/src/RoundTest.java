import static org.junit.Assert.*;

import org.junit.Test;

public class RoundTest {

	@Test
	public void testAddPlayerHand() {
		Round r = new Round(2);
		for(int i=0;i<2;i++){
			r.addPlayerHand(i,new Card[]{new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades")});
		}
		assertEquals(2,r.players.length);
	}

}
