import java.util.Scanner;

public class Game {
	static Round r;

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int num = getNumberOfPlayers(reader);
		
		r = new Round(num);
		boolean playAgain = true;
		while (playAgain) {
			playAgain = false;
			getIdAndCards(reader,num);
			System.out.println(r.betterHand(r.players));
			playAgain = getPlayAgain(reader);
		}
		reader.close();
		System.out.println("Game Over");
	}
	
	private static int getNumberOfPlayers(Scanner s){
		System.out.println("How many players are playing this round?");
		int num = 0;
		Scanner reader = s;
		while (num < 2 || num > 4) {
			return num = reader.nextInt();
		}
		return 0;
	}
	
	private static void getIdAndCards(Scanner sc, int num){
		Scanner reader = sc;
		for (int i = 0; i < num; i++) {
			String s = "";
			boolean correct = false;
			while(!correct){
				correct = true;
			System.out.println("Please enter your id and your cards");
			while (s.equals("")) {
				s = reader.nextLine();
			}
			String[] split = s.split("\\s+");
			try{
			r.addPlayerHand(i, split[0], new Card[] { new Card(split[1]), new Card(split[2]), new Card(split[3]),
					new Card(split[4]), new Card(split[5]) });
			}
			catch(ArrayIndexOutOfBoundsException aioobe){
				System.out.println("Try that again");
				correct = false;
				s = "";
			}
			}
		}
	}
	
	private static boolean getPlayAgain(Scanner s){
		Scanner reader = s;
		System.out.println("Would you like to play another round? y/n");
		if (reader.nextLine().equals("y"))
			 return true;
		else 
			return false;
	}
}