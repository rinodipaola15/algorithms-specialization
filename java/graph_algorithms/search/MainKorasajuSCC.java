import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Esegue Kosaraju su un file di input e stampa le 5 SCC più grandi.
 */
public class MainKorasajuSCC {
    public static void main(String[] args) {
        String filename = "./java/graph_algorithms/search/SCC.txt"; // assicurati che sia nella root del progetto

        DirectedGraph graph = new DirectedGraph();

        // Caricamento del grafo dal file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 2) {
                    int from = Integer.parseInt(parts[0]);
                    int to = Integer.parseInt(parts[1]);
                    graph.addEdge(from, to);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
            return;
        }

        // Esecuzione dell’algoritmo
        DFSSCC algo = new DFSSCC();
        algo.run(graph, 0); // startNode ignorato
        printTop5SCCSizes(algo.getLeaders());
    }

    private static void printTop5SCCSizes(Map<Integer, Integer> leaders) {
        Map<Integer, Integer> sccSizes = new HashMap<>();
        for (int leader : leaders.values()) {
            sccSizes.put(leader, sccSizes.getOrDefault(leader, 0) + 1);
        }

        List<Integer> topSizes = sccSizes.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());

        while (topSizes.size() < 5) {
            topSizes.add(0);
        }

        System.out.println("Top 5 SCC sizes: " + String.join(",", topSizes.stream()
                .map(String::valueOf)
                .toArray(String[]::new)));
    }
}
