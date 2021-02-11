/*
 * Written by Gunner Carlson
 */
import java.util.Scanner;
public class ShowcaseGame {
public static final String FILE_NAME = "./prizeList.txt";
private static Showcase showcase = new Showcase();

	public static void main(String[] args) {	
		Scanner key = new Scanner(System.in);
		
		int guess = 0;
		int quit = 0;
		boolean play = true;
		while(play) {
			System.out.println("Welcome to the Showcase Show Down!");
			System.out.println("Your prizes are:\n");
			readArray();
			gameArray();
			
			System.out.println("\nYou must guess the total cost of all 5 without going over...");
			System.out.println("Enter your guess:");
			guess = key.nextInt();
			
			System.out.println("You guessed: "+guess);
			System.out.println("The actual price was: "+showcase.getRandomCost());
			
			if(guess <= showcase.getRandomCost() - 2000 || guess > showcase.getRandomCost())
				System.out.println("You lose!!!");
			else
				System.out.println("You win!!!");
			
			System.out.println("Would you like to play again?");
			System.out.println("Enter 1 to continue;");
			System.out.println("Enter 2 to quit");
			quit = key.nextInt();
			if(quit == 2) {
				System.out.println("Goodbye!");
				play = false;
			}else if(quit == 1){
				System.out.println("Let's keep playing!");
				showcase.resetCost();
			}else {
				System.out.println("Let's Keep playing anyways!");
				showcase.resetCost();
			}
		}
		key.close();
	}
	public static void readArray() {
		showcase.populateArray(FILE_NAME);
	}
	public static void printingPrizes() {
		showcase.printPrizes();
	}
	public static void gameArray() {
		showcase.randomArray();
	}
}