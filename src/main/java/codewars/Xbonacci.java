package codewars;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Xbonacci {

    public static void main(String... args) {
        System.out.println(Arrays.toString(new Xbonacci().tribonacci(new double[]{1, 1, 1}, 10)));
    }

    public double[] tribonacci(double[] s, int n) {
        double[] r = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            r[i] = DoubleStream.of(r[i - 3], r[i - 2], r[i - 1]).sum();
        }
        return r;
    }
}
