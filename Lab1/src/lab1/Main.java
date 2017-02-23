package lab1;

import java.util.Scanner;

public class Main {

	// Declaring variables
	private static int yearsToWork, yearsToDraw;
	private static double avgReturn, expAvgReturn, reqIncome, expIncome;
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		// Prompts for variables
		System.out.println("How many years do you plan to work?");
		yearsToWork = input.nextInt();
		while(true){
		System.out.println("What is your current annual return? (in percent)");
		avgReturn = input.nextDouble();
		if(avgReturn >= 0 && avgReturn <= 20){
			break;
		} else System.out.println("Invalid: percent must be between 0 and 20");
		}
		while(true){
		System.out.println("What is your expected annual return? (in percent)");
		expAvgReturn = input.nextDouble();
		if(expAvgReturn >= 0 && expAvgReturn <= 3){
			break;
		} else System.out.println("Invalid: percent must be between 0 and 3");
		}
		System.out.println("How many years do you plan on receiving money in your retirement?");
		yearsToDraw = input.nextInt();
		System.out.println("What is your required income?");
		reqIncome = input.nextDouble();
		System.out.println("What is your expected SSI income?");
		expIncome = input.nextDouble();
		
		// Total savings formula
		double totalSavings = (reqIncome - expIncome) * (1 - 
				(1 / Math.pow((1 + (expAvgReturn / 100) / 12), (12 * yearsToDraw)))) / 
				((expAvgReturn / 100) /12);
		
		// Monthly savings formula
		double monthlySavings = totalSavings * ((avgReturn / 100) /12) / 
				(Math.pow((1+(avgReturn / 100) / 12), (yearsToWork * 12)) - 1);
		
		// Prints final results
		System.out.printf("Your monthly savings amount to $%3.2f. Your total savings"
				+ " amounts to $%3.2f", monthlySavings, totalSavings);
	}

}
