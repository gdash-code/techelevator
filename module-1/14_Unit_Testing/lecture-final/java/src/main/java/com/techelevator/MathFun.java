package com.techelevator;

public class MathFun {

    public Integer addTwoNums(Integer a, Integer b) {
        if (a == null || b == null) {
            return null;
        }
        return a + b;
    }

    public Integer sumArray(Integer[] array) {

        if (array == null) {
            return null;
        }

        Integer result = 0;
        for (Integer num : array) {
            result += num;
        }
        return result;
    }

    public boolean isNumInRange(Integer num, Integer min, Integer max) {
        if (num >= min && num <= max) {
            return true;
        }
        return false;
    }
}
