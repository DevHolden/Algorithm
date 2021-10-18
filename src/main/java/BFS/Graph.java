package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;
    private int[][] adj;
    private boolean[] chk;

    Graph(int V) {
        this.V = V;
        adj = new int[V+1][V+1];
        chk = new boolean[V+1];

        for(int i=0; i<adj.length; i++){
            for(int j=0; j<adj.length; j++){
                adj[i][j] = 0;
            }
        }
        for(int i=0; i<chk.length; i++){
            chk[i] = false;
        }

    }
    void addEdge(int V1, int V2) {
        adj[V1][V2] = 1;
        adj[V2][V1] = 1;
    }

    int[][] getGraph() {
        return this.adj;
    }

    void printGraph() {
        for(int i=1; i<adj.length; i++) {
            for(int j=1; j<adj.length; j++) {
                System.out.print(adj[i][j]);
            }
            System.out.println();
        }
    }

    void BFS(int idxV) {
        Queue<Integer> q = new LinkedList<Integer>();

        chk[idxV] = true;
        // Queue에 노드 삽입
        q.add(idxV);

        while(!(q.isEmpty())) {
            // 방문 큐에서 dequeue하며 값을 출력
            idxV = q.poll();
            System.out.print(idxV + " ");

            for(int i=1; i<adj.length; i++) {
                // 현재 노드와 인접해있고 아직 방문하지 않은 노드라면
                if(adj[idxV][i] == 1 && chk[i] == false) {
                    q.add(i);
                    chk[i] = true;
                }
            }
        }

    }

}
