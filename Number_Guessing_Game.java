import java.util.Random;
import java.util.Scanner;

public class  Number_Guessing_Game{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int result=0;
      
		System.out.println(">>>>>>>>>>     Welcome to Guess Number Game "+"  Game Id : "+ (int)(Math.random()*Math.pow(10,10))+"    <<<<<<<<<<");
		System.out.println(">>>>>>>>>>     You will be Asked to guess a number to win the Game     <<<<<<<<<<");
		System.out.println(">>>>>>>>>>     You have Maximum as per selected level Attemp Limit     <<<<<<<<<<");

		int attempt = 0;
		Random r1 = new Random();

		// ask for level difficulty
		int choice = 0;

		System.out.println("Enter Difficulty level --->>> || 1 for easy || 2 for medium || 3 for hard || <<<---");

		try {
			choice = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Default level selected");
			choice = 1;
		}

		
		switch (choice) {
		case 1:
			System.out.println("Easy selected.");
			choice = 100 * 1; // set range for easy level
			attempt = 5; // set attempt for easy level
			break;
		case 2:
			System.out.println("Medium selected.");
			choice = 100 * 10; // set range for Medium level
			attempt = 10; // set attempt for Medium level
			break;
		case 3:
			System.out.println("Hard selected.");
			choice = 100 * 100; // set range for hard level
			attempt = 15; // set attempt for hard level
			break;
		default:
			// Default we take easy Level
			System.out.println("Default level.");
			choice = 100; // set range for default level
			attempt = 5; // set attempt for default level
			break;
		}
        
		
		int i = r1.nextInt(choice);
		while (true && attempt >0) {
			System.out.print("Enter number between 1 to " + choice + ": attempt left :  "+attempt +"  :");
			try {

				Scanner input = new Scanner(System.in);
				int ans = input.nextInt();

				if (ans == i) {
					System.out.println();
					result=1;
					System.out.println("**********     Oohhoo Your Number is Correct . you Win the game.!     **********");
					break;
				} else if (ans > i) {
					System.out.println("-----     Your guess number is Greater.     -----");
				} else {

					System.out.println("-----Your guess numbers is Smaller.-----");
				}
			} catch (Exception e) {
				System.out.println("Invalid Input");
			}

			// Catch InputMismatchExceptionc Exception
			finally {
				attempt--;
			}

			// End of loop
		}
		// Game over message...
		// Here attempt <0 because of edge case//
		if (attempt <= 0  && result!=1) {
			System.out.println("Right number is : "+i+"    Check your luck next time.");
			System.out.println();
			System.out.println("----------     Game Over...!     ----------");
		}
        
	}

}
