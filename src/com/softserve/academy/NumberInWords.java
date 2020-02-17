/* Task 5
5.	Число в пропись
Нужно преобразовать целое число в прописной вариант: 12 – двенадцать.
Программа запускается через вызов главного класса с параметрами.
 */
package com.softserve.academy;

import java.util.Scanner;

public class NumberInWords {

    public static void main(String[] args) {
        System.out.println("Enter a number in range of - 999 999 999 999 and 999 999 999 999"
                + "(or \"exit\" to quit) ");
        Scanner scanner = new Scanner(System.in);
        do {

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                long number = Long.parseLong(input); // the line is converted in the long number
                String output = RuleConvertNumber.convert(number);// the method for converting numbers
                System.out.println(output);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input number.  Enter a number in range of " +
                        "-999 999 999 999 and 999 999 999 999!");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        } while (true);
        scanner.close();
    }
}