/**
 * 개미 전사는 일렬로 배치된 창고를 습격하여 최대한 많은 식량을 얻어야한다.
 * (단, 인접한 창고를 연속하여 습격하면 안됨)
 */

package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class AntWarrior {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];

        String str = br.readLine();
        String[] tmpStr = str.split(" ");
        for(int i = 0; i < tmpStr.length; i++) {
            input[i+1] = Integer.parseInt(tmpStr[i]);
//            System.out.print(input[i] + " ");
        }
        System.out.println(antWarrior(input, N+1));

    }

    /**
     *
     * @param input : 창고의 식량 수 ex. 1 3 1 5 = 0번창고 : 1개, 1번창고 : 3개, 2번창고 : 1개, 3번창고 : 5개의 식량 저장
     * @param N : 창고의 수
     * @return : N개의 창고 중 가장 식량을 많이 약탈하는 개수
     */
    private static int antWarrior(int[] input, int N) {
        int[] dp = new int[input.length];

        dp[1] = input[1];

        for (int i = 2; i < input.length; i++) {
            int q = -1;
            q = max(dp[i-1], dp[i-2] + input[i]);

            dp[i] = q;
        }
        return dp[N-1];
    }
}
