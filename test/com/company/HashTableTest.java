package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by richardsaney on 8/30/16.
 *
 * Generally, these tests should be using a mocking framework,
 * but if all tests pass, the following shows that the HashTable works.
 *
 */
public class HashTableTest {
    @Test
    public void size() throws Exception {
        assertFalse(table.size() == 0);
        table = new HashTable<String, Integer>();
        assertTrue(table.size() == 0);
    }

    @Test
    public void isEmpty() throws Exception {
        assertFalse(table.isEmpty());
        table = new HashTable<String, Integer>();
        assertTrue(table.isEmpty());
    }

    @Test
    public void containsKey() throws Exception {
        assertFalse(table.containsKey("Esa"));
        assertTrue(table.containsKey("Donna"));
        assertTrue(table.containsKey("Jake"));
        assertTrue(table.containsKey("Richard"));
    }

    @Test
    public void containsValue() throws Exception {
        assertFalse(table.containsValue(-1));
        assertTrue(table.containsValue(19));
        assertTrue(table.containsValue(21));
        assertTrue(table.containsValue(33));
    }

    @Test
    public void putAll() throws Exception {
        assertTrue(table.get("Sarah") == null);
        assertTrue(table.get("Bob") == null);
        assertTrue(table.get("Amy") == null);
        Map<String, Integer> map = new TreeMap<>();
        map.put("Sarah", 3);
        map.put("Amy", 20);
        map.put("Bob", 50);
        table.putAll(map);
        assertTrue(table.get("Sarah") == 3);
        assertTrue(table.get("Bob") == 50);
        assertTrue(table.get("Amy") == 20);
        assertTrue(table.get("Jake") != null);
        assertTrue(table.get("Richard") != null);
        assertTrue(table.get("Donna") != null);
    }

    @Test
    public void clear() throws Exception {
        assertTrue(table.get("Jake") != null);
        assertTrue(table.get("Richard") != null);
        assertTrue(table.get("Donna") != null);
        Assert.assertTrue(table.size != 0);
        table.clear();
        assertTrue(table.get("Jake") == null);
        assertTrue(table.get("Richard") == null);
        assertTrue(table.get("Donna") == null);
        assertTrue(table.size == 0);
    }

    @Test
    public void keySet() throws Exception {
        Collection<String> keys = table.keySet();
        Assert.assertTrue(keys.contains("Jake"));
        Assert.assertTrue(keys.contains("Donna"));
        Assert.assertTrue(keys.contains("Richard"));
        Assert.assertTrue(keys.size() == 3);
    }

    @Test
    public void values() throws Exception {
        Collection<Integer> vals = table.values();
        Assert.assertTrue(vals.contains(21));
        Assert.assertTrue(vals.contains(19));
        Assert.assertTrue(vals.contains(33));
        Assert.assertTrue(vals.size() == 3);
    }

    @Test
    public void entrySet() throws Exception {
        //(should change to check entry values)
        System.out.println(table.entrySet());
    }

    HashTable<String, Integer> table;

    @Before
    public void setUp() throws Exception {
        table = new HashTable<>();
        //would be using a mocking framework to separate dependency
        table.put("Richard", 21);
        table.put("Jake", 19);
        table.put("Donna", 33);
    }

    @Test
    public void toStringTest() throws Exception {
        String s = table.toString();
        Assert.assertTrue(s.contains("Richard=21"));
        Assert.assertTrue(s.contains("Jake=19"));
        Assert.assertTrue(s.contains("Donna=33"));
    }

    @Test
    public void get() throws Exception {
        int val = table.get("Richard");
        Assert.assertTrue(val == 21);
    }

    @Test
    public void remove() throws Exception {
        Integer val = table.get("Jake");
        assertTrue(val == 19);
        table.remove("Jake");
        val = table.get("Jake");
        assertTrue(val == null);
    }
}