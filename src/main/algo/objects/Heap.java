package main.algo.objects;

import java.util.Arrays;

public class Heap {

    int[] a;

    int heapSize;

    public static int[] sort(int[] a) {
        Heap h = Heap.buildMaxHeap(a);
        System.out.println("Built: " + Arrays.toString(a));
        for(int i = h.a.length - 1; i >= 1; i--) {
            int temp = h.a[0];
            h.a[0] = h.a[i];
            h.a[i] = temp;
            h.heapSize--;
            h = Heap.maxHeapify(h, 1);
        }
        return h.a;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println("Start: " + Arrays.toString(a));
        int[] sortedArray = Heap.sort(a);
        System.out.println("Final: " + Arrays.toString(sortedArray));
    }

    public static Heap buildMaxHeap(int[] a) {
        Heap h = new Heap();
        h.a = a;
        h.heapSize = h.a.length - 1;
        for(int i = (int)Math.floor(h.heapSize/2); i >= 1; i--) {
            h = Heap.maxHeapify(h, i);
        }
        return h;
    }

    public static Heap maxHeapify(Heap h, int i) {
        int l = left(i) - 1;
        int r = right(i) - 1;
        i = i - 1;
        int largest = 0;
        if(l <= h.heapSize && h.a[l] > h.a[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if(r <= h.heapSize && h.a[r] > h.a[largest]) {
            largest = r;
        }
        if(largest != i) {
            int temp = h.a[i];
            h.a[i] = h.a[largest];
            h.a[largest] = temp;
            maxHeapify(h, largest+1);
        }
        return h;
    }

    public static int Parent(int i) {
        return (int)Math.floor(i/2);
    }

    public static int left(int i) {
        return i * 2;
    }

    public static int right(int i) {
        return i * 2 + 1;
    }
}
