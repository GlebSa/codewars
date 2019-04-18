package codewars;

import static java.lang.Math.max;

public class MaxSubarraySum {
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;

        int max = 0;
        int tempMax = 0;

        for (int i = 0; i < arr.length; i++) {
            tempMax = max(tempMax + arr[i], 0);
            max = max(tempMax, max);
        }

        return max;
    }


}
