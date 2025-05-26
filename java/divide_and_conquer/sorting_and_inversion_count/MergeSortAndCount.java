import java.util.Arrays;

public class MergeSortAndCount extends SortingAndInversionCountAlgorithm {

    // Constructor
    public MergeSortAndCount() {
        super("MergeSortAndCount");
        this.inversionCount = 0;  // reset inversion count at creation
    }

    @Override
    public int[] sortAndCount(int[] array) {
        if (array.length <= 1)
            return array;

        int[] A = Arrays.copyOfRange(array, 0, array.length / 2); // left half
        int[] B = Arrays.copyOfRange(array, array.length / 2, array.length); // right half

        // Recursively sort the left half and count inversions within it
        A = sortAndCount(A); 

        // Recursively sort the right half and count inversions within it
        B = sortAndCount(B); 

        // Merge the two sorted halves and count split inversions (i.e., between A and B)
        return mergeAndCount(A, B);
    }

    private int[] mergeAndCount(int[] A, int[] B) {
        int[] C = new int[A.length + B.length]; // output array
        int i = 0; // index for A
        int j = 0; // index for B

        for (int k = 0; k < C.length; k++) { // index for C
            if (i == A.length) { // A is exhausted
                C[k] = B[j];
                j++;
            } else if (j == B.length) { // B is exhausted
                C[k] = A[i];
                i++;
            } else if (A[i] <= B[j]) { // A[i] is smaller or equal
                C[k] = A[i];
                i++;
            } else { // A[i] > B[j] → inversion found
                C[k] = B[j];
                j++;
                inversionCount += A.length - i; // count how many elements remain in A
            }
        }

        return C;
    }
}
