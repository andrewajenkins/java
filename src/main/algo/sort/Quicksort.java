package main.algo.sort;

import java.util.Random;

public class Quicksort {

    static Random rand = new Random();
    static int q = -1;

    public static <E extends Comparable<E>> E[] sort(E[] a) {
        return quicksort(a, 0, a.length - 1);
    }

    private static <E extends Comparable<E>> E[] quicksort(E[] a, int p, int r) {
        if(p >= r) return a;
        a = randomizedPartition(a, p, r);
        a = quicksort(a, p, q - 1);
        a = quicksort(a, q, r);
        return a;
    }

    private static <E extends Comparable<E>> E[] randomizedPartition(E[] a, int p, int r) {
        int randomInt = rand.nextInt((r - p) + 1) + p;
        a = swap(a, r, randomInt);
        a = partition(a, p, r);
        return a;
    }

    private static <E extends Comparable<E>> E[] swap(E[] a, int i, int j) {
        E temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    private static <E extends Comparable<E>> E[] partition(E[] a, int p, int r) {
        E x = a[r];
        int i = p - 1;
        for(int j = p; j <= r - 1; j++) {
            if(a[j].compareTo(x) < 1) {
                i++;
                a = swap(a, i, j);
            }
        }
        a = swap(a, i+1, r);
        q = i + 1;
        return a;
    }
}
