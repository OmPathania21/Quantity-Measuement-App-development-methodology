import java.util.Objects;

/**
 * QuantityMeasurementApp class is responsible for checking the equality of
 * two numerical values measured in feet within the Quantity Measurement Application.
 * It ensures accurate comparisons and handles various edge cases.
 */
public class QuantityMeasurementApp {

    /**
     * Inner Feet class to represent a feet measurement.
     * Immutable class that encapsulates a feet measurement value.
     */
    public static class Feet {
        private final double value;

        /**
         * Constructor to initialize a Feet object with a measurement value.
         *
         * @param value the numerical value representing feet measurement
         */
        public Feet(double value) {
            this.value = value;
        }

        /**
         * Returns the value of the feet measurement.
         *
         * @return the measurement value as a double
         */
        public double getValue() {
            return value;
        }

        /**
         * Compares this Feet object with another object for equality.
         * Implements the equals contract:
         * - Reflexive: a.equals(a) returns true
         * - Symmetric: if a.equals(b) then b.equals(a)
         * - Transitive: if a.equals(b) and b.equals(c) then a.equals(c)
         * - Consistent: multiple calls return the same result
         * - Null handling: a.equals(null) returns false
         *
         * @param obj the object to compare with
         * @return true if both objects represent the same feet value, false otherwise
         */
        @Override
        public boolean equals(Object obj) {
            // Check if the same reference
            if (this == obj) {
                return true;
            }

            // Check if null or different type
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            // Safe cast to Feet
            Feet feet = (Feet) obj;

            // Compare double values using Double.compare()
            return Double.compare(this.value, feet.value) == 0;
        }

        /**
         * Returns a hash code for this Feet object.
         * Consistent with equals() method to maintain the hash code contract.
         *
         * @return the hash code value
         */
        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        /**
         * Returns a string representation of this Feet object.
         *
         * @return string representation in the format "Feet{value=X.X}"
         */
        @Override
        public String toString() {
            return "Feet{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * Main method to demonstrate Feet equality comparison.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test Case 1: Two feet objects with the same value
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        System.out.println("Test 1 - Equal values (1.0 ft and 1.0 ft): " + feet1.equals(feet2));

        // Test Case 2: Two feet objects with different values
        Feet feet3 = new Feet(1.0);
        Feet feet4 = new Feet(2.0);
        System.out.println("Test 2 - Different values (1.0 ft and 2.0 ft): " + feet3.equals(feet4));

        // Test Case 3: Reflexive property (a equals itself)
        Feet feet5 = new Feet(1.0);
        System.out.println("Test 3 - Reflexive property (1.0 ft equals itself): " + feet5.equals(feet5));

        // Test Case 4: Null comparison
        Feet feet6 = new Feet(1.0);
        System.out.println("Test 4 - Null comparison (1.0 ft equals null): " + feet6.equals(null));
    }
}
