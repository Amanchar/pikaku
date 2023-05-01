package com.pikaku;

import com.pikaku.console_ui.*;

import java.util.Scanner;

public class Main {

	private static final ApplicationContext context = new ApplicationContext ();

	public static void main (String[] args) {
		while (true) {
			printMenu ();
			int menuNumber = getMenuNumberFromUser ();
			executeSelectedMenuItem (menuNumber);
		}
	}

	private static void printMenu () {
		String menu = "1. Add product\n" +
				"2. Delete product\n" +
				"3. Get product by id\n" +
				"4. Print all products\n" +
				"5. Exit";
		System.out.println (menu);
	}

	private static int getMenuNumberFromUser () {
		System.out.println ("Enter menu item number to execute:");

		Scanner scanner = new Scanner (System.in);

		return Integer.parseInt (scanner.nextLine ());
	}

	private static void executeSelectedMenuItem (int selectedMenu) {
		switch (selectedMenu) {
			case 1: {
				((UIAction) context.getBean (AddProductUIAction.class)).execute ();
				break;
			}
			case 2: {
				((UIAction) context.getBean (DeleteProductUIAction.class)).execute ();
				break;
			}
			case 3: {
				((UIAction) context.getBean (SearchProductUIAction.class)).execute ();
				break;
			}
			case 4: {
				((UIAction) context.getBean (PrintAllProductsUIAction.class)).execute ();
				break;
			}
			case 5: {
				exitProgramAction ();
				break;
			}
		}
	}

	private static void exitProgramAction () {
		System.out.println ("Good by!");
		System.exit (0);
	}
}
