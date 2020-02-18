/* Task 5
5.	Число в пропись
Нужно преобразовать целое число в прописной вариант: 12 – двенадцать.
Программа запускается через вызов главного класса с параметрами.
 */
package com.softserve.academy;

public class NumberInWords {

    public static void main(String[] args) {

        do {
            try {
                System.out.println(RuleConvertNumber.convert(ConsoleIO.enterNumber()));
            } catch (NumberFormatException e) {
                System.out.println("This number is not supported");
            }
            System.out.println("Do you want to continue? (y/yes or n/no)");
        } while (ConsoleIO.isContinue());
    }
}