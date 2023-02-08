package com.techreturners.romanNumeral;

import java.util.*;
import java.util.regex.Pattern;

public class RomanNumeral {
    public int convertNumeralToDigit(String input) {
        if (!isValidRomanNumeral(input))
            throw new IllegalArgumentException("Input is not a valid roman numbers.");

        int number = 0;
        // create a map to hold the roman chars and its values
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("CM", 900);
        map.put("CD", 400);
        map.put("XC", 90);
        map.put("XL", 40);
        map.put("IX", 9);
        map.put("IV", 4);
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        // loop through the map and see if the input contains the chars,
        // if yes, replace the first appeared chars in the input, and add the value to the result
        for (String key : map.keySet()) {
            while (input.contains(key)) {
                input = input.replaceFirst(key, "");
                number += map.get(key);
            }
        }
        return number;
    }

    private boolean isValidRomanNumeral(String input) {
        String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        return Pattern.compile(regex).matcher(input).matches();
    }

    public String convertDigitToNumeral(String input) {
        int convertedInput = isValidInput(input);
        if (convertedInput == -1)
            throw new IllegalArgumentException("Input is not a valid arabic numbers.");

        StringBuilder numeral = new StringBuilder();
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        for (Integer key : map.keySet()) {
            while (convertedInput > 0 && convertedInput - key >= 0) {
                numeral.append(map.get(key));
                convertedInput -= key;
            }
        }
        return numeral.toString();
    }

    private int isValidInput(String input) {
        int convertedInput = -1;
        try {
            convertedInput = Integer.parseInt(input);
            if (convertedInput <= 0 || convertedInput > 3000)
                convertedInput = -1;
        } catch (NumberFormatException e) {
            // do nothing
        }
        return convertedInput;
    }
}
