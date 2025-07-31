import java.util.*;

/**
 * Depth-First Search (DFS) standard, iterative version.
 * Visits all nodes reachable from a start node in depth-first order,
 * marking them as explored.
 */
public class DFS extends GraphSearchAlgorithm {
    private final Set<Integer> explored = new HashSet<>();

    public DFS() {
        super("DFS");
    }

    /**
     * Runs DFS from the start node using an explicit stack.
     *
     * @param graph     The graph on which to run DFS.
     * @param startNode The starting node.
     */
    @Override
    public void run(Graph graph, int startNode) {
        Stack<Integer> stack = new Stack<>();

        explored.clear();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int current = stack.pop(); // Returns the element at the top of the stack (i.e., the last one inserted) and removes it from the stack

            if (!explored.contains(current)) {
                explored.add(current);

                // Push neighbors to stack
                for (int neighbor : graph.getAdj(current)) {
                    if (!explored.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    /**
     * Prints the explored nodes.
     */
    @Override
    public void printResults() {
        System.out.println("Explored nodes (DFS):");
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
