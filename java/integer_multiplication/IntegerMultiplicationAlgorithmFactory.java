import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class IntegerMultiplicationAlgorithmFactory {
    private static final Map<String, Supplier<IntegerMultiplicationAlgorithm>> integerMultiplicationAlgorithms = new HashMap<>();

    static {
        integerMultiplicationAlgorithms.put("KaratsubaMultiplication", KaratsubaMultiplication::new);
        //...
        //... Add other integer multiplication algorithms here
        //...
    }

    public static IntegerMultiplicationAlgorithm getAlgorithm(String name) {
        Supplier<IntegerMultiplicationAlgorithm> supplier = integerMultiplicationAlgorithms.get(name);
        return (supplier != null) ? supplier.get() : null;
    }
}
