package com.softserve.academy;

import java.util.Scanner;

public class ConsoleIO{
    public static final String START_PROGRAM = "Enter a number in range of " +
        "- 999 999 999 999 and 999 999 999 999";
    final static String message = "Invalid input number.  Enter a number in range of " +
            "-999 999 999 999 and 999 999 999 999!";
    static Scanner scanner = new Scanner(System.in);
    public static String value;

    public static long enterNumber() throws NumberFormatException{
        System.out.println(START_PROGRAM);
        value = scanner.nextLine();
        if (!(isNumber(value))) {
                throw new NumberFormatException(message);
            }
        return Long.parseLong(value);
    }

    private static boolean isNumber(String str) {
        return str.matches("-?\\d+");
    }

    public static boolean isContinue() {
        String scan = scanner.nextLine();
        return (scan.equalsIgnoreCase("y")
                || scan.equalsIgnoreCase("yes"));
    }
}
