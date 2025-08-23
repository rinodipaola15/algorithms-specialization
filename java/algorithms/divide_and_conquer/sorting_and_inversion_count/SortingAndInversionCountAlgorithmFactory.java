import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class SortingAndInversionCountAlgorithmFactory {
    private static final Map<String, Supplier<SortingAndInversionCountAlgorithm>> sortingAndInversionCountAlgorithms = new HashMap<>();

    static {
        sortingAndInversionCountAlgorithms.put("MergeSortAndCount", MergeSortAndCount::new);
        //...
        //... Add other sorting and inversion count algorithms here
        //...
    }

    public static SortingAndInversionCountAlgorithm getAlgorithm(String name) {
        Supplier<SortingAndInversionCountAlgorithm> supplier = sortingAndInversionCountAlgorithms.get(name);
        return (supplier != null) ? supplier.get() : null;
    }
}
