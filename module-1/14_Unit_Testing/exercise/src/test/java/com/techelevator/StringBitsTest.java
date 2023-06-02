package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
    @Test
    public void test1_get_bits() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("Hello");
        Assert.assertEquals("Hlo", result);
    }
    @Test
    public void test2_get_bits() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("Hi");
        Assert.assertEquals("H", result);
    }
    @Test
    public void test3_get_bits() {
        StringBits stringBits = new StringBits();
        String result = stringBits.getBits("Heeololeo");
        Assert.assertEquals("Hello", result);
    }
}
