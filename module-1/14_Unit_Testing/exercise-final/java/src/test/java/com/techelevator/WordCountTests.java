package com.techelevator;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WordCountTests {

    /*
     * Given an array of strings, return a Dictionary<string, int> with a key for each different string, with the value the
     * number of times that string appears in the array.
     *
     * ** A CLASSIC **
     *
	 * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	 * getCount([]) → {}
	 * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
     *
     */

	 @Test
	    public void Null_ExpectEmptySet() {
	        //Arrange
	        WordCount exercises = new WordCount();

	        //Assert
	        assertEquals(new HashMap<String, Integer>(), exercises.getCount(null));
	    }
	
    @Test
    public void EmptySetTest_ExpectEmptySet() {
        //Arrange
        WordCount exercises = new WordCount();

        //Assert
        assertEquals(new HashMap<String, Integer>(), exercises.getCount(new String[] {}));
    }

    @Test
    public void UniqueTest_Expect1Each() {
        //Arrange
        WordCount exercises = new WordCount();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Josh", 1);
        expected.put("David", 1);
        expected.put("Casey", 1);
        expected.put("Craig", 1);

        //Assert
        assertEquals(expected, exercises.getCount(new String[] { "Josh", "David", "Casey", "Craig" }));
    }

    @Test
    public void RepeatingTest() {
        //Arrange
        WordCount exercises = new WordCount();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Josh", 4);

        //Assert
        assertEquals(expected, exercises.getCount(new String[] { "Josh", "Josh", "Josh", "Josh" }));
    }

    @Test
    public void WordNotProvidedTests() {
        //Arrange
        WordCount exercises = new WordCount();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Josh", 4);

        //Assert
        assertNotEquals(expected, exercises.getCount(new String[] { "Craig", "Craig", "Craig", "Craig" }));
    }
}
