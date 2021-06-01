package com.techelevator;

import junit.framework.Assert;
import org.junit.Test;

public class DateFashionTest {

    DateFashion dateFashion = new DateFashion();

    @Test
    public void Should_Return_Yes(){
        DateFashion dateFashion = new DateFashion();
        Integer expected = 2;
        Integer[] data = new Integer[]{5, 10};

        Integer result = dateFashion.getATable(5,10);

        Assert.assertEquals(expected, result);

    }

    @Test
    public void Should_Return_No(){
        Integer expected = 0;
        Integer[] data = new Integer[]{5, 2};

        Integer result = dateFashion.getATable(5,2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void Should_Return_Maybe(){
        Integer expected = 1;
        Integer[] data = new Integer[]{5, 5};

        Integer result = dateFashion.getATable(5,5);

        Assert.assertEquals(expected, result);
    }

}
