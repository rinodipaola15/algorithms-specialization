
import java.util.Arrays;

public class MergeSort extends SortingAlgorithm {
    // Costruttore
    public MergeSort() {
        super("MergeSort");
    }
    
    @Override
    public int[] sort(int[] array) {
        if(array.length <= 1)
            return array;
                
        int[] A = Arrays.copyOfRange(array, 0, array.length/2);
        int[] B = Arrays.copyOfRange(array, array.length/2, array.length);
        
        // Order the two halves recursively
        A = sort(A);
        B = sort(B);
            
        // Merge the two ordered halves
        return merge(A, B);
    }
    
    public static int[] merge(int[] A, int[] B) {
        int[] C = new int[A.length + B.length]; // C = output array with size of A + B
        
        int i=0; // index for A
        int j=0; // index for B
        
        for(int k=0; k<C.length; k++) { // k = index for C
            if(i == A.length) { // if i == A.length, then A is exhausted
                C[k] = B[j];
                j++;
            }
            else if(j == B.length) { // if j == B.length, then B is exhausted
                C[k] = A[i];
                i++;
            }
            else if(A[i] <= B[j]) { // if A[i] <= B[j], then A[i] is the next smallest element
                C[k] = A[i];
                i++;
            } else { // if A[i] > B[j], then B[j] is the next smallest element
                C[k] = B[j];
                j++;
            }
        }
        
        return C;
    }
    
}
