package codewars;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSubarraySumEager {
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;

        return new Handler(arr).calc();
    }

    private static class Handler {
        private final int[] arr;
        private int leftBound;
        private int rightBound;
        private int sum;

        private Handler(int[] arr) {
            this.arr = arr;
        }

        private int calc() {
            if (checkNeedToCalc()) {
                while (tryShiftRight() || tryShiftLeft());
            }
            return sum;
        }

        private boolean checkNeedToCalc() {
            boolean positive = false;
            boolean negative = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 0) {
                    positive = true;
                } else if (arr[i] < 0) {
                    negative = true;
                }
            }
            if (positive && negative) {
                leftBound = arr[0] < 0 ? getNextLeftBound(0) : 0;
                rightBound = arr[arr.length - 1] < 0 ? getNextRightBound(arr.length - 1) : arr.length - 1;
                if (leftBound == -1 || rightBound == -1) {
                    throw new IllegalStateException(Arrays.toString(arr));
                }
                sum = getSum(leftBound, rightBound);
                return true;
            } else if (positive) {
                sum = IntStream.of(arr).sum();
            } else {
                sum = 0;
            }
            return false;
        }

        private int getNextLeftBound(int leftBound) {
            for (int i = leftBound; i <= rightBound; i++) {
                if (arr[i] < 0) {
                    return i;
                }
            }
            return -1;
        }

        private boolean tryShiftRight() {
            int shift = getNextLeftBound(leftBound);
            if (shift == -1) return false;

            int newSum = sum;
            for (int i = leftBound; i <= shift; i++) {
                newSum -= arr[i];
            }
            if (newSum > sum) {
                sum = newSum;
                leftBound = shift + 1;
                return true;
            } else if ((newSum = sum - newSum) > sum) {
                sum = newSum;
                rightBound = getNextRightBound(shift);
                return true;
            }
            return false;
        }

        private int getNextRightBound(int rightBound) {
            for (int i = rightBound; i >= leftBound; i--) {
                if (arr[i] < 0) {
                    return i;
                }
            }
            return -1;
        }

        private boolean tryShiftLeft() {
            int shift = getNextRightBound(rightBound);
            if (shift == -1) return false;

            int newSum = sum;
            for (int i = rightBound; i >= shift; i--) {
                newSum -= arr[i];
            }
            if (newSum > sum) {
                sum = newSum;
                rightBound = shift - 1;
                return true;
            } else if ((newSum = sum - newSum) > sum) {
                sum = newSum;
                rightBound = getNextLeftBound(shift);
                return true;
            }
            return false;
        }

        private int getSum(int leftBound, int rightBound) {
            int sum = 0;
            for (int i = leftBound; i <= rightBound; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }
}
