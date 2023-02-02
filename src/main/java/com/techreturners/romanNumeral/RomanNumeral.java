package com.techreturners.romanNumeral;

import java.util.*;

public class RomanNumeral {
    public int convertNumeralToDigit(String numeral) {
        if ("".equals(numeral.trim()) || !isValidNumeral(numeral))
            throw new IllegalArgumentException("Input is not a valid roman numbers.");

        int number = 0;
        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("MC", 900);
        map.put("CX", 90);
        map.put("IX", 9);
        map.put("CD", 400);
        map.put("XL", 40);
        map.put("IV", 4);
        map.put("M", 1000);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);

        for (String key : map.keySet()) {
            while (numeral.contains(key)) {
                numeral = numeral.replaceFirst(key, "");
                number += map.get(key);
            }
        }

        return number;
    }

    private boolean isValidNumeral(String numeral) {
        List<String> validChars = Arrays.asList("I", "V", "X", "L", "C", "D", "M");
        for (String c : validChars) {
            numeral = numeral.replace(c, "");
        }
        return numeral.equals("");
    }

    public String convertDigitToNumeral(int number) {
        if (!isValidDigit(number))
            throw new IllegalArgumentException("Input is not a valid arabic numbers.");
        StringBuilder numeral = new StringBuilder();
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1000, "M");
        map.put(900, "MC");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "CX");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        for (Integer key : map.keySet()) {
            while (number > 0 && number - key >= 0) {
                numeral.append(map.get(key));
                number -= key;
            }
        }
        return numeral.toString();
    }

    private boolean isValidDigit(int digit) {
        return digit > 0 && digit < 3001;
    }
}
