package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    @Test
    public void test1_get_lucky() {
        Lucky13 lucky = new Lucky13();
        int[] test = {0,2,4};
        boolean result = lucky.getLucky(test);
        Assert.assertEquals(true, result);
    }
    @Test
    public void test2_get_lucky() {
        Lucky13 lucky = new Lucky13();
        int[] test = {1,2,3};
        boolean result = lucky.getLucky(test);
        Assert.assertEquals(false, result);
    }
    @Test
    public void test3_get_lucky() {
        Lucky13 lucky = new Lucky13();
        int[] test = {1,2,4};
        boolean result = lucky.getLucky(test);
        Assert.assertEquals(false, result);
    }
}
