package com.techreturners.romanNumeral;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RomanNumeralTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testNumeralToDigit(
            String input, int expected) {
        RomanNumeral rm = new RomanNumeral();
        int actualValue = rm.convertNumeralToDigit(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalidNumeral.csv", numLinesToSkip = 1)
    void testInvalidNumeralThrowException(
            String input) {
        RomanNumeral rm = new RomanNumeral();
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> rm.convertNumeralToDigit(input));

        String expectedMessage = "Input is not a valid roman numbers.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testDigitToNumeral(
            String expected, int input) {
        RomanNumeral rm = new RomanNumeral();
        String actualValue = rm.convertDigitToNumeral(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/invalidDigit.csv", numLinesToSkip = 1)
    void testInvalidDigitThrowException(
            int input) {
        RomanNumeral rm = new RomanNumeral();
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> rm.convertDigitToNumeral(input));

        String expectedMessage = "Input is not a valid arabic numbers.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
