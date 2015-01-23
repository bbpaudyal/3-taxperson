package com.camcast.contest.taxperson;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CalculateItems {

	static long amount = 0;

	static long netPay = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		int c = 1;

		String a[][] = null;

		//Using while loop to enter multiple items
		while (c == 1) {

			System.out.println("Enter the Item : ");
			String item = scanner.next();
			System.out.println("Enter the Qty : ");
			int qty = scanner.nextInt();
			if (a == null) {
				a = new ParseAndGetData().parseCSV();
			}

			long amount = new ApplyTax().findTax(a, item, qty);
			System.out.println("Press 1 to continue or 0 to quit :");
			c = scanner.nextInt();
			netPay += amount;

		}

		System.out.println("Net Pay = " + netPay);
	}
}
