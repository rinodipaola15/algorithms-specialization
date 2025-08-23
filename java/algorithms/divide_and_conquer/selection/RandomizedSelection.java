import java.util.Random;

/**
 * Implementation of the Randomized Selection (RSelect) algorithm.
 * Finds the i-th order statistic (i.e., the i-th smallest element)
 * in an unsorted array using a divide-and-conquer strategy.
 *
 * Expected runtime: O(n)
 * Worst-case runtime: O(n^2)
 */
public class RandomizedSelection {

    private static final Random random = new Random();

    /**
     * Public utility method to start the selection process.
     * @param array The input unsorted array
     * @param i The position of the desired order statistic (1-based: 1 = minimum)
     * @return The i-th smallest element in the array
     */
    public static int select(int[] array, int i) {
        if (i < 1 || i > array.length) {
            throw new IllegalArgumentException("Index out of bounds.");
        }
        return rSelect(array, 0, array.length - 1, i - 1); // Convert i to 0-based
    }

    /**
     * Recursive Randomized Selection algorithm.
     * @param array The array from which to select
     * @param left Left index of the current subarray
     * @param right Right index of the current subarray
     * @param i The desired order statistic (0-based)
     * @return The element being searched for
     */
    private static int rSelect(int[] array, int left, int right, int i) {
        // Base case: only one element left
        if (left == right) {
            return array[left];
        }

        // Choose a random pivot and move it to the end
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(array, pivotIndex, right);

        // Partition the array around the pivot
        int partitionIndex = partition(array, left, right);

        // Check if we found the i-th element
        if (partitionIndex == i) {
            return array[partitionIndex];
        }
        // If the pivot's index is too large, recurse on the left subarray
        else if (partitionIndex > i) {
            return rSelect(array, left, partitionIndex - 1, i);
        }
        // Otherwise, recurse on the right subarray (adjusting i)
        else {
            return rSelect(array, partitionIndex + 1, right, i);
        }
    }

    /**
     * Partitions the array around the pivot (which is at position right).
     * All elements <= pivot go to the left;
     * all elements > pivot go to the right.
     * @return The final position of the pivot (partition index)
     */
    private static int partition(int[] array, int left, int right) {
        int pivotValue = array[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivotValue) {
                swap(array, i, j);
                i++;
            }
        }

        // Move pivot to its final position
        swap(array, i, right);
        return i;
    }

    /**
     * Swaps two elements in the array.
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
