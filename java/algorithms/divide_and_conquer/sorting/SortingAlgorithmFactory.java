import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SortingAlgorithmFactory {
    private static final Map<String, Supplier<SortingAlgorithm>> sortingAlgorithms = new HashMap<>();

    static {
        sortingAlgorithms.put("MergeSort", MergeSort::new);
        sortingAlgorithms.put("QuickSort", QuickSort::new);
        //...
        //... Add other sorting algorithms here
        //...
    }

    public static SortingAlgorithm getAlgorithm(String name) {
        Supplier<SortingAlgorithm> supplier = sortingAlgorithms.get(name);
        return (supplier != null) ? supplier.get() : null;
    }
}
