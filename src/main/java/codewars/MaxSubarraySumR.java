package codewars;

import static java.lang.Math.max;

public class MaxSubarraySumR {
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;

        int calc = new Handler(arr).calc();
        return calc;
    }

    private static class Handler {
        private final int[] arr;

        private Handler(int[] arr) {
            this.arr = arr;
        }

        private int calc() {
            return calc(0, arr.length - 1);
        }

        private int calc(int left, int right) {
            if (left > right) {
                return 0;
            } else if (left == right) {
                return arr[left];
            }
            int middle = (left + right) / 2;

            int maxLeft = 0;
            int sum = 0;
            for (int i = middle; i > left; i--) {
                sum += arr[i];
                maxLeft = max(maxLeft, sum);
            }

            int maxRight = 0;
            sum = 0;
            for (int i = middle + 1; i < right; i++) {
                sum += arr[i];
                maxRight = max(maxRight, sum);
            }

            return max(maxLeft + maxRight, max(calc(left, middle), calc(middle + 1, right)));
        }

    }
}
