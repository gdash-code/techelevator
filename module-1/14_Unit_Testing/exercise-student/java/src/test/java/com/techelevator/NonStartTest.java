package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    //GetPartialString("Hello", "There") → "ellohere"
   // GetPartialString("java", "code") → "avaode"
    //GetPartialString("shotl", "java") → "hotlava"

    NonStart nonStart = new NonStart();

    @Test
    public void Should_Return_Concatenation(){
        String expected = "ellohere";
        String result = nonStart.getPartialString("Hello", "There");
        Assert.assertEquals("Your message", expected, result);
    }

    @Test
    public void Should_Return_Con(){
        String expected = "avaode";
        String result = nonStart.getPartialString("java", "code");
        Assert.assertEquals("Your message", expected, result);
    }

    @Test
    public void Should_Return_Message(){
        String expected = "hotlava";
        String result = nonStart.getPartialString("shotl", "java");
        Assert.assertEquals("Your message", expected, result);
    }


}
