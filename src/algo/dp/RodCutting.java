package algo.dp;

import java.util.Arrays;

public class RodCutting {

    //recursive top down
    public static int cutRod(int[] p, int n) {
        if(n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            q = Math.max(q, p[i] + cutRod(p, n-1));
        }
        return q;
    }

    public static int memoizedCutRod(int[] p, int n) {
        int[] array = new int[n];
        Arrays.fill(array, Integer.MIN_VALUE);
        return memoizedCutRodAux(p, n, array);
    }

    public static int memoizedCutRodAux(int[] p, int n, int[] r) {
        int q = 0;
        if(r[n] >= 0) {
            return r[n];
        }
        if(n == 0) {
            q = 0;
        }
        else {
            q = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                q = Math.max(q, p[i] + memoizedCutRodAux(p, n-i, r));
            }
            r[n] = q;
        }
        return q;
    }

    public static int bottomUpCutRod(int[] p, int n) {
        int[] r = new int[n];
        r[0] = 0;
        for(int j = 1; j < n; j++) {
            int q = Integer.MIN_VALUE;
            for(int i = 1; i < j; i++) {
                q = Math.max(q, p[i] + r[j - i]);
            }
            r[j] = q;
        }
        return r[n];
    }

    public static Pair extendedBottomUpCutRod(int[] p, int n) {
        int[] r = new int[n];
        int[] s = new int[n];
        r[0] = 0;
        for(int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for(int i = 1; i <= j; i++) {
                if(q < p[i] + r[j-1]) {
                    q = p[i] + r[j-1];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        return new Pair(r, s);
    }

    public static void printCutRodSolution(int[] p, int n) {
        Pair pr = extendedBottomUpCutRod(p, n);
        while(n > 0) {
            System.out.print(pr.s[n]);
            n -= pr.s[n];
        }
    }

    static class Pair {
        int[] r;
        int[] s;
        Pair(int[] r, int[] s) {
            this.r = r;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        printCutRodSolution(price, 3);
    }
}