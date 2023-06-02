package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test
    public void test1_is_less_than_multiple_of_20() {
        Less20 less = new Less20();
        boolean reault = less.isLessThanMultipleOf20(18);
        Assert.assertEquals(true, reault);
    }
    @Test
    public void test2_is_less_than_multiple_of_20() {
        Less20 less = new Less20();
        boolean reault = less.isLessThanMultipleOf20(19);
        Assert.assertEquals(true, reault);
    }
    @Test
    public void test3_is_less_than_multiple_of_20() {
        Less20 less = new Less20();
        boolean reault = less.isLessThanMultipleOf20(20);
        Assert.assertEquals(false, reault);
    }
}
