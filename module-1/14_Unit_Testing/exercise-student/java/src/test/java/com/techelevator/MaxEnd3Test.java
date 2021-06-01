package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

        @Test
        public void MaxEndThree_LargerLastElement_ShouldReturn_LastElement() {
            MaxEnd3 maxEnd3 = new MaxEnd3();
            int[] arr = new int[]{1, 2, 3};
            int[] max = new int[]{3, 3, 3};
            int[] expected = max;
            int[] result = maxEnd3.makeArray(arr);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void MaxEndThree_LargerFirstElement_ShouldReturn_FirstElement() {
            MaxEnd3 maxEnd3 = new MaxEnd3();
            int[] arr = new int[]{11, 5, 9};
            int[] expected = new int[]{11, 11, 11};
            int[] result = maxEnd3.makeArray(arr);
            Assert.assertArrayEquals(expected, result);
        }

        @Test
        public void MaxEndThree_LargeLastElement_ShouldReturn_LastElement() {
            MaxEnd3 maxEnd3 = new MaxEnd3();
            int[] arr = new int[]{2, 11, 3};
            int[] expected = new int[]{3, 3, 3};
            int[] result = maxEnd3.makeArray(arr);
            Assert.assertArrayEquals(expected, result);
        }
    }


