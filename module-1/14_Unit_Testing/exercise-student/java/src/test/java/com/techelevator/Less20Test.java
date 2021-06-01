package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    Less20 less20 = new Less20();

    @Test
    public void Should_Return_True(){
        boolean result = less20.isLessThanMultipleOf20(18);
        Assert.assertTrue(result);
    }

    @Test
    public void Should_Return_Yes(){
        boolean result = less20.isLessThanMultipleOf20(19);
        Assert.assertTrue(result);
    }

    @Test
    public void Should_Return_False(){
        boolean result = less20.isLessThanMultipleOf20(20);
        Assert.assertFalse(result);
    }

}
