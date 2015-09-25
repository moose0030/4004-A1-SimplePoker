import java.util.Scanner;

public class Game {
	static Round r;
	static String[] deck = new String[52];

	public Game(){
		prepareDeck();
	}
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int num = getNumberOfPlayers(reader);
		r = new Round(num);

		boolean playAgain = true;
		while (playAgain) {
			playAgain = false;
			getIdAndCards(reader, num);
			playAgain = getPlayAgain(reader);
		}
		reader.close();
		System.out.println("Game Over");
	}

	private static int getNumberOfPlayers(Scanner s) {
		System.out.println("How many players are playing this round?");
		int num = 0;
		Scanner reader = s;
		while (num < 2 || num > 4) {
			num = reader.nextInt();
		}
		return num;

	}

	private static void getIdAndCards(Scanner sc, int num) {
		Scanner reader = sc;
		for (int i = 0; i < num; i++) {
			String s = "";
			boolean correct = false;
			while (!correct) {
				correct = true;
				System.out.println("Please enter your id and your cards");
				while (s.equals("")) {
					s = reader.nextLine();
				}
				String[] split = s.split("\\s+");
				try {
					r.addPlayerHand(i, split[0], new Card[] { new Card(split[1]), new Card(split[2]),
							new Card(split[3]), new Card(split[4]), new Card(split[5]) });
				} catch (ArrayIndexOutOfBoundsException aioobe) {
					System.out.println("Try that again");
					correct = false;
					s = "";
				}
			}
		}
		System.out.println(r.betterHand(r.players));
	}

	private static boolean getPlayAgain(Scanner s) {
		Scanner reader = s;
		System.out.println("Would you like to play another round? y/n");
		if (reader.nextLine().equals("y"))
			return true;
		else
			return false;
	}
	
	

	private static void prepareDeck(){
		String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack","Queen", "King" };
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		
		int i = 0;
		
		for (String r : ranks) {
			for (String s : suits) {
				String c = r + s;
				deck[i] = c;
				i++;
			}
		}
	}
	
	public String getDeck(int i){
		return deck[i];
	}
	public Card verifyNewCard(String s) {
		String suit="";
		String rank="";
		int cardRank = 0;
		String card= "";
		String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		for (String w : ranks) {
			int index = s.indexOf(w);
			if (index >= 0) {
				switch (w) {
				case "Ace":
					card += w;
					cardRank = 13; 
					break;
				case "Two":
					card += w;
					cardRank = 2;
					break;
				case "Three":
					card += w;
					cardRank = 3;
					break;
				case "Four":
					card += w;
					cardRank = 4;
					break;
				case "Five":
					card += w;
					cardRank = 5;
					break;
				case "Six":
					card += w;
					cardRank = 6;
					break;
				case "Seven":
					card += w;
					cardRank = 7;
					break;
				case "Eight":
					card += w;
					cardRank = 8;
					break;
				case "Nine":
					card += w;
					cardRank = 9;
					break;
				case "Ten":
					card += w;
					cardRank = 10;
					break;
				case "Jack":
					card += w;
					cardRank = 11;
					break;
				case "Queen":
					card += w;
					cardRank = 12;
					break;
				case "King":
					card += w;
					cardRank = 13;
					break;
				default: return null;
				}
				rank = w;
			}
		}
			for (String w : suits) {
				int index = s.indexOf(w);
				if (index >= 0) {
					if(w.equals("Diamonds") || w.equals("Hearts") || w.equals("Clubs") || w.equals("Spades")){
						card+=w;
						if(isCardAvailable(card)){
							return new Card(cardRank,rank, w);
						}
						return null;
					}
					else return null;
					
				}
			}
			return null;
	}
	
	public boolean isCardAvailable(String s){
		for(int i=0; i<deck.length;i++)
		{
			
			if(s.equals(deck[i])){

				deck[i] = null;
				return true;
				
			}
		}
		return false;
		
	}
}