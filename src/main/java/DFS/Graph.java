package DFS;

public class Graph {
    private int V;  // 정점의 수
    private int adj[][];    // 인접 행렬(그래프)
    private boolean chk[];  // 방문 여부 체크 배열

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
    // 인접 노드
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

    void dfs(int idxV) {
        chk[idxV] = true;
        System.out.print(idxV + " ");

        /** dfs 핵심 알고리즘 : 인접해있으며 아직 방문하지 않았을 때 재귀호출 */
        for(int i=1; i<this.V+1; i++) {
            if(adj[idxV][i] == 1 && chk[i] == false) {
                dfs(i);
            }
        }
    }
}
