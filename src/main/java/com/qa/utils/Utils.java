package com.qa.utils;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Utils {

	public static String getInput() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	public static int getIntInput(Logger LOGGER) {
		boolean done = false;
		int intRet = 0;
		do {
			try {
				intRet = Integer.parseInt(getInput());
				if (intRet <= 0) throw new NumberFormatException();
				done = true;
			} catch (NumberFormatException e) {
				LOGGER.warn("Please type in an integer greater than 0!");
			}
		} while (!done);
		return intRet;	
		
	}

}
