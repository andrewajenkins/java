package test.algo.sort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import main.algo.sort.Quicksort;

public class QuicksortTest {

    @Test
    public void integerTest() {
        Integer[] a = {5,9,5,4,8,7,6,2,1,4,6,8,7,9,5,1,7};
        Integer[] sorted = Quicksort.sort(a);
        Arrays.sort(a);
        assertTrue(Arrays.equals(a, sorted));
    }

    @Test
    public void stringTest() {
        String[] a = {"H","D","J","E","Q","K","X","S","Y","A","B"};
        String[] sorted = Quicksort.sort(a);
        Arrays.sort(a);
        assertTrue(Arrays.equals(a, sorted));
    }

    @Test
    public void charTest() {
        Character[] a = {'H','D','J','E','Q','K','X','S','Y','A','B'};
        Character[] sorted = Quicksort.sort(a);
        Arrays.sort(a);
        assertTrue(Arrays.equals(a, sorted));
    }

}