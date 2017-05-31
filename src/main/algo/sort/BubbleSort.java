package main.algo.sort;

import java.util.Scanner;

public class BubbleSort
{
    static void bubblesort(Integer[] ar)
    {
        for (int i = 0 ; i < ar.length - 1 ; i++)
            for (int j = 0 ; j < ar.length - 1 ; j++)
            {
                if ( ar[j] > ar[j + 1] )
                {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] ar = new Integer[n];
        for (int i = 0; i < n; i++)
            ar[i] = in.nextInt();
        bubblesort(ar);
        for (Integer v : ar)
            System.out.print(v+" ");
        System.out.println("");
    }
}
