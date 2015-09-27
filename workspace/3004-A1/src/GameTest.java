import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

public class GameTest {
	Game game = new Game();

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void getDeckFirstCard() {
		assertEquals("AceSpades", game.getDeck(0));
	}

	@Test
	public void findCard() {
		String s = "TwoSpades";
		assertEquals(true, game.isCardAvailable(s));
	}

	@Test
	public void findCard2() {
		String s = "ThreeSpades";
		game.isCardAvailable(s);
		assertEquals(false, game.isCardAvailable(s));
	}

	@Test
	public void findCard3() {
		String s = "TwoSpdes";
		assertEquals(false, game.isCardAvailable(s));
	}

	@Test
	public void verifyCard() {
		String s = "JackHearts";
		Card c = game.verifyNewCard(s);
		assertEquals("Jack", c.getRank());
		assertEquals("Hearts", c.getSuit());
	}

	@Test
	public void getTwoSameCards() {
		String s = "TwoSpades";
		Card b = game.verifyNewCard(s);
		b = game.verifyNewCard(s);
		assertEquals(null, b);
	}
	
	@Test
	public void numberOfPlayersMin(){
		ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
		System.setIn(in);
		assertEquals(2,game.getNumberOfPlayers(in));	
	}
	
	@Test
	public void numberOfPlayersMax(){
		ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
		System.setIn(in);
		assertEquals(4,game.getNumberOfPlayers(in));	
	}
}
