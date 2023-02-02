package com.techreturners.romanNumeral;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RomanNumeralTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testRomanToNumber(
            String input, int expected) {
        RomanNumeral rm = new RomanNumeral();
        int actualValue = rm.convertRomanToArabic(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testNumberToRoman(
            String expected, int input) {
        RomanNumeral rm = new RomanNumeral();
        String actualValue = rm.convertArabicToRoman(input);
        assertEquals(expected, actualValue);
    }
}
