package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {
    @Test
    public void test_get_a_table1() {
        DateFashion date = new DateFashion();
        int result = date.getATable(5,10);
        Assert.assertEquals(2, result);
    }
    @Test
    public void test_get_a_table2() {
        DateFashion date = new DateFashion();
        int result = date.getATable(5,2);
        Assert.assertEquals(0, result);
    }
    @Test
    public void test_get_a_table3() {
        DateFashion date = new DateFashion();
        int result = date.getATable(5,5);
        Assert.assertEquals(1, result);
    }
}
