package test.datastructure.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

import main.datastructure.hashtable.HashTable;

public class PutTest {

    @Test
    public void test() {
        HashTable<String,String> table = new HashTable<String,String>();
        String result = table.put("string1", "string2");
        assertTrue(result.equals("string2"));
    }
}