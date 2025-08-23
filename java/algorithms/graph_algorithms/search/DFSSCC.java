import java.util.*;

/**
 * Kosaraju's Two-Pass Algorithm for finding Strongly Connected Components (SCCs).
 * Uses iterative DFS to avoid StackOverflow on large graphs.
 */
public class DFSSCC extends GraphSearchAlgorithm {
    private Set<Integer> explored;
    private Map<Integer, Integer> finishingTimes;
    private int finishingTime;
    private Map<Integer, Integer> leaders;
    private Integer currentLeader;

    public DFSSCC() {
        super("DFSSCC");
    }

    /**
     * Runs Kosaraju's algorithm to find SCCs.
     * The startNode parameter is ignored.
     *
     * @param graph The directed graph.
     * @param startNode Ignored.
     */
    @Override
    public void run(Graph graph, int startNode) {
        // First pass: run DFS on reversed graph to compute finishing times
        Graph reversed = reverseGraph(graph);
        finishingTimes = new HashMap<>();
        explored = new HashSet<>();
        finishingTime = 0;

        List<Integer> nodes = new ArrayList<>(reversed.getAllNodes());
        // Process nodes in descending order
        nodes.sort(Comparator.reverseOrder());

        for (int node : nodes) {
            if (!explored.contains(node)) {
                dfsLoopFirstPassIterative(reversed, node);
            }
        }

        // Second pass: run DFS on original graph in order of decreasing finishing times
        List<Map.Entry<Integer, Integer>> order = new ArrayList<>(finishingTimes.entrySet());
        order.sort(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()));

        explored.clear();
        leaders = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : order) {
            int node = entry.getKey();
            if (!explored.contains(node)) {
                currentLeader = node;
                dfsLoopSecondPassIterative(graph, node);
            }
        }
    }

    /**
     * Iterative DFS for first pass on reversed graph,
     * computes finishing times.
     */
    private void dfsLoopFirstPassIterative(Graph graph, int startNode) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> tempVisited = new HashSet<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.peek();

            if (!explored.contains(node)) {
                explored.add(node);
                tempVisited.add(node);
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
                if (tempVisited.contains(node)) {
                    finishingTime++;
                    finishingTimes.put(node, finishingTime);
                    tempVisited.remove(node);
                }
            }
        }
    }

    /**
     * Iterative DFS for second pass on original graph,
     * assigns leaders.
     */
    private void dfsLoopSecondPassIterative(Graph graph, int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        explored.add(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            leaders.put(node, currentLeader);

            for (int neighbor : graph.getAdj(node)) {
                if (!explored.contains(neighbor)) {
                    explored.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
    }

    /**
     * Utility to reverse all edges of the graph.
     */
    private Graph reverseGraph(Graph graph) {
        Graph reversed = new DirectedGraph(); // assicurati che DirectedGraph sia usato
        for (int node : graph.getAllNodes()) {
            for (int neighbor : graph.getAdj(node)) {
                reversed.addEdge(neighbor, node);
            }
        }
        return reversed;
    }

    @Override
    public void printResults() {
        Map<Integer, List<Integer>> sccGroups = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : leaders.entrySet()) {
            int node = entry.getKey();
            int leader = entry.getValue();
            sccGroups.computeIfAbsent(leader, k -> new ArrayList<>()).add(node);
        }

        System.out.println("Strongly Connected Components (SCCs):");
        int sccCount = 0;
        for (List<Integer> group : sccGroups.values()) {
            sccCount++;
            System.out.println("SCC " + sccCount + ": " + group.size() + " nodes");
        }
    }

    public Map<Integer, Integer> getLeaders() {
        return leaders;
    }
}
