package test.algo.objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.algo.objects.HashTable;

public class HashTableTest {

    HashTable ht;

    @Before
    public void before() {
        ht = new HashTable();
        for(int i = 100; i > 0; i--) {
            ht.chainedHashInsert(ht, i);
        }
    }

    @Test
    public void searchTestA() {
        assertTrue(ht.chainedHashSearch(ht, 50));
    }

    @Test
    public void searchTestB() {
        assertTrue(ht.chainedHashSearch(ht, 5));
    }

    @Test
    public void searchTestC() {
        assertTrue(ht.chainedHashSearch(ht, 100));
    }

    @Test
    public void deleteTestA() {
        ht.chainedHashDelete(ht, 50);
        assertFalse(ht.chainedHashSearch(ht, 50));
    }

    @Test
    public void deleteTestB() {
        ht.chainedHashDelete(ht, 5);
        assertFalse(ht.chainedHashSearch(ht, 5));
    }

    @Test
    public void deleteTestC() {
        ht.chainedHashDelete(ht, 100);
        assertFalse(ht.chainedHashSearch(ht, 100));
    }

    @After
    public void after() {
        ht = null;
    }
}