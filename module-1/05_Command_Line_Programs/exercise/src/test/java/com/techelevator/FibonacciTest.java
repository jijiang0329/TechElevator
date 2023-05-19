package com.techelevator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class FibonacciTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }


    @Test
    public void valid_doubleDigit() {
        final String input = "14";
        provideInput(input);

        final String expectedOutput = "0, 1, 1, 2, 3, 5, 8, 13";

        Fibonacci.main(new String[0]);

        String actualOutput = getOutput();
        assert(actualOutput.contains(expectedOutput));
    }

    @Test
    public void valid_singleDigit() {
        final String input = "9";
        provideInput(input);

        final String expectedOutput = "0, 1, 1, 2, 3, 5, 8";

        Fibonacci.main(new String[0]);

        String actualOutput = getOutput();
        assert(actualOutput.contains(expectedOutput));
    }
}
