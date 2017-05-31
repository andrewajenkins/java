package main.algo.sort;

/**
 *  For each element in the array, n, bubble sort traverses the entire
 *  array, n*n, giving it a worst case running time of O(n^2). For each
 *  element it checks to see if the next element is smaller than the
 *  the current element. If true it swaps them in place. Running over
 *  the array n^2 times ensures that the array will be fully sorted
 *  even in the case that it started completely reversed.
 *
 */
public class BubbleSort
{
	public static <E extends Comparable<E>> E[] bubbleSort(E[] ga) {
		for(int i = 0; i < ga.length - 1; i++) {
			for(int j = 0; j < ga.length - 1; j++) {
				if(ga[j].compareTo(ga[j+1]) == 1) {
					E temp = ga[j];
					ga[j] = ga[j+1];
					ga[j+1] = temp;
				}
			}
		}
		return ga;
	}
}