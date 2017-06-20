package test.algo.search;

import static org.junit.Assert.*;

import org.junit.Test;

import main.algo.search.BinarySearch;

public class BinarySearchTest {

    @Test
    public void test() {
        int[] a = {0,1,2,3,4,5,6,7,8,9};
        assertTrue(BinarySearch.binarySearch(a, 2) == 2);
        assertTrue(BinarySearch.binarySearch(a, 3) == 3);
        assertTrue(BinarySearch.binarySearch(a, 6) == 6);
        assertTrue(BinarySearch.binarySearch(a, 9) == 9);
    }
}