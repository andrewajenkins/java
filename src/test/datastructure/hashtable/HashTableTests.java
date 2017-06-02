package test.datastructure.hashtable;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.datastructure.hashtable.HashTable;

public class HashTableTests {

    @Test
    public void stringTest() {
        HashTable<String,String> table = new HashTable<String,String>();
        table.put("a", "a");
        table.put("b", "b");
        table.put("c", "c");
        table.put("d", "d");
        table.put("e", "e");
        table.put("f", "f");
        table.put("g", "g");
        table.put("h", "h");
        table.put("i", "i");
        table.put("j", "j");
        table.put("k", "k");
        table.put("l", "l");
        String result = table.remove("d");
        assertTrue(result.equals("d"));
        result = table.remove("a");
        assertTrue(result.equals("a"));
        result = table.remove("h");
        assertTrue(result.equals("h"));
        result = table.remove("k");
        assertTrue(result.equals("k"));
        result = table.remove("i");
        assertTrue(result.equals("i"));
    }

    @Test
    public void integerTest() {
        HashTable<Integer, Integer> table = new HashTable<Integer, Integer>();
        for(int i = 0; i < 20; i++) {
            table.put(i, i);
            table.put(i, i);
        }
        assertTrue(true);
    }

    @Test
    public void sameTest() throws NoSuchFieldException, SecurityException {
        HashTable<Integer, Integer> table = new HashTable<Integer, Integer>();
        table.put(1,1);
        table.put(2,2);
        table.put(1,1);
        table.put(2,2);
        table.put(1,1);
        table.put(1,1);
        table.put(1,1);
        table.put(2,2);
        table.put(2,2);
        table.put(1,1);
        table.put(1,1);
        table.put(2,2);
    }
}