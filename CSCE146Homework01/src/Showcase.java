/*
 * Written by Gunner Carlson
 */
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Showcase {
	private Prize[] prizes;
	private Prize[] randomPrizes;
	private int randomCost = 0;
	public static final int TOTAL_AMOUNT = 50;
	public static final int CHOSEN_AMOUNT = 5;
	public static final String DELIM = "\t";
	
	public void init(int size) {
		if(size >= 1)
			prizes = new Prize[size];
		else
			prizes = new Prize[TOTAL_AMOUNT];
	}
	public void populateArray(String aName) {
		try 
		{
			Scanner fileScanner = new Scanner(new File(aName));
			String fileLine = fileScanner.nextLine();
			String[] splitLines = fileLine.split(DELIM);
			if(splitLines.length == 2) {
				int size = Integer.parseInt(splitLines[1]);
				init(size);
			}else {
				return;
			}
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				splitLines = fileLine.split(DELIM);
				if(splitLines.length == 2) {
					String name = splitLines[0];
					int price = Integer.parseInt(splitLines[1]);
					Prize aPrize = new Prize(name, price);
					this.addPrize(aPrize);
				}
			}
			fileScanner.close();			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void addPrize(Prize aPrize) {
		if(prizes[prizes.length - 1] != null) {
			return;
		}
		for(int i = 0; i < prizes.length; i++) {
			if(prizes[i] == null) {
				prizes[i] = aPrize;
				break;
			}
		}
	}
	public void printPrizes() {
		for(Prize prize : prizes) {
			if(prize == null)
				break;
			System.out.println(prize);
		}
	}
	public void randomArray() {
		randomPrizes = new Prize[CHOSEN_AMOUNT];
		int rIndex;
		for (int i = 0; i < CHOSEN_AMOUNT; i++) {
			rIndex = (int)(Math.random() * TOTAL_AMOUNT);
			randomPrizes[i] = prizes[rIndex];
			randomCost += randomPrizes[i].getPrice();
		}
		for(int i = 0; i < CHOSEN_AMOUNT; i++) {
			System.out.println(randomPrizes[i]);
		}
	}
	public int getRandomCost() {
		return randomCost;
	}
	public void resetCost() {
		randomCost = 0;
	}
}