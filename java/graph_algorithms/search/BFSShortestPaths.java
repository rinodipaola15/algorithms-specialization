// ------------------------------
// BFSShortestPaths.java
// ------------------------------

import java.util.*;

public class BFSShortestPaths extends GraphSearchAlgorithm {
    private final Map<Integer, Integer> distance = new HashMap<>(); // Maps each node with the distance to the initial node (i.e., the minimum number of arcs to reach it).
    private final Map<Integer, Integer> parent = new HashMap<>(); // Maps each node to its “parent” in the minimum path. It is used to reconstruct the path from a node to the initial node.

    public BFSShortestPaths() {
        super("BFSShortestPaths");
    }

    @Override
    public void run(Graph graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);
        distance.put(startNode, 0);
        parent.put(startNode, null);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.getAdj(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    distance.put(neighbor, distance.get(current) + 1);
                    parent.put(neighbor, current);
                }
            }
        }
    }

    @Override
    public void printResults() {
        System.out.println("Distances from source:");
        System.out.println(distance);
        System.out.println("Parent map:");
        System.out.println(parent);
    }
}
