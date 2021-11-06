// 크루스칼 알고리즘
package MST;


import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    static class Edge implements Comparable<Edge>{
        int s, e, cost = 0;

        public Edge(int s, int e, int cost) {
            super();
            this.s = s;
            this.e = e;
            this. cost = cost;
        }
        // Edge의 cost를 비교하도록 재정의
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static ArrayList<Edge> arr;
    static int[] parent;

    public static void main(String[] args) {
        int V = 7;
        int E = 9;

        parent = new int[V+1];
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        arr = new ArrayList<>();

        // 간선 추가
        arr.add(new Edge(1, 2, 29));
        arr.add(new Edge(1, 6, 10));
        arr.add(new Edge(2, 3, 16));
        arr.add(new Edge(2, 7, 15));
        arr.add(new Edge(3, 4, 12));
        arr.add(new Edge(4, 5, 22));
        arr.add(new Edge(4, 7, 18));
        arr.add(new Edge(5, 6, 27));
        arr.add(new Edge(5, 7, 25));

        Collections.sort(arr);

        int ans = kruskal(arr);
        System.out.println(ans);
    }
    // union-find start
    static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return find(parent[x]);
        }
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
    static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return true;
        } else {
            return false;
        }
    }   // union-find end

    static int kruskal(ArrayList<Edge> arr) {
        int sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(!isUnion(arr.get(i).s, arr.get(i).e)) {
                sum += arr.get(i).cost;
                union(arr.get(i).s, arr.get(i).e);
            }
        }
        return sum;
    }

}
