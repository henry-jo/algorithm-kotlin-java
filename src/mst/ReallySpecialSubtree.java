package mst;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */

    static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < gFrom.size(); i++) {
            edges.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }

        edges.sort(Comparator.comparingInt(o -> o.cost));

        int[] parent = new int[gNodes + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for(Edge edge : edges) {
            int rootX = Result.findRoot(edge.x, parent);
            int rootY = Result.findRoot(edge.y, parent);

            if (rootX != rootY) {
                ans += edge.cost;
                parent[rootY] = rootX;
            }
        }

        return ans;
    }

    // 자신이 속한 부모노드(집합번호)를 찾는다.
    private static int findRoot(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }

        return findRoot(parent[x], parent);
    }

    private static class Edge {
        Integer x;
        Integer y;
        Integer cost;

        Edge(Integer x, Integer y, Integer cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}

public class ReallySpecialSubtree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here
        System.out.println(res);

        bufferedReader.close();
    }
}
