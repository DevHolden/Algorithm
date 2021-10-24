// 피보나치 수열(Dynamic Programming)
package DP;

public class Fibonacci {
    private static int[] memoArr = new int[100];

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }

    private static int fibonacci(int N) {
        if (N==0)
            return memoArr[N] = 1;

        if (N==1)
            return memoArr[N] = 1;

        return memoArr[N] = fibonacci(N-1) + fibonacci(N-2);
    }
}
