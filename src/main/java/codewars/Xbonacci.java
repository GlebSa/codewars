package codewars;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Xbonacci {

    public static void main(String... args) {
        System.out.println(Arrays.toString(new Xbonacci().xbonacci(new double[]{0, 0, 0, 1}, 20)));
    }

    public double[] xbonacci(double[] signature, int n) {
        double[] r = Arrays.copyOf(signature, n);
        for (int i = signature.length; i < n; i++) {
            double[] subarray = Arrays.copyOfRange(r, i - signature.length, i);
            r[i] = DoubleStream.of(subarray).sum();
        }
        return r;
    }

}
