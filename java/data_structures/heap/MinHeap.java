public class MinHeap {
    private int[] heap;      // array to store heap elements
    private int size;        // current number of elements in the heap
    private int capacity;    // maximum capacity of the heap

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Compute parent index
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Compute left child index
    private int left(int i) {
        return 2 * i + 1;
    }

    // Compute right child index
    private int right(int i) {
        return 2 * i + 2;
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new RuntimeException("Heap is full");
        }
        // Place the new value at the end (next free position)
        heap[size] = value;
        int i = size;
        size++;

        // "Heapify-up": bubble the new value up until heap property is restored
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin() {
        if (size <= 0) {
            throw new RuntimeException("Heap is empty");
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        // Move last element to root, shrink size
        heap[0] = heap[size - 1];
        size--;
        // Restore heap property by heapifying down from root
        heapify(0);
        return root;
    }

    // "Heapify-down": restore min-heap property at subtree rooted at i
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        // Check if left child exists and is smaller
        if (l < size && heap[l] < heap[smallest]) {
            smallest = l;
        }

        // Check if right child exists and is smaller
        if (r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Utility to swap two elements in the heap array
    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
