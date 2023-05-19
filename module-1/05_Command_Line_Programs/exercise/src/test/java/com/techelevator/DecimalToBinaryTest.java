package com.techelevator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class DecimalToBinaryTest {
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
    public void valid_singleInput() {
        final String input = "8";
        provideInput(input);

        final String expectedOutput = "1000";

        DecimalToBinary.main(new String[0]);

        String actualResult = testOut.toString();
        assert(actualResult.contains(expectedOutput));
    }

    @Test
    public void valid_multipleInput() {
        final String input = "8 100 46\n";
        provideInput(input);

        final String[] expectedOutputs = {
                "8 in binary is 1000",
                "100 in binary is 1100100",
                "46 in binary is 101110"
        };

        DecimalToBinary.main(new String[0]);

        String output = testOut.toString();

        for(String testCase : expectedOutputs) {
            assert(output.contains(testCase));
        }
    }

    @Test
    public void valid_singleDigit() {
        final String input = "1";
        provideInput(input);

        final String expectedOutput = "1 in binary is 1";

        DecimalToBinary.main(new String[0]);

        String actualOutput = testOut.toString();
        assert(actualOutput.contains(expectedOutput));
    }
}
