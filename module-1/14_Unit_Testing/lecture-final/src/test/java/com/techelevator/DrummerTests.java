package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DrummerTests {


    //Step 1 - use the @Test annotation to indicate our method is going to be a test
    @Test
    public void test_drummer_name(){

        //Arrange - we declare an instance of the class we want to test
        Drummer drummer = new Drummer("drummer");

        //Act - we call the method we want to test and store the result
        String result = drummer.getName();

        //Assert
        Assert.assertEquals("drummer", result);
    }

    @Test
    public void test_drummer_name_empty(){

        //Arrange - we declare an instance of the class we want to test
        Drummer drummer = new Drummer("");

        //Act - we call the method we want to test and store the result
        String result = drummer.getName();

        //Assert
        Assert.assertEquals("", result);
    }

    //Step 1 - use the @Test annotation to indicate our method is going to be a test
    @Test
    public void test_drummer_instrument(){

        //Arrange - we declare an instance of the class we want to test
        Drummer drummer = new Drummer("drummer");

        //Act - we call the method we want to test and store the result
        String result = drummer.getInstrument();

        //Assert
        Assert.assertEquals("Drums", result);
    }

    @Test
    public void test_is_superstar_15(){

        //Arrange - we declare an instance of the class we want to test
        //          and configure it with any variables we want
        Drummer drummer = new Drummer("drummer");
        drummer.setNumYearsExperience(15);

        //Act - We call the method that we want to test
        boolean result = drummer.isSuperstar();

        //Assert - test against our expected result
        Assert.assertEquals(true, result);

    }

    @Test
    public void test_is_superstar_10(){

        //Arrange - we declare an instance of the class we want to test
        //          and configure it with any variables we want
        Drummer drummer = new Drummer("drummer");
        drummer.setNumYearsExperience(10);

        //Act - We call the method that we want to test
        boolean result = drummer.isSuperstar();

        //Assert - test against our expected result
        Assert.assertEquals(true, result);

    }

    @Test
    public void test_is_superstar_many(){

        //Arrange - we declare an instance of the class we want to test
        //          and configure it with any variables we want
        Drummer drummer = new Drummer("drummer");

        //test 10 years
        drummer.setNumYearsExperience(10);
        Assert.assertEquals(true, drummer.isSuperstar());

        drummer.setNumYearsExperience(1000);
        Assert.assertEquals(true, drummer.isSuperstar());

        drummer.setNumYearsExperience(0);
        Assert.assertEquals(false, drummer.isSuperstar());

        drummer.setNumYearsExperience(-1000);
        Assert.assertEquals(false, drummer.isSuperstar());

    }

    @Test
    public void test_drummer_song(){

        //Arrange - instantiate the class I want to test
        Drummer drummer = new Drummer("drummer", "song");

        //Act - call the method we want to test and store
        //      the result
        String result = drummer.playInstrument();

        //Assert
        Assert.assertEquals("song", result);

    }
}
