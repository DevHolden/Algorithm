/**
 * 정수 X가 주어졌을 때 사용할 수 있는 연산은 4가지이다.
 * 1. X가 5로 나누어 떨어지면 나눈다.   2. X가 3으로 나누어 떨어지면 나눈다.
 * 3. X가 2로 나누어 떨어지면 나눈다.   4. X에서 1을 뺀다.
 * 정수 X가 주어졌을 때 위 연산을 최소로 사용하여 1로 만드는 횟수를 구하시오.
 */
package DP;

import java.util.Scanner;

import static java.lang.Math.min;

public class MakeNumberOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        makeOne(N);
    }

    /**
     *
     * @param N : 입력받는 정수 N
     */
    private static void makeOne(int N) {
        int[] dp = new int[10000];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 5 == 0) {
                dp[i] = min(dp[i], dp[i / 5] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = min(dp[i], dp[i / 2] + 1);
            }

        }
        System.out.println(dp[N]);
    }
}
