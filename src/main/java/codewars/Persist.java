package codewars;

public class Persist {

    public static void main(String... args) {
        System.out.println(persistence(999));
    }

    public static int persistence(long n) {
        long m = 1, r = n;

        if (r / 10 == 0)
            return 0;

        for (r = n; r != 0; r /= 10)
            m *= r % 10;

        return persistence(m) + 1;

    }


    public static int persistence(Void v, long n) {
        int count = 0;

        String[] arr = String.valueOf(n).split("");
        while (arr.length > 1){
            arr = multiplyDigits(arr);
            count++;
        }

        return count;
    }

    private static String[] multiplyDigits(String[] arr) {

        int sum = Integer.valueOf(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sum *= Integer.valueOf(arr[i]);
        }

        return String.valueOf(sum).split("");
    }

}
