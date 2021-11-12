// 프림 알고리즘
package MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
    public static class node implements Comparable<node> {
        int loc, w;

        public node(int loc, int w) {
            this.loc = loc;
            this.w = w;
        }

        @Override
        public int compareTo(node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static ArrayList<node>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();   // 정점의 개수
        int E = sc.nextInt();   // 간선의 개수

        arr = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();

            arr[s].add(new node(e, v));
            arr[e].add(new node(s, v));
        }
        Prim(V);
    }

    /**
     * @param V : 정점의 개수
     */
    private static void Prim(int V) {
        boolean[] visit = new boolean[V+1];
        PriorityQueue<node> pq = new PriorityQueue<>();
        int sum = 0;

        pq.add(new node(1, 0));

        while (!pq.isEmpty()) {
            node t = pq.poll();

            if (visit[t.loc]) {
                continue;
            }
            visit[t.loc] = true;
            sum += t.w;

            // 인접한 노드들을 조사
            for (node nd : arr[t.loc]) {
                if (!visit[nd.loc]) {
                    pq.add(nd);
                }
            }
        }
        System.out.println("최소 간선 비용 : " + sum);
    }


}


