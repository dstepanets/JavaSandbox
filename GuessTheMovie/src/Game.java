import java.util.Arrays;
import java.util.Scanner;

public class Game {

	private String			answer;
	private char[]			guess;
	private String			wrongLetters;
	private boolean			win;

	Game(String a) {
		answer = a.toLowerCase();
		guess = new char[a.length()];
		Arrays.fill(guess, '_');
		win = false;
		wrongLetters = new String();
	}

	public void runGame() {

		System.out.println("Hey, pal! Guess my favourite movie.");
		System.out.println("Its name has " + answer.length() + " letters.");

		while (!win && wrongLetters.length() < 10) {
			printQuestion();
			getInput();
			if (new String(guess).equals(answer))
				win = true;
		}
		if (wrongLetters.length() >= 10)
			System.out.println("YOU LOST :(");
		else {
			System.out.println("Movie name: " + new String(guess));
			System.out.println("\tYOU WON!!! :D");
		}
	}

	private void printQuestion() {
		System.out.println("You have guessed (" + wrongLetters.length() + "/10) wrong letters: " + wrongLetters);
		System.out.println("Movie name: " + new String(guess));
	}

	private void getInput() {

		Scanner input = new Scanner(System.in);

		System.out.print("Give me a letter: ");
		char c = input.nextLine().toLowerCase().charAt(0);
		int i = answer.indexOf(c);
		if (i == -1 && (wrongLetters.indexOf(c) == -1))
			wrongLetters += c;
		else {
			while (i > -1) {
				guess[i] = c;
				i = answer.indexOf(c, i + 1);
			}
		}

	}


}
