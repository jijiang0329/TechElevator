package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test
    public void test_generate_string1() {
        FrontTimes front = new FrontTimes();
        String result = front.generateString("Chocolate", 2);

        String expected = "ChoCho";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void test_generate_string2() {
        FrontTimes front = new FrontTimes();
        String result = front.generateString("Chocolate", 3);

        String expected = "ChoChoCho";
        Assert.assertEquals(expected, result);
    }
    @Test
    public void test_generate_string3() {
        FrontTimes front = new FrontTimes();
        String result = front.generateString("Abc", 3);

        String expected = "AbcAbcAbc";
        Assert.assertEquals(expected, result);
    }
}
