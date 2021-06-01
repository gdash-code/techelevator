package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    /*getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	 * getCount([]) → {}
	 * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}*/

    WordCount wordCount = new WordCount();

    @Test
    public void Should_Return_Dictionary(){

        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);
        //Act
        Map<String, Integer> result = wordCount.getCount(new String[] {"ba", "ba", "black", "sheep"});
        //Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void Should_Return_Collection(){

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 2);
        expected.put("b", 2);
        expected.put("c", 1);
        //Act
        Map<String, Integer> result = wordCount.getCount(new String[] {"a", "b", "a", "c", "b"});
        //Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void Should_Return_Empty(){

        Map<String, Integer> expected = new HashMap<>();
        expected.equals(0);
        //Act
        Map<String, Integer> result = wordCount.getCount(new String[] { });
        //Assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void Should_Return_Last(){

        Map<String, Integer> expected = new HashMap<>();
        expected.put("c", 1);
        expected.put("b", 1);
        expected.put("a", 1);
        //Act
        Map<String, Integer> result = wordCount.getCount(new String[] {"c", "b", "a"});
        //Assert
        Assert.assertEquals(expected, result);
    }

}
