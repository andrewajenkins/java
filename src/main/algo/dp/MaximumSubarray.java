package main.algo.dp;

import java.util.Arrays;

public class MaximumSubarray {

    public static int[] find(int[] a, int low, int high) {
        if(high == low) {
            return new int[]{low, high, a[low]};
        } else {
            int mid = (int)Math.floor((low+high)/2);
            int[] left = find(a, low, mid);
            int[] right = find(a, mid+1, high);
            int[] cross = findCrossing(a, low, mid, high);
            if(left[2] >= right[2] && left[2] >= cross[2]) {
                return left;
            } else if(right[2] >= left[2] && right[2] >= cross[2]) {
                return right;
            } else {
                return cross;
            }
        }
    }

    public static int[] findCrossing(int[] a, int low, int mid, int high) {
        int[] result = new int[3];
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                result[0] = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int j = mid+1; j <= high; j++) {
            sum += a[j];
            if(sum > rightSum) {
                rightSum = sum;
                result[1] = j;
            }
        }
        result[2] = leftSum + rightSum;
        return result;
    }

    public static void main(String[] args) {

        int[] stockPrices = new int[]{100, 113, 110, 85, 105, 102, 86, 63,
            81, 101, 94, 106, 101, 79, 94, 90, 97};

        int[] changes = new int[stockPrices.length];

        for(int i = 1; i < stockPrices.length; i++) {
            changes[i] = stockPrices[i] - stockPrices[i-1];
        }

        int[] result = MaximumSubarray.find(changes, 0, changes.length - 1);

        System.out.println(Arrays.toString(result));
    }
}
