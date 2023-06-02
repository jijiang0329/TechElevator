package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {


    @Test
    public void test1_get_partial_string() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("java","code");
        Assert.assertEquals("avaode", result);
    }
    @Test
    public void test2_get_partial_string() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("Hello","There");
        Assert.assertEquals("ellohere", result);
    }
    @Test
    public void test3_get_partial_string() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("shotl","java");
        Assert.assertEquals("hotlava", result);
    }
    @Test
    public void test4_get_partial_string() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString(null, null);
        Assert.assertEquals("", result);
    }
    @Test
    public void test5_get_partial_string() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString("coding", null);
        Assert.assertEquals("oding", result);
    }
    @Test
    public void test6_get_partial_string() {
        NonStart nonStart = new NonStart();
        String result = nonStart.getPartialString(null, "null");
        Assert.assertEquals("ull", result);
    }
}
