package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test
    public void test_getHerd_giraffe() {
        //Arrange: declaration
        AnimalGroupName name = new AnimalGroupName();

        //Act: call method
        String result = name.getHerd("giraffe");

        //Assert
        Assert.assertEquals("Tower", result);
    }
    @Test
    public void test_getHerd_empty() {
        //Arrange: declaration
        AnimalGroupName name = new AnimalGroupName();

        //Act: call method
        String result = name.getHerd("");

        //Assert
        Assert.assertEquals("unknown", result);
    }
    @Test
    public void test_getHerd_walrus() {
        //Arrange: declaration
        AnimalGroupName name = new AnimalGroupName();

        //Act: call method
        String result = name.getHerd("walrus");

        //Assert
        Assert.assertEquals("unknown", result);
    }

    @Test
    public void test_getHerd_Rhino() {
        //Arrange: declaration
        AnimalGroupName name = new AnimalGroupName();

        //Act: call method
        String result = name.getHerd("Rhino");

        //Assert
        Assert.assertEquals("Crash", result);
    }
    @Test
    public void test_getHerd_rhino() {
        //Arrange: declaration
        AnimalGroupName name = new AnimalGroupName();

        //Act: call method
        String result = name.getHerd("rhino");

        //Assert
        Assert.assertEquals("Crash", result);
    }
    @Test
    public void test_getHerd_elephants() {
        //Arrange: declaration
        AnimalGroupName name = new AnimalGroupName();

        //Act: call method
        String result = name.getHerd("elephants");

        //Assert
        Assert.assertEquals("unknown", result);
    }




















}
