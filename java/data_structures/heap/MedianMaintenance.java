import java.io.*;
import java.util.*;

public class MedianMaintenance {
    public static void main(String[] args) throws IOException {
        // Input file containing the stream of numbers
        String inputFile = "./java/data_structures/heap/median.txt";

        // Two heaps: maxHeap stores the smaller half, minHeap stores the larger half
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min-heap

        long sumMedians = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                int x = Integer.parseInt(line.trim());
                count++;

                // Insert into maxHeap if empty or x <= max of smaller half
                if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
                    maxHeap.offer(x);
                } else {
                    minHeap.offer(x);
                }

                // Balance the heaps so that their sizes differ at most by 1
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }

                // Median is the maximum of the smaller half (maxHeap)
                int median = maxHeap.peek();
                sumMedians += median;
            }
        }

        // Print the sum of medians modulo 10000 (last 4 digits)
        long result = sumMedians % 10000;
        System.out.println("Sum of medians modulo 10000 = " + result);
    }
}
