import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		String[] rps = { "rock", "paper", "scissors" };

		String computerMove = rps[new Random().nextInt(rps.length)];
		Scanner scanner = new Scanner(System.in);
		String playerMove;

		while (true) {
			System.out.println("Enter your move (rock, paper or scissors)");
			playerMove = scanner.nextLine().toLowerCase();
			if (Arrays.asList(rps).contains(playerMove)) {
				break;
			}
			System.out.println("[" + '"' + playerMove + '"' + "] is not a valid move!");
		}
		scanner.close();
		System.out.println("You: " + playerMove + " | computer: " + computerMove);
		if (playerMove.equalsIgnoreCase(computerMove)) {
			System.out.println("It's a draw!");
		} else if ((playerMove.equals("rock") && computerMove.equals("scissors"))
				|| (playerMove.equals("paper") && computerMove.equals("rock"))
				|| (playerMove.equals("scissors") && computerMove.equals("paper"))) {
			System.out.println("You win!");
		} else {
			System.out.println("You lose!");
		}
	}
}
