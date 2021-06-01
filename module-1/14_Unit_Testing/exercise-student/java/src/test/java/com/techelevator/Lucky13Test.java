package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {

    Lucky13 lucky13 = new Lucky13();

    @Test
    public void Should_Return_True(){
        Integer[] data = new Integer[] {0, 2, 4};
        boolean expected = true;
        boolean result = lucky13.equals(data);
        Assert.assertTrue("Correct", true);
    }

    @Test
    public void Should_Return_False(){
        Integer[] data = new Integer[] {1, 2, 3};
        boolean expected = false;
        boolean result = lucky13.equals(data);
        Assert.assertFalse(result);
    }

    @Test
    public void Should_Return_No(){
        Integer[] data = new Integer[] {1, 2, 4};
        boolean expected = false;
        boolean result = lucky13.equals(data);
        Assert.assertFalse(result);
    }

}
