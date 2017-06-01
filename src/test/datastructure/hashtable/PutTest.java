package test.datastructure.hashtable;

import org.junit.Test;

import main.datastructure.hashtable.HashTable;

public class PutTest {

    @Test(expected=UnsupportedOperationException.class)
    public void test() {
        HashTable<String,String> table = new HashTable<String,String>();
        table.put("string1", "string2");
    }
}