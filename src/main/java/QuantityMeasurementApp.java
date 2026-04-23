import java.util.Objects;

/**
 * QuantityMeasurementApp class is responsible for checking the equality of
 * two numerical values measured in feet and inches within the Quantity Measurement Application.
 * It ensures accurate comparisons and handles various edge cases.
 * 
 * Note: This implementation uses separate Feet and Inches classes which currently violates
 * the DRY principle. A future refactoring should extract common logic into a generic Quantity class
 * to eliminate code duplication.
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
     * Inner Inches class to represent an inches measurement.
     * Immutable class that encapsulates an inches measurement value.
     * Implementation mirrors the Feet class structure.
     */
    public static class Inches {
        private final double value;

        /**
         * Constructor to initialize an Inches object with a measurement value.
         *
         * @param value the numerical value representing inches measurement
         */
        public Inches(double value) {
            this.value = value;
        }

        /**
         * Returns the value of the inches measurement.
         *
         * @return the measurement value as a double
         */
        public double getValue() {
            return value;
        }

        /**
         * Compares this Inches object with another object for equality.
         * Implements the equals contract:
         * - Reflexive: a.equals(a) returns true
         * - Symmetric: if a.equals(b) then b.equals(a)
         * - Transitive: if a.equals(b) and b.equals(c) then a.equals(c)
         * - Consistent: multiple calls return the same result
         * - Null handling: a.equals(null) returns false
         *
         * @param obj the object to compare with
         * @return true if both objects represent the same inches value, false otherwise
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

            // Safe cast to Inches
            Inches inches = (Inches) obj;

            // Compare double values using Double.compare()
            return Double.compare(this.value, inches.value) == 0;
        }

        /**
         * Returns a hash code for this Inches object.
         * Consistent with equals() method to maintain the hash code contract.
         *
         * @return the hash code value
         */
        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        /**
         * Returns a string representation of this Inches object.
         *
         * @return string representation in the format "Inches{value=X.X}"
         */
        @Override
        public String toString() {
            return "Inches{" +
                    "value=" + value +
                    '}';
        }
    }

    /**
     * Static method to check equality of two feet values.
     * This method encapsulates the logic for feet equality checks.
     *
     * @param feet1Value the first feet measurement value
     * @param feet2Value the second feet measurement value
     * @return true if the two feet values are equal, false otherwise
     */
    public static boolean checkFeetEquality(double feet1Value, double feet2Value) {
        Feet feet1 = new Feet(feet1Value);
        Feet feet2 = new Feet(feet2Value);
        return feet1.equals(feet2);
    }

    /**
     * Static method to check equality of two inches values.
     * This method encapsulates the logic for inches equality checks.
     *
     * @param inches1Value the first inches measurement value
     * @param inches2Value the second inches measurement value
     * @return true if the two inches values are equal, false otherwise
     */
    public static boolean checkInchesEquality(double inches1Value, double inches2Value) {
        Inches inches1 = new Inches(inches1Value);
        Inches inches2 = new Inches(inches2Value);
        return inches1.equals(inches2);
    }

    /**
     * Main method to demonstrate Feet and Inches equality comparison.
     * This method demonstrates UC1 (Feet equality) and UC2 (Inches equality).
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("========== UC1: Feet Equality Checks ==========");
        
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

        System.out.println("\n========== UC2: Inches Equality Checks ==========");
        
        // Test Case 5: Two inches objects with the same value
        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(1.0);
        System.out.println("Test 5 - Equal values (1.0 inch and 1.0 inch): " + inches1.equals(inches2));

        // Test Case 6: Two inches objects with different values
        Inches inches3 = new Inches(1.0);
        Inches inches4 = new Inches(2.0);
        System.out.println("Test 6 - Different values (1.0 inch and 2.0 inch): " + inches3.equals(inches4));

        // Test Case 7: Reflexive property (a equals itself)
        Inches inches5 = new Inches(1.0);
        System.out.println("Test 7 - Reflexive property (1.0 inch equals itself): " + inches5.equals(inches5));

        // Test Case 8: Null comparison
        Inches inches6 = new Inches(1.0);
        System.out.println("Test 8 - Null comparison (1.0 inch equals null): " + inches6.equals(null));

        System.out.println("\n========== UC2: Static Method Equality Checks ==========");
        
        // Using static methods for feet equality
        System.out.println("Test 9 - Using static method (1.0 ft and 1.0 ft): " + checkFeetEquality(1.0, 1.0));
        System.out.println("Test 10 - Using static method (1.0 ft and 2.0 ft): " + checkFeetEquality(1.0, 2.0));

        // Using static methods for inches equality
        System.out.println("Test 11 - Using static method (1.0 inch and 1.0 inch): " + checkInchesEquality(1.0, 1.0));
        System.out.println("Test 12 - Using static method (1.0 inch and 2.0 inch): " + checkInchesEquality(1.0, 2.0));
    }
