/* 
 * Authors: Thomas Brady, Diana Knieste, Joe Quinlan
 * Date: February 24, 2015
 * Class: CISC181
 * Assignment: Lab 1
 * Description: This program is designed to compute retirement
 * data given user input on their needed income and other relevant
 * factors. This requires two method that use the variables to
 * solve for the amount the user should put away each month.
 */

import java.util.Scanner;
import java.lang.Math;

/*
 * This is our main class. It asks the user a series of questions
 * to input different values about their years working and retired,
 * interest rates, and other financial data.
 */

public class Lab1 extends Object {
	public static void main(String[] args) {

		Scanner InputYearsWorking = new Scanner(System.in);
		System.out.println("How many years do you plan to work? ");
		double YearsWorking = InputYearsWorking.nextDouble();

		Scanner InputInterestSave = new Scanner(System.in);
		System.out.println("What is your expected interest rate on your investments? (Please use decimal form) ");
		double InterestSave = InputInterestSave.nextDouble();

		Scanner InputSSI = new Scanner(System.in);
		System.out.println("What is your expected monthly Social Security income? ");
		double SSI = InputSSI.nextDouble();

		Scanner InputRequiredIncome = new Scanner(System.in);
		System.out.println("What monthly income do you require during your retirement? ");
		double RequiredIncome = InputRequiredIncome.nextDouble();

		Scanner InputYearsRetired = new Scanner(System.in);
		System.out.println("How long in years do you plan to be retired? ");
		double YearsRetired = InputYearsRetired.nextDouble();

		Scanner InputInterestDraw = new Scanner(System.in);
		System.out.println("What is your expected interest rate while you are retired? (Please use decimal form) ");
		double InterestDraw = InputInterestDraw.nextDouble();

		
		double TotalAmount = TotalAmountCalc(YearsRetired, InterestDraw,
				RequiredIncome, SSI);

		double MonthlyDeposit = MonthlyDepositCalc(YearsWorking, InterestSave,
				TotalAmount);

		
		System.out.printf("You will have to save $%.2f%n each month to have a total of $%.2f%n saved before retirement.",
						MonthlyDeposit, TotalAmount);
	}

	/*
	 * This is our first method which takes four arguments related to the user's
	 * retirement needs to calculate the total amount of money the user must
	 * have saved at the time of retirement.
	 */

	protected static double TotalAmountCalc(double YearsRetired,
			double InterestDraw, double RequiredIncome, double SSI) {
		double MonthlyInterest = InterestDraw / 12;
		double MonthsRetired = YearsRetired * 12;
		double RateAndPeriod = Math.pow(1 + MonthlyInterest, MonthsRetired);
		double MonthlyDraw = (RequiredIncome - SSI);
		double TotalAmount = MonthlyDraw
				* ((RateAndPeriod - 1) / (MonthlyInterest))
				* (1 / RateAndPeriod);
		return TotalAmount;
	}

	/*
	 * This is our second method which takes three arguments related to the
	 * user's saving period to calculate the amount of money the user must put
	 * away every month in order to have the total they need saved by
	 * retirement.
	 */

	protected static double MonthlyDepositCalc(double YearsWorking,
			double InterestSave, double TotalAmount) {
		double MonthlyInterest = InterestSave / 12;
		double MonthsWorking = YearsWorking * 12;
		double RateAndPeriod = Math.pow(1 + MonthlyInterest, MonthsWorking);
		double MonthlyDeposits = TotalAmount
				* (MonthlyInterest / (RateAndPeriod - 1));
		return MonthlyDeposits;
	}

}
