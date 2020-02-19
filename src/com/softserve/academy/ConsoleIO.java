package com.softserve.academy;

import java.util.Scanner;

public class ConsoleIO{
    static Scanner scanner = new Scanner(System.in);

    public static String enterNumber() {
        return scanner.nextLine();
    }

    public static boolean isContinue() {
        String scan = scanner.nextLine();
        return (scan.equalsIgnoreCase("y")
                || scan.equalsIgnoreCase("yes"));
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static void startProgram() {
        System.out.println("Enter a number in range of " +
                "- 999 999 999 999 and 999 999 999 999");
    }
    public static void continueProgram() {
        System.out.println("Do you want to continue? (y/yes or n/no)");
    }
    public static void informError() {
        System.out.println("Invalid input number.  Enter a number in range of " +
                "-999 999 999 999 and 999 999 999 999!");
    }
}
