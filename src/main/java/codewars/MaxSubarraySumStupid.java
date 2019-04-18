package codewars;

public class MaxSubarraySumStupid {
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    public static int sequence2(int[] arr) {
        if (arr.length == 0) return 0;

        int[] cum = new int[arr.length + 1];
        cum[0] = 0;
        for (int i = 1; i < cum.length; i++) {
            cum[i] = cum[i - 1] + arr[i - 1];
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length + 1; j++) {
                int sum = cum[j] - cum[i];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }
}
