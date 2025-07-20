import java.util.*;

/**
 * DFS for Topological Sorting.
 * Assumes the graph is a Directed Acyclic Graph (DAG).
 * This version uses iterative DFS to avoid stack overflow.
 */
public class DFSTopologicalSort extends GraphSearchAlgorithm {
    private final Set<Integer> explored = new HashSet<>();
    private final Map<Integer, Integer> finishingTimes = new HashMap<>();
    private int currentLabel;

    public DFSTopologicalSort() {
        super("DFSTopologicalSort");
    }

    /**
     * Runs DFS-Loop on all nodes to compute topological order.
     * 
     * @param graph The graph on which to run the topological sort.
     * @param startNode Ignored, since we run DFS on all nodes.
     */
    @Override
    public void run(Graph graph, int startNode) {
        explored.clear();
        int n = graph.getAllNodes().size();
        currentLabel = n;

        for (int node : graph.getAllNodes()) {
            if (!explored.contains(node)) {
                dfsIterative(graph, node);
            }
        }
    }

    /**
     * Iterative DFS that computes finishing times.
     */
    private void dfsIterative(Graph graph, int startNode) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedInStack = new HashSet<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.peek();

            if (!explored.contains(node)) {
                explored.add(node);
            }

            boolean allNeighborsExplored = true;
            for (int neighbor : graph.getAdj(node)) {
                if (!explored.contains(neighbor)) {
                    stack.push(neighbor);
                    allNeighborsExplored = false;
                    break;
                }
            }

            if (allNeighborsExplored) {
                stack.pop();
                if (!finishingTimes.containsKey(node)) {
                    finishingTimes.put(node, currentLabel);
                    currentLabel--;
                }
            }
        }
    }

    /**
     * Prints the topological order based on finishing times.
     */
    @Override
    public void printResults() {
        System.out.println("Topological order (node : finishing time):");
        finishingTimes.entrySet().stream()
            .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()))
            .forEach(entry -> System.out.println("Node " + entry.getKey() + " : " + entry.getValue()));
    }

    /**
     * Returns the map of nodes to their finishing times.
     */
    public Map<Integer, Integer> getFinishingTimes() {
        return finishingTimes;
    }
}
