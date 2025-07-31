// ------------------------------
// MainSearchDijkstraFromFile.java
// ------------------------------

import java.io.*;

public class MainSearchFromFile {
    public static void main(String[] args) throws IOException {
        GraphWeighted graph = new GraphWeighted();
        String filename = "./java/graph_algorithms/search/dijkstra/dijkstraData.txt"; // graph file
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            String[] tokens = line.split("\\s+");
            int u = Integer.parseInt(tokens[0]);
            for (int i = 1; i < tokens.length; i++) {
                String[] pair = tokens[i].split(",");
                int v = Integer.parseInt(pair[0]);
                int w = Integer.parseInt(pair[1]);
                graph.addEdge(u, v, w);
            }
        }
        br.close();

        int source = 1;
        int[] targets = {7,37,59,82,99,115,133,165,188,197};

        // Choose algorithm: base version or heap
        // GraphWeightedSearchAlgorithm algorithm = new DijkstraStandard();
        GraphWeightedSearchAlgorithm algorithm = new DijkstraHeap();
        algorithm.run(graph, source);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < targets.length; i++) {
            if (i > 0) result.append(",");
            result.append(algorithm.getDistanceTo(targets[i]));
        }
        System.out.println(result);
    }
}
