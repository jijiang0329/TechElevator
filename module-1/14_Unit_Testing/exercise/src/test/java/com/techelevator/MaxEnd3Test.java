package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test
    public void test_make_array1() {
        MaxEnd3 max = new MaxEnd3();
        int[] testArray = {1,2,3};

        int[] result = max.makeArray(testArray);

        int[] expected = {3,3,3};
        Assert.assertArrayEquals(expected, result);

    }
    @Test
    public void test_make_array2() {
        MaxEnd3 max = new MaxEnd3();
        int[] testArray = {11,5,9};

        int[] result = max.makeArray(testArray);

        int[] expected = {11,11,11};
        Assert.assertArrayEquals(expected, result);

    }
    @Test
    public void test_make_array3() {
        MaxEnd3 max = new MaxEnd3();
        int[] testArray = {2,11,3};

        int[] result = max.makeArray(testArray);

        int[] expected = {3,3,3};
        Assert.assertArrayEquals(expected, result);

    }
}
