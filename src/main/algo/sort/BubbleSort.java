package main.algo.sort;

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