import java.util.*;

/**
 * Kosaraju's Two-Pass Algorithm for finding Strongly Connected Components (SCCs).
 * Works on directed graphs.
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
        // First pass: run DFS-Loop on reversed graph to compute finishing times
        Graph reversed = reverseGraph(graph);
        finishingTimes = new HashMap<>();
        explored = new HashSet<>();
        finishingTime = 0;

        List<Integer> nodes = new ArrayList<>(reversed.getAllNodes());
        // Process nodes in descending order
        nodes.sort(Comparator.reverseOrder());

        for (int node : nodes) {
            if (!explored.contains(node)) {
                dfsLoopFirstPass(reversed, node);
            }
        }

        // Second pass: run DFS-Loop on original graph in order of decreasing finishing times
        // Build order list sorted by finishing times descending
        List<Map.Entry<Integer, Integer>> order = new ArrayList<>(finishingTimes.entrySet());
        order.sort(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()));

        explored.clear();
        leaders = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : order) {
            int node = entry.getKey();
            if (!explored.contains(node)) {
                currentLeader = node;
                dfsLoopSecondPass(graph, node);
            }
        }
    }

    /**
     * DFS for first pass (on reversed graph), computes finishing times.
     */
    private void dfsLoopFirstPass(Graph graph, int node) {
        explored.add(node);
        for (int neighbor : graph.getAdj(node)) {
            if (!explored.contains(neighbor)) {
                dfsLoopFirstPass(graph, neighbor);
            }
        }
        finishingTime++;
        finishingTimes.put(node, finishingTime);
    }

    /**
     * DFS for second pass (on original graph), assigns leaders to nodes.
     */
    private void dfsLoopSecondPass(Graph graph, int node) {
        explored.add(node);
        leaders.put(node, currentLeader);
        for (int neighbor : graph.getAdj(node)) {
            if (!explored.contains(neighbor)) {
                dfsLoopSecondPass(graph, neighbor);
            }
        }
    }

    /**
     * Utility to reverse all edges of the graph.
     */
    private Graph reverseGraph(Graph graph) {
        Graph reversed = new Graph();
        for (int node : graph.getAllNodes()) {
            for (int neighbor : graph.getAdj(node)) {
                reversed.addEdge(neighbor, node);
            }
        }
        return reversed;
    }

    /**
     * Prints the SCC results (leader -> list of nodes).
     */
    @Override
    public void printResults() {
        // Group nodes by leader to show SCCs
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
            System.out.println("SCC " + sccCount + ": " + group);
        }
    }

    /**
     * Returns the leader map (node -> leader).
     */
    public Map<Integer, Integer> getLeaders() {
        return leaders;
    }
}
