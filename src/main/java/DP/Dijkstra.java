// Dijkstra Algorithm: 한 노드로부터 다른 노드로 가는 모든 최단 경로를 구하는 알고리즘
package DP;

import java.util.Scanner;

import static java.lang.Math.min;

public class Dijkstra {
    static int INF = 10000; // 연결되지 않음
    static int[][] graph =  {{0, 0, 0, 0, 0}
                            ,{0, 0, 3, 6, 7}
                            ,{0, 3, 0, 1, INF}
                            ,{0, 6, 1, 0, 1}
                            ,{0, 7, INF, 1, 0}};

    static boolean[] visit = new boolean[5]; // 방문 노드
    static int[] d = new int[5]; // 거리

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 시작 노드

        dijkstra(N);
    }

    private static void dijkstra(int N) {
        for(int i = 1; i < d.length; i++) {
            d[i] = graph[N][i];
        }

        for(int i = 1; i < visit.length; i++) {
            visit[i] = false;
        }
        visit[N] = true;

        for(int i = 0; i < graph.length-1; i++) {
            int sIndex = 0;
            int sCost = INF;
            for(int j = 1; j < graph[i].length; j++) {
                if(d[j] < sCost && !visit[j]) {
                    sCost = d[j];
                    sIndex = j;
                }
            }
            visit[sIndex] = true;
            for(int j = 1; j < d.length; j++) {
                if(!visit[j] && graph[sIndex][j]!=0 && d[sIndex] != INF) {
                    d[j] = min(d[j], d[sIndex] + graph[sIndex][j]);
                }
            }


        }

        for(int i = 1; i < d.length; i++) {
            System.out.println(i + " ::: " + d[i]);
        }
    }
}
