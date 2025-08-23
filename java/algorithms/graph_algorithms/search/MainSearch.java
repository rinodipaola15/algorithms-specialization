public class MainSearch {
    // Cambia qui il nome dell'algoritmo da testare: "DFS", "DFSTopologicalSort", "DFSSCC", "BFSConnectedComponents", "BFSShortestPaths"
    private static final String SEARCH_ALGORITHM = "BFS";

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Esempio di grafo diretto (importante per DFS topological e SCC)
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);  // ciclo per testare SCC
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        GraphSearchAlgorithm algorithm = GraphSearchAlgorithmFactory.getAlgorithm(SEARCH_ALGORITHM);

        if (algorithm == null) {
            System.out.println("Algorithm not found: " + SEARCH_ALGORITHM);
            return;
        }

        System.out.println("Running: " + algorithm.getName());
        algorithm.run(graph, 1);  // startNode è ignorato se non serve
        algorithm.printResults();
    }
}
