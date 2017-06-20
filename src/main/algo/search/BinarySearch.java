package main.algo.search;

public class BinarySearch {
    public static int binarySearch(int[] a, int find) {
        int l = 0;
        int r = a.length - 1;
        while(l <= r) {
            int m = (l+r)/2;
            if(a[m] < find) l = m + 1;
            if(a[m] > find) r = m - 1;
            if(a[m] == find) return m;
        }
        return -1;
    }
}