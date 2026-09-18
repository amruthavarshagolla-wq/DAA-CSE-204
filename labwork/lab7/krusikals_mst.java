package labwork.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class krusikals_mst {

    static class Edge {
        int u;
        int v;
        int weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static int find(int[] parent, int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int[] rank, int x, int y) {

        int rootx = find(parent, x);
        int rooty = find(parent, y);

        if (rootx == rooty) {
            return;
        }

        if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        }
        else if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        }
        else {
            parent[rooty] = rootx;
            rank[rootx]++;
        }
    }

    static void kruskal(int V, ArrayList<Edge> edges) {

        ArrayList<Edge> mst = new ArrayList<>();

        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < edges.size(); i++) {

            Edge edge = edges.get(i);

            int u = edge.u;
            int v = edge.v;

            int rootu = find(parent, u);
            int rootv = find(parent, v);

            if (rootu != rootv) {

                mst.add(edge);

                union(parent, rank, u, v);

                if (mst.size() == V - 1) {
                    break;
                }
            }
        }

        int totalWeight = 0;

        System.out.println("Minimum Spanning Tree:");

        for (Edge edge : mst) {

            System.out.println(
                edge.u + " - " + edge.v + " : " + edge.weight
            );

            totalWeight += edge.weight;
        }

        System.out.println("Total weight = " + totalWeight);
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        kruskal(V, edges);
    }
}