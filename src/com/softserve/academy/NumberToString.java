package com.softserve.academy;

import java.util.HashMap;
import java.util.Map;

public class NumberToString {
    private long number;
    private String numberToString;

    //Constants for common use
    private static final long TEN = 10;
    private static final long TWENTY = 20;
    private static final long ONE_HUNDRED = 100;
    private static final long ONE_THOUSAND = 1_000;
    private static final long ONE_MILLION = 1_000_000;
    private static final long ONE_BILLION = 1_000_000_000;
    private static final long ONE_TRILLION = 1_000_000_000_000L;

    //Maps of unique numbers
    private static final Map<Long, String> UNITS = new HashMap<>();
    private static final Map<Long, String> TENS = new HashMap<>();
    private static final Map<Long, String> HUNDREDS = new HashMap<>();

    static {
        UNITS.put(0L, "ноль");
        UNITS.put(1L, "один");
        UNITS.put(2L, "два");
        UNITS.put(3L, "три");
        UNITS.put(4L, "четыре");
        UNITS.put(5L, "пять");
        UNITS.put(6L, "шесть");
        UNITS.put(7L, "семь");
        UNITS.put(8L, "восемь");
        UNITS.put(9L, "девять");
        UNITS.put(10L, "десять");
        UNITS.put(11L, "одиннадцать");
        UNITS.put(12L, "двенадцать");
        UNITS.put(13L, "тринадцать");
        UNITS.put(14L, "четырнадцать");
        UNITS.put(15L, "пятнадцать");
        UNITS.put(16L, "шестнадцать");
        UNITS.put(17L, "семнадцать");
        UNITS.put(18L, "восемнадцать");
        UNITS.put(19L, "девятнадцать");
        TENS.put(2L, "двадцать");
        TENS.put(3L, "тридцать");
        TENS.put(4L, "сорок");
        TENS.put(5L, "пятьдесят");
        TENS.put(6L, "шестьдесят");
        TENS.put(7L, "семьдесят");
        TENS.put(8L, "восемьдесят");
        TENS.put(9L, "девяносто");
        HUNDREDS.put(1L, "сто");
        HUNDREDS.put(2L, "двести");
        HUNDREDS.put(3L, "триста");
        HUNDREDS.put(4L, "четыреста");
        HUNDREDS.put(5L, "пятьсот");
        HUNDREDS.put(6L, "шестьсот");
        HUNDREDS.put(7L, "семьсот");
        HUNDREDS.put(8L, "восемьсот");
        HUNDREDS.put(9L, "девятьсот");
    }

    public NumberToString(long number) {
        this.number = number;
    }

    public String getNumberToString() {
        if (numberToString == null) {
            numberToString = convert(number);
        }
        return numberToString;
    }

    private String convert(long number) {
        if (number < 0) {
            numberToString = "минус " + convert(Math.abs(number));
        } else if (number < TWENTY) {
            numberToString = UNITS.get(number);
        } else if (number < ONE_HUNDRED) {
            numberToString = (TENS.get(number / TEN)
                    + (number % TEN > 0 ? " "
                    + convert(number % TEN) : ""));
        } else if (number < ONE_THOUSAND) {
            numberToString = (HUNDREDS.get(number / ONE_HUNDRED)
                    + (number % ONE_HUNDRED > 0 ? " "
                    + convert(number % ONE_HUNDRED) : ""));
        } else if (number < ONE_MILLION) {
            numberToString = getEndThousand(convert((number / ONE_THOUSAND)))
                    + (number % ONE_THOUSAND > 0 ? " "
                    + convert(number % ONE_THOUSAND) : "");
        } else if (number < ONE_BILLION) {
            numberToString = getEndMillion(convert((number / ONE_MILLION)))
                    + " "
                    + getEndThousand(convert(((number % ONE_MILLION) / ONE_THOUSAND)))
                    + (number % ONE_THOUSAND > 0 ? " "
                    + convert(number % ONE_THOUSAND) : "");
        } else if (number < ONE_TRILLION) {
            numberToString = getEndBillion(convert((number / ONE_BILLION)))
                    + " "
                    + getEndMillion(convert((number % ONE_BILLION) / ONE_MILLION))
                    + " "
                    + getEndThousand(convert(((number % ONE_BILLION) % ONE_MILLION) / ONE_THOUSAND))
                    + (number % ONE_THOUSAND > 0 ? " "
                    + convert(number % ONE_THOUSAND) : "");
        } else {
            return "This number is not supported";
        }
        return numberToString.replaceAll(" {2,}", " "); // to avoid double whitespaces
    }

    // correct ending for thousands
    private String getEndThousand(String str) {
        if (str.equals("ноль")) {
            return "";
        } else if (str.endsWith("один")) {
            return str.replace("один", "одна тысяча");
        } else if (str.endsWith("два")) {
            if (str.endsWith("двадцать два")) {
                return str.replace("двадцать два", "двадцать две тысячи");
            } else {
                return str.replace("два", "две тысячи");
            }
        } else if (str.endsWith("три") || str.endsWith("четыре")) {
            return str + " тысячи";
        } else {
            return str + " тысяч";
        }
    }

    // correct ending for millions
    private String getEndMillion(String str) {
        if (str.equals("ноль")) {
            return "";
        } else if (str.endsWith("один")) {
            return str + " миллион";
        } else if (str.endsWith("два") || str.endsWith("три") || str.endsWith("четыре")) {
            return str + " миллиона";
        } else {
            return str + " миллионов";
        }
    }

    // correct ending for billions
    private String getEndBillion(String str) {
        if (str.equals("ноль")) {
            return "";
        } else if (str.endsWith("один")) {
            return str + " миллиард";
        } else if (str.endsWith("два") || str.endsWith("три") || str.endsWith("четыре")) {
            return str + " миллиарда";
        } else {
            return str + " миллиардов";
        }
    }
}
