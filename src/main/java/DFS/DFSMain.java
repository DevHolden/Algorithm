package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFSMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        Graph graph = new Graph(V);

        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);

        graph.printGraph();

        graph.dfs(2);
    }
}