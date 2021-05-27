package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.management.MemoryType;

public class MathFunTest {

    private MathFun mathFunBefore;

    @Before
    public void setUp() {
        System.out.println("Setting up");
        mathFunBefore = new MathFun();
    }

    @Test
    public void addTwoNums_withValidData_shouldReturnCorrectValue() {
        // Arrange
        MathFun mathFun = new MathFun();
        Integer expected = 7;

        // Act
        Integer result = mathFun.addTwoNums(3, 4);

        // Assert
        Assert.assertEquals("addTwoNums(3, 4)", expected, result);

    }

    @Test
    public void addTwoNums_withNullAValue_returnsNull() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        Integer result = mathFun.addTwoNums(null, 5);

        // Assert
        Assert.assertNull("Expected this to return null", result);
    }

    @Test
    public void addTwoNums_withNullBValue_returnsNull() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        Integer result = mathFunBefore.addTwoNums(5, null);

        // Assert
        Assert.assertNull(result);
    }

    @Test
    public void sumArray_withValidElements_shouldReturnCorrrectValue() {
        // Arrange
        MathFun mathFun = new MathFun();
        Integer[] data = new Integer[] { 4, 5, 8, 2 };
        Integer expected = 19;

        // Act
        Integer result = mathFun.sumArray(data);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void sumArray_withNullArray_shouldReturnNull() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        Integer result = mathFun.sumArray(null);

        // Assert
        Assert.assertNull(result);
    }

    @Test
    public void sumArray_withNoElements_shouldReturnZero() {
        // Arrange
        MathFun mathFun = new MathFun();
        Integer[] data = new Integer[] {};
        Integer expected = 0;

        // Act
        Integer result = mathFun.sumArray(data);

        // Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void sumArray_withOneElement_shouldReturnCorrectValue() {
        // Arrange
        MathFun mathFun = new MathFun();
        Integer[] data = new Integer[] { 5 };
        Integer expected = 5;

        // Act
        Integer result = mathFun.sumArray(data);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void isNumInRange_withValidDataNumInRange_shouldReturnTrue() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        boolean result = mathFun.isNumInRange(5, 1, 10);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isNumInRange_withCValidDataNumNotInRange_shouldReturnFalse() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        boolean result = mathFun.isNumInRange(5, 10, 20);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isNumInRange_withValidDataNumIsMin_shouldReturnTrue() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        boolean result = mathFun.isNumInRange(5, 5, 10);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isNumInRange_withValidDataNumIsMax_shouldReturnTrue() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        boolean result = mathFun.isNumInRange(10, 5, 10);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void isNumInRange_withValidDataNumIsOneLessThanMin_shouldReturnFalse() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        boolean result = mathFun.isNumInRange(4, 5, 10);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void isNumInRange_withValidDataNumIsOneMoreThanMax_shouldReturnFalse() {
        // Arrange
        MathFun mathFun = new MathFun();

        // Act
        boolean result = mathFun.isNumInRange(11, 5, 10);

        // Assert
        Assert.assertFalse(result);
    }

    /*
     should also test:

        isNumInRange where num is null
        isNumInRange where min is null
        isNumInRange where max is null

    */
}
