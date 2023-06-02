package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {
    @Test
    public void test1_get_count() {
        WordCount wordCount = new WordCount();
        String[] test = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> result = wordCount.getCount( new String[] {"ba", "ba", "black", "sheep"});
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);
        Assert.assertEquals(expected, result);
    }
}
