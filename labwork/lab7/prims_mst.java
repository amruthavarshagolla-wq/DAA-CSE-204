package labwork.lab7;
import java.util.*;


public class prims_mst {

    public static void main(String[] args) {

        int V = 5;

        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        int[] key = new int[V];

        int[] parent = new int[V];

        boolean[] mstSet = new boolean[V];

        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;

        parent[0] = -1;

        for (int count = 0; count < V; count++) {

            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {

                if (graph[u][v] != 0 &&
                    !mstSet[v] &&
                    graph[u][v] < key[v]) {

                    key[v] = graph[u][v];

                    parent[v] = u;
                }
            }
        }

        int totalWeight = 0;

        System.out.println("Edges selected in MST:");

        for (int i = 1; i < V; i++) {

            System.out.println(
                parent[i] + " - " + i + " = " + key[i]
            );

            totalWeight += key[i];
        }

        System.out.println("Total weight of MST = " + totalWeight);
    }

    static int minKey(int[] key, boolean[] mstSet) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {

            if (!mstSet[v] && key[v] < min) {

                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }
}