public class MainIntegerMultiplication {
    private static final String INTEGER_MULTIPLICATION_ALGORITHM = "KaratsubaMultiplication";

	public static void main(String[] args) {

        int x = 1234;
        int y = 5678;
        
        // Print input numbers
		System.out.println("x: " + x);
        System.out.println("y: " + y);

        IntegerMultiplicationAlgorithm integerMultiplicationAlgorithm = IntegerMultiplicationAlgorithmFactory.getAlgorithm(INTEGER_MULTIPLICATION_ALGORITHM);

        if(integerMultiplicationAlgorithm == null) {
            System.out.println("Integer multiplication algorithm not found.");
            return;
        }
		
        // multiply input numbers
		int product = integerMultiplicationAlgorithm.multiply(x, y);
		
		// Print multiplication result
        System.out.println("Result of " + x + " * " + y + " = " + product);

	}
}
