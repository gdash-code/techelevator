package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    AnimalGroupName animalGroupName = new AnimalGroupName();
@Test
    public void AnimalGroupNameTests(){
        //Arrange
        String expected = ("Tower");
        String expectedA = ("Crash");
        String expectedB = ("Crash");
        String expectedC = "unknown";
        String expectedD = "unknown";
        String expectedE = "unknown";
        //Act
        String result = animalGroupName.getHerd("giraffe");
        String resultA = animalGroupName.getHerd("Rhino");
        String resultB = animalGroupName.getHerd("rhino");
        String resultC = animalGroupName.getHerd("");
        String resultD = animalGroupName.getHerd("walrus");
        String resultE = animalGroupName.getHerd("elephants");

        //Assert
        Assert.assertEquals("This is your herd name", expected, result);
        Assert.assertEquals("This is your herd name", expectedA, resultA);
        Assert.assertEquals("This is your herd name", expectedB, resultB);
        Assert.assertEquals("This is your herd name", expectedC, resultC);
        Assert.assertEquals("This is your herd name", expectedD, resultD);
        Assert.assertEquals("This is your herd name", expectedE, resultE);


    }

}
