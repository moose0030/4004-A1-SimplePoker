import java.io.IOException;

public class Game {

	
	public static void main(String[] args) {
		
		System.out.println("How many players are playing this round?");
		int num = 0;
		while(num < 2){
			try {
				System.in.read();
				num = 2;
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i=0; i<num;i++){
			//while()
			System.out.println("Please enter your id and your cards");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
