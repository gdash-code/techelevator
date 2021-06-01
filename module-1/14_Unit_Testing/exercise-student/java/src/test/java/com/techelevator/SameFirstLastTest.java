package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
   /* IsItTheSame([1, 2, 3]) → false
    IsItTheSame([1, 2, 3, 1]) → true
    IsItTheSame([1, 2, 1]) → true*/

    SameFirstLast sameFirstLast = new SameFirstLast();

    @Test
    public void Should_Return_False(){
        int[] nums = new int[]{1, 2, 3};
        boolean expected = false;
        boolean result = sameFirstLast.isItTheSame(nums);
        Assert.assertFalse(result);
    }

    @Test
    public void Should_Return_True(){
        int[] nums = new int[]{1, 2, 3, 1};
        boolean expected = true;
        boolean result = sameFirstLast.isItTheSame(nums);
        Assert.assertTrue(result);
    }

    @Test
    public void Should_Return_Result(){
        int[] nums = new int[]{1, 2, 1};
        boolean expected = true;
        boolean result = sameFirstLast.isItTheSame(nums);
        Assert.assertTrue(result);
    }

}
