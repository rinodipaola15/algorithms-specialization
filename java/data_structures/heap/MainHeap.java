import java.util.Collections;
import java.util.PriorityQueue;

public class MainHeap {
    public static void main(String[] args) {
        System.out.println("=== Custom MinHeap ===");

        // Create a MinHeap with capacity 10 (our custom implementation)
        MinHeap h = new MinHeap(10);
        h.insert(5); // Insert value 5
        h.insert(2); // Insert value 2
        h.insert(8); // Insert value 8

        // Extract the minimum values in order
        System.out.println(h.extractMin()); // → 2 (smallest element)
        System.out.println(h.extractMin()); // → 5 (next smallest)
        System.out.println(h.extractMin()); // → 8

        System.out.println("\n=== Java PriorityQueue (MinHeap by default) ===");

        // Create a min-heap using Java's built-in PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(2);
        pq.add(8);

        // Polling retrieves and removes the smallest element
        System.out.println(pq.poll()); // → 2
        System.out.println(pq.poll()); // → 5
        System.out.println(pq.poll()); // → 8

        System.out.println("\n=== Java PriorityQueue as MaxHeap ===");

        // Create a max-heap using reverse order comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(8);

        // Polling retrieves and removes the largest element
        System.out.println(maxHeap.poll()); // → 8
        System.out.println(maxHeap.poll()); // → 5
        System.out.println(maxHeap.poll()); // → 2
    }
}

