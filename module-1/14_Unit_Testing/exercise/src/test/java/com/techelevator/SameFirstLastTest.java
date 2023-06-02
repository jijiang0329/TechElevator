package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {

    @Test
    public void test1_is_it_the_same() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] test = {1,2,3};
        boolean result = sameFirstLast.isItTheSame(test);
        Assert.assertEquals(false, result);
    }
    @Test
    public void test2_is_it_the_same() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] test = {1,2,3,1};
        boolean result = sameFirstLast.isItTheSame(test);
        Assert.assertEquals(true, result);
    }
    @Test
    public void test3_is_it_the_same() {
        SameFirstLast sameFirstLast = new SameFirstLast();
        int[] test = {1,2,1};
        boolean result = sameFirstLast.isItTheSame(test);
        Assert.assertEquals(true, result);
    }
}
