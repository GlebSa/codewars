package codewars;

public class Test {

    public static void main(String[] args) {
//        int i = MaxSubarraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        int i = MaxSubarraySumR.sequence(new int[]{17, -31, 3, 23, 5, 19, -27, -42, -25, -26, -21, 2, 43, -5, 23});
        int i2 = MaxSubarraySum.sequence(new int[]{17, -31, 3, 23, 5, 19, -27, -42, -25, -26, -21, 2, 43, -5, 23});
//        int i = MaxSubarraySum.sequence(new int[]{21, -11, -7, 15, 16, 5, -10, 1, 13, -3, 26, 14, 28, -4, 7, 27, -19, -10, -28, 28, -5, 24, 19, 2, -3, 23, -23, -18, 1, 11, -8, 14, -11, -15, 16, -9, -3, -15, -20, 11, -16, 2, 29, 1, -25, 27, -29, -16, -12, 0, 5, 6, 25, 15, -8});
        System.out.println(i);
        System.out.println(i2);
    }

}
