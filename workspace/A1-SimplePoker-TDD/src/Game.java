import java.io.IOException;
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
		
		for(int i=0; i<num;i++){
			String s = "";
			System.out.println("Please enter your id and your cards");
			while(s.equals("")){
				s = reader.nextLine();
				//str = "Hello I'm your String";
				//String[] splited = str.split("\\s+");
			}
			
			
			System.out.println(s);
			r.addPlayerHand(i,new Card[]{new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades"),new Card("ThreeSpades")});
		}
		
		for(int j=0; j<r.players.length;j++){
		System.out.println(r.players[j].getHand().getHand());	
	}
	}
}
