public class QuickSortCounter {
    public enum PivotRule {
        FIRST_ELEMENT,
        LAST_ELEMENT,
        MEDIAN_OF_THREE
    }

    private int comparisons;

    public int sort(int[] array, PivotRule rule) {
        comparisons = 0;
        quickSort(array, 0, array.length - 1, rule);
        return comparisons;
    }

    private void quickSort(int[] A, int left, int right, PivotRule rule) {
        if (left >= right) return;

        comparisons += right - left;

        int pivotIndex = choosePivot(A, left, right, rule);
        swap(A, left, pivotIndex);

        int pivotFinal = partition(A, left, right);
        quickSort(A, left, pivotFinal - 1, rule);
        quickSort(A, pivotFinal + 1, right, rule);
    }

    private int choosePivot(int[] A, int left, int right, PivotRule rule) {
        switch (rule) {
            case FIRST_ELEMENT:
                return left;
            case LAST_ELEMENT:
                return right;
            case MEDIAN_OF_THREE:
                int mid = left + (right - left) / 2;
                int a = A[left], b = A[mid], c = A[right];
                // Return the index of the median of A[left], A[mid], A[right]
                if ((a - b) * (c - a) >= 0) return left;
                else if ((b - a) * (c - b) >= 0) return mid;
                else return right;
            default:
                throw new IllegalArgumentException("Unknown pivot rule");
        }
    }

    private int partition(int[] A, int left, int right) {
        int pivot = A[left];
        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            if (A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }

        swap(A, left, i - 1);
        return i - 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
