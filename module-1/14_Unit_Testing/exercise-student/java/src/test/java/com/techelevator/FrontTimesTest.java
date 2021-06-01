package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    FrontTimes frontTimes = new FrontTimes();

    @Test
    public void Should_Return_TwoCopies(){

        String expected = "ChoCho";
        String result = frontTimes.generateString("Chocolate", 2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void Should_Return_Three_Copies(){

        String expected = "ChoChoCho";
        String result = frontTimes.generateString("Chocolate", 3);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void Should_Return_First_Copies(){

        String expected = "AbcAbcAbc";
        String result = frontTimes.generateString("Abc", 3);
        Assert.assertEquals(expected, result);
    }

}
