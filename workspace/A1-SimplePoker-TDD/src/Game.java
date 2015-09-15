import java.util.Scanner;

public class Game {

	static Round r;
	public static void main(String[] args) {
		
		System.out.println("How many players are playing this round?");
		int num = 0;
		Scanner reader = new Scanner(System.in);
		while(num < 2 || num > 4){
			num = reader.nextInt();
		}
		
		r = new Round(num);
		boolean playAgain = true;
		while(playAgain){
			playAgain= false;
		for(int i=0; i<num;i++){
			String s = "";
			System.out.println("Please enter your id and your cards");
			while(s.equals("")){
				s = reader.nextLine();
				
			}
			String[] split = s.split("\\s+");
			r.addPlayerHand(Integer.valueOf(split[0]),new Card[]{new Card(split[1]),new Card(split[2]),new Card(split[3]),new Card(split[4]),new Card(split[5])});
		}
		
		for(int j=0; j<r.players.length;j++){
		System.out.println(r.players[j].getHand().getPokerHand());	
	}
		System.out.println("Would you like to play another round? y/n");
		if(reader.nextLine().equals("y"))
			playAgain = true;
				
		}
		reader.close();
		System.out.println("Game Over");
	}
}
