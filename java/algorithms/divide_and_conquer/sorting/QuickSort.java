
public class QuickSort extends SortingAlgorithm {
    // Constructor
    public QuickSort() {
        super("QuickSort");
    }

    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }
    
    /**
     * Sorts the array using the QuickSort algorithm.
     *
     * @param A the array to be sorted
     * @param l the left index of the subarray to be sorted
     * @param r the right index of the subarray to be sorted
     */
    private void quickSort(int[] A, int l, int r) {
        if (l < r) {
            int pivotIndex = partition(A, l, r); // Partition the array and get pivot index
            quickSort(A, l, pivotIndex - 1); // Recursively sort the left part
            quickSort(A, pivotIndex + 1, r); // Recursively sort the right part
        }
    }

    private int partition(int[] A, int l, int r) {
        int p = A[l]; // Set pivot to the first element
        int i = l + 1; // i marks the boundary of elements less than or equal to the pivot

        for (int j = l + 1; j <= r; j++) { // j scans the rest of the array
            if (A[j] <= p) { // If current element is less than or equal to the pivot
                swap(A, i, j); // Swap A[j] and A[i]
                i++; // Move the boundary to the right
            }
        }

        swap(A, l, i - 1); // Place the pivot between the two partitions
        return i - 1; // Return the final position of the pivot
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
