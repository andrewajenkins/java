package algo.dp;

import java.util.Arrays;

public class Steps {
    public static int countWays(int n) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else {
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
        }
    }
    public static int countWaysDP(int n, int[] map) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else if(map[n] > -1) {
            return map[n];
        } else {
            map[n] = countWaysDP(n-1, map) +
                    countWaysDP(n-2, map) +
                    countWaysDP(n-3, map);
            System.out.println("n: " + n + " " + Arrays.toString(map));
            return map[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
        int[] map = new int[10];
        Arrays.fill(map, -1);
        System.out.println(countWaysDP(9, map));
    }
}