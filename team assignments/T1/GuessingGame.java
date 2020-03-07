import java.util.Random;
import java.util.Scanner;


public class GuessingGame {
	
	/**
	 * This method prompts the user for a guess.  It will only prompt the user ones.
	 * The argument provided is the number the user is supposed to guess.
	 * <p>
	 * If the user enters a number too high (higher than numberToGuess) then print 'Too high'.  If
	 * the user enters a number too low (lower than numberToGuess) then print 'Too low'.  If the
	 * user guesses the number, then print 'You guessed it'.
	 * <p>
	 * The number to guess is assumed to be a number between 1 and 20 (but this method doesn't check
	 * if numberToGuess provided is indeed between 1 and 20).  If the user enters a number that is 
	 * not between 1 and 20 (it is less than 1 or greater than 20) then the message to the user 
	 * will be 'Guess is not valid' and no other message is printed.
	 * 
	 * @param numberToGuess this is the number the user is required to guess.
	 * @return true if the guess is correct and equal to numberToGuess and false otherwise.
	 */
	public static boolean getAndCheckGuess(int numberToGuess) {
		boolean correctGuess = false;

		//Prompts user to guess a number
		System.out.print("Guess a number between 1 and 20: ");

		//Takes user input for guess
		Scanner keyboard = new Scanner(System.in);
		int guess = keyboard.nextInt();

		//If guess is outside defined bounds user is prompted for another guess
		while ((guess < 1) || (guess > 20)) {
			System.out.println("Guess is not valid");
			System.out.print("Guess a number between 1 and 20: ");

			//Takes user input for new guess
			guess = keyboard.nextInt();


		}

		//Gives the user a message comparing their guess to the actual number
		if (guess == numberToGuess) {
			//only case that triggers correctGuess to be set to true
			correctGuess = true;
			System.out.print("You guessed it ");
		}
		else if (guess > numberToGuess) {
			System.out.print("Too high ");
		}
		else {
			System.out.print("Too low ");
		}

		return correctGuess;
	}
	
	/**
	 * When running this program, it will call getAndCheckGuess with a random number to guess.
	 * If you want to test with a particular number to guess, provide the number to guess
	 * as an argument to this program.  For example, if you want the numberToGuess to be 17,
	 * run this program as: java GuessingGame 17
	 * <p>
	 * This program will call getAndCheckGuess and then print the value returned by that 
	 * method/function.
	 * @param args the command line argument provided.  If one is provided it is assumed to be the 
	 * number to guess in the game.
	 */
	public static void main(String[] args){
		int numToGuess = 0;
		if (args.length < 1) {
			Random rand = new Random();
			// nextInt will return a number between 0 and 20 (exclusive 20).  Adding 1 results in 
			// a number between 1 and 20 (inclusive).
			numToGuess = rand.nextInt(20) + 1;
		} else {
			// get the number provided as a command line argument and use it as the number to 
			// guess for the game.
			numToGuess = Integer.parseInt(args[0]);
		}
		
		//Gives the user 5 chances to guess the number
		for (int chances = 0; chances < 5; chances++){
			//compares user input to actual number and prints result
			boolean correct = getAndCheckGuess(numToGuess);
			//System.out.println(correct);

			//Exits loop if user correctly guesses number
			if (correct){
				System.out.println("Well done!");
				break;
			}

			//used when user is out of chances to guess
			else if (chances == 4){
				System.out.println("The number to guess was " + numToGuess);
				break;
			}

			//continues while guesses remain
			else
				System.out.println("You have " + (4-chances) + " guesses left");
				continue;
		}
	}	
}