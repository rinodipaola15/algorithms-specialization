import java.util.*;

/**
 * Standard Breadth-First Search (BFS).
 * Visits all nodes reachable from a start node in breadth-first order,
 * marking them as explored.
 */
public class BFS extends GraphSearchAlgorithm {
    private final Set<Integer> explored = new HashSet<>();

    public BFS() {
        super("BFS");
    }

    /**
     * Runs BFS starting from the start node.
     *
     * @param graph     The graph on which to run BFS.
     * @param startNode The starting node.
     */
    @Override
    public void run(Graph graph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();

        explored.clear();
        explored.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.getAdj(current)) {
                if (!explored.contains(neighbor)) {
                    explored.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    /**
     * Prints the nodes explored during BFS traversal.
     */
    @Override
    public void printResults() {
        System.out.println("Explored nodes (BFS):");
        for (int node : explored) {
            System.out.println("Node " + node);
        }
    }

    /**
     * Returns the set of explored nodes.
     */
    public Set<Integer> getExploredNodes() {
        return explored;
    }
}
