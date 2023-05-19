package com.techelevator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class LinearConvertTest {
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
    public void valid_exampleInput_f() {
        final String input = "58\nf\n";
        provideInput(input);

        final String expectedOutput = "58f is 17m";

        LinearConvert.main(new String[0]);

        String actualResult = testOut.toString();
        assert(actualResult.contains(expectedOutput));
    }

    @Test
    public void valid_singleUnit_f() {
        final String input = "1\nf\n";
        provideInput(input);

        LinearConvert.main(new String[0]);

        String expectedOutput = "1f is 0m";

        String actualResult = testOut.toString();
        assert(actualResult.contains(expectedOutput));
    }

    @Test
    public void valid_singleUnit_m() {
        final String input = "1\nm\n";
        provideInput(input);

        final String expectedOutput = "1m is 3f";

        LinearConvert.main(new String[0]);

        String actualResult = testOut.toString();
        assert(actualResult.contains(expectedOutput));
    }
}
