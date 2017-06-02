package test.datastructure.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

import main.datastructure.hashtable.HashTable;

public class PutTest {

//    @Test
    public void stringTest() {
        HashTable<String,String> table = new HashTable<String,String>();
        String result = table.put("a", "a");
        result = table.put("b", "b");
        result = table.put("c", "c");
        result = table.put("d", "d");
        result = table.put("e", "e");
        result = table.put("f", "f");
        result = table.put("g", "g");
        result = table.put("h", "h");
        result = table.put("i", "i");
        result = table.put("j", "j");
        result = table.put("k", "k");
        result = table.put("l", "l");
        assertTrue(result.equals("l"));
    }

    @Test
    public void integerTest() {
        HashTable<Integer, Integer> table = new HashTable<Integer, Integer>();
        for(int i = 0; i < 20; i++) {
            table.put(i, i);
        }
        assertTrue(true);
    }
}