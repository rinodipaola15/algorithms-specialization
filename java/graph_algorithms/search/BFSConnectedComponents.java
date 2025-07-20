// ------------------------------
// BFSConnectedComponents.java
// ------------------------------

import java.util.*;

public class BFSConnectedComponents extends GraphSearchAlgorithm {
    private final Map<Integer, Integer> componentMap = new HashMap<>();
    private int componentCount = 0;

    public BFSConnectedComponents() {
        super("BFSConnectedComponents");
    }

    @Override
    public void run(Graph graph, int ignoredStartNode) {
        Set<Integer> explored = new HashSet<>();
        for (int node : graph.getAllNodes()) {
            if (!explored.contains(node)) {
                componentCount++;
                bfs(graph, node, explored);
            }
        }
    }

    private void bfs(Graph graph, int start, Set<Integer> explored) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        explored.add(start);
        componentMap.put(start, componentCount);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.getAdj(node)) {
                if (!explored.contains(neighbor)) {
                    explored.add(neighbor);
                    queue.add(neighbor);
                    componentMap.put(neighbor, componentCount);
                }
            }
        }
    }

    @Override
    public void printResults() {
        System.out.println("Component count: " + componentCount);
        System.out.println("Component map: " + componentMap);
    }
}
