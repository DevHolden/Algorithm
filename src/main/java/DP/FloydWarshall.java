// 플로이드 워셜 알고리즘
package DP;

import static java.lang.Math.min;

public class FloydWarshall {
    static int INF = 1000000;
    static int[][] g = {
            {0, 0, 0, 0, 0},
            {0, 0, 5, INF, 8},
            {0, 7, 0, 9, INF},
            {0, 2, INF, 0, 4},
            {0, INF, INF, 3, 0}
    };
    public static void main(String[] args) {
        FloydWarshall();
    }

    private static void FloydWarshall() {
        // 전역변수 그래프 g의 요소 복사
        int[][] dp = copyArr(g);

        for(int i = 1; i < g.length; i++) { // i를 거쳐갈 때
            for(int j = 1; j < g[i].length; j++) {
                for(int k = 1; k < g[i].length; k++) {
                    if(g[i][j] == 0) {
                        continue;
                    }
                    dp[j][k] = min(dp[j][k], dp[j][i] + dp[i][k]);
                }
            }
        }

        printArr(dp);
    }

    private static void printArr(int[][] arr) {
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <arr.length; i++) {
            for(int j = 1; j <arr[i].length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static int[][] copyArr(int[][] g) {
        int[][] dp = new int[g.length][g[0].length];

        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < g[i].length; j++) {
                dp[i][j] = g[i][j];
            }
        }
        return dp;
    }
}
