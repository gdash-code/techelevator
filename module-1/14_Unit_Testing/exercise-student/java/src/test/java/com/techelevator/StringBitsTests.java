package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTests {

private StringBits stringBitsBefore;

    @Before
    public void setUp(){
    System.out.println("Warming up");
    stringBitsBefore = new StringBits();
}

    @Test
    public void stringBits_shouldReturnANewString_startingWithFirstChar(){
        StringBits stringBits = new StringBits();

        String stringA = "Hello";
        String expectedA = "Hlo";

        String stringB = "Hi";
        String expectedB = "H";

        String stringC = "Heeololeo";
        String expectedC = "Hello";


            String resultA = stringBits.getBits(stringA);
            String resultB = stringBits.getBits(stringB);
            String resultC = stringBits.getBits(stringC);


        Assert.assertEquals("String Bits is: ", expectedA, resultA);
        Assert.assertEquals("String Bits is: ", expectedB, resultB);
        Assert.assertEquals("String Bits is: ", expectedC, resultC);
    }






}
