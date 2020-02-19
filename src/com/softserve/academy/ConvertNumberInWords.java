/* Task 5
5.	Число в пропись
Нужно преобразовать целое число в прописной вариант: 12 – двенадцать.
Программа запускается через вызов главного класса с параметрами.
 */
package com.softserve.academy;

public class ConvertNumberInWords {

    public static void main(String[] args) {
        do {
            ConsoleIO.startProgram();
            NumberOfDigits number = new NumberOfDigits(ConsoleIO.enterNumber());
            NumberInWords numberInW = new NumberInWords();
            try {
                long data = Long.parseLong(number.getNumberOfDigits());
                String numberInWords = numberInW.convert(data);
                System.out.println(numberInWords);
            } catch (NumberFormatException e) {
                ConsoleIO.informError();
                }
            ConsoleIO.continueProgram();
        } while (ConsoleIO.isContinue());
        ConsoleIO.closeScanner();
    }
}