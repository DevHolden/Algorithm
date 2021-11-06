package MST;

/**
 * 유니온 파인드 : 두 노드가 한 그래프내에 위치하는지 부모노드 탐색을 통해 여부를 알아냄
 */
public class UnionFind {
    static int[] parent;

    public static void main(String[] args) {

    }

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

        if(x > y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
    // 두 노드가 한 그래프 내에 있는지 여부 판별
    static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) {
            return true;
        } else {
            return false;
        }
    }
}
