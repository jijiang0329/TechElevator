package com.techelevator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class TempConvertTest {
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

    @Test
    public void valid_exampleInput() {
        final String input = "58\nF";
        provideInput(input);

        final String expectedOutput = "58F is 14C";

        TempConvert.main(new String[0]);

        String actualOutput = testOut.toString();
        assert(actualOutput.contains(expectedOutput));
    }

    @Test
    public void valid_0C() {
        final String input = "0\nC\n";
        provideInput(input);

        final String expectedOutput = "0C is 32F";

        TempConvert.main(new String[0]);

        String actualOutput = testOut.toString();
        assert(actualOutput.contains(expectedOutput));
    }

    @Test
    public void valid_32F() {
        final String input = "32\nF\n";
        provideInput(input);

        final String expectedOutput = "32F is 0C";

        TempConvert.main(new String[0]);

        String actualOutput = testOut.toString();
        assert(actualOutput.contains(expectedOutput));
    }
}
