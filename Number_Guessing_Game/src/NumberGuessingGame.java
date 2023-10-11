import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int randomNumber = rand.nextInt(100) + 1;
		
		boolean cheat = false;
		while (true) {
			System.out.println("Enter your guess(1-100):");
		
			int playerGuess = scanner.nextInt();
		
			if (playerGuess == randomNumber) {
				if (cheat == true) {
					System.out.println("You cheat so you lose!");
				} else {
					System.out.println("Correct! You win!");					
				}
				break;
			} else if (randomNumber < playerGuess && playerGuess < 100) {
				System.out.println("Sorry buddy? the answer is lower!");
			} else if (playerGuess == 1598753) {
				if (cheat == true) {
					System.out.println("That the second time you cheat \nfor the same number,\nare dumb or something");
					break;
				} else {
					System.out.println("Ansser is: " + randomNumber);
					cheat = true;
				}
			} else {
				System.out.println("Sorry buddy? the answer is higher!");
			}
		}
		scanner.close();
	}

}
