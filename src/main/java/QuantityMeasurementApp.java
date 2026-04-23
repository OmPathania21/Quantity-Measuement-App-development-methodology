import java.util.Objects;

/**
 * QuantityMeasurementApp class is responsible for checking the equality of
 * numerical values measured in various units within the Quantity Measurement Application.
 * It uses a generic Quantity class with unit support to eliminate code duplication
 * and apply the DRY (Don't Repeat Yourself) principle.
 * 
 * UC1: Implements Feet measurement equality checking with full equals contract.
 * UC2: Extends UC1 to include Inches with separate equality check methods.
 * UC3 Refactoring: Consolidates Feet and Inches into a single generic Quantity class
 * with support for multiple units defined via LengthUnit enum.
 * UC4 Extension: Adds Yards and Centimeters as additional units, demonstrating
 * the scalability and extensibility of the generic Quantity design.
 */
public class QuantityMeasurementApp {

    /**
     * Enum representing different length units and their conversion factors to feet (base unit).
     * This encapsulates all supported measurement units and their relationships.
     * 
     * Supported Units:
     * - FEET (1.0): Base unit for all conversions
     * - INCH (1/12): 1 inch = 1/12 foot
     * - YARD (3.0): 1 yard = 3 feet (UC4 Extension)
     * - CENTIMETER (0.0328084): 1 cm ≈ 0.0328084 feet (UC4 Extension)
     * 
     * UC4: Demonstrates scalability by adding new units without modifying existing code.
     */
    public enum LengthUnit {
        FEET(1.0),           // Base unit: 1 foot = 1 foot
        INCH(1.0 / 12.0),    // 1 inch = 1/12 foot
        YARD(3.0),           // 1 yard = 3 feet
        CENTIMETER(1.0 / 30.48); // 1 cm = 1/30.48 feet (since 1 inch = 2.54 cm)

        private final double conversionFactorToFeet;

        /**
         * Constructor for LengthUnit enum.
         *
         * @param conversionFactorToFeet the conversion factor from this unit to feet
         */
        LengthUnit(double conversionFactorToFeet) {
            this.conversionFactorToFeet = conversionFactorToFeet;
        }

        /**
         * Returns the conversion factor from this unit to feet.
         *
         * @return the conversion factor to feet
         */
        public double getConversionFactorToFeet() {
            return conversionFactorToFeet;
        }

        /**
         * Converts a value from this unit to feet.
         *
         * @param value the value in this unit
         * @return the equivalent value in feet
         */
        public double convertToFeet(double value) {
            return value * conversionFactorToFeet;
        }
    }

    /**
     * Generic Quantity class representing a measurement with a value and unit type.
     * This class eliminates code duplication by handling all unit types in a single class.
     * Immutable class that encapsulates a measurement value and its unit.
     * 
     * Features:
     * - UC3: Refactored to follow DRY principle and eliminate separate Feet/Inches classes
     * - UC4: Works seamlessly with new units (YARD, CENTIMETER) without code changes
     * - Cross-unit comparison: 1 foot = 12 inches = 1/3 yard automatically
     * - Type-safe: All units are enum-based, eliminating magic strings
     */
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        /**
         * Constructor to initialize a Quantity object with a value and unit.
         *
         * @param value the numerical value representing the measurement
         * @param unit the LengthUnit of the measurement (e.g., FEET, INCH)
         * @throws IllegalArgumentException if unit is null
         */
        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        /**
         * Returns the value of the measurement.
         *
         * @return the measurement value as a double
         */
        public double getValue() {
            return value;
        }

        /**
         * Returns the unit of the measurement.
         *
         * @return the LengthUnit of this measurement
         */
        public LengthUnit getUnit() {
            return unit;
        }

        /**
         * Returns the value of this measurement converted to feet.
         *
         * @return the value converted to feet (base unit)
         */
        public double getValueInFeet() {
            return unit.convertToFeet(value);
        }

        /**
         * Compares this Quantity object with another object for equality.
         * Implements the equals contract:
         * - Reflexive: a.equals(a) returns true
         * - Symmetric: if a.equals(b) then b.equals(a)
         * - Transitive: if a.equals(b) and b.equals(c) then a.equals(c)
         * - Consistent: multiple calls return the same result
         * - Null handling: a.equals(null) returns false
         * 
         * Cross-unit comparison is supported: 1 foot equals 12 inches.
         *
         * @param obj the object to compare with
         * @return true if both objects represent the same measurement when converted to base unit, false otherwise
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

            // Safe cast to Quantity
            Quantity other = (Quantity) obj;

            // Compare values by converting both to base unit (feet)
            return Double.compare(this.getValueInFeet(), other.getValueInFeet()) == 0;
        }

        /**
         * Returns a hash code for this Quantity object.
         * Consistent with equals() method to maintain the hash code contract.
         * Uses the value converted to base unit (feet) for consistency.
         *
         * @return the hash code value
         */
        @Override
        public int hashCode() {
            return Objects.hash(this.getValueInFeet());
        }

        /**
         * Returns a string representation of this Quantity object.
         *
         * @return string representation in the format "Quantity{value=X.X, unit=UNIT}"
         */
        @Override
        public String toString() {
            return "Quantity{" +
                    "value=" + value +
                    ", unit=" + unit +
                    '}';
        }
    }

    // ============== Legacy Classes for Backward Compatibility (UC1 & UC2) ==============

    /**
     * Inner Feet class to represent a feet measurement.
     * DEPRECATED: Use Quantity class with LengthUnit.FEET instead.
     * Maintained for backward compatibility with UC1.
     * Immutable class that encapsulates a feet measurement value.
     */
    /**
     * Inner Feet class to represent a feet measurement.
     * DEPRECATED: Use Quantity class with LengthUnit.FEET instead.
     * Maintained for backward compatibility with UC1.
     * Immutable class that encapsulates a feet measurement value.
     */
    @Deprecated
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
     * DEPRECATED: Use Quantity class with LengthUnit.INCH instead.
     * Maintained for backward compatibility with UC2.
     * Immutable class that encapsulates an inches measurement value.
     */
    @Deprecated
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
     * DEPRECATED: Use checkQuantityEquality with LengthUnit.FEET instead.
     *
     * @param feet1Value the first feet measurement value
     * @param feet2Value the second feet measurement value
     * @return true if the two feet values are equal, false otherwise
     */
    @Deprecated
    public static boolean checkFeetEquality(double feet1Value, double feet2Value) {
        Feet feet1 = new Feet(feet1Value);
        Feet feet2 = new Feet(feet2Value);
        return feet1.equals(feet2);
    }

    /**
     * Static method to check equality of two inches values.
     * DEPRECATED: Use checkQuantityEquality with LengthUnit.INCH instead.
     *
     * @param inches1Value the first inches measurement value
     * @param inches2Value the second inches measurement value
     * @return true if the two inches values are equal, false otherwise
     */
    @Deprecated
    public static boolean checkInchesEquality(double inches1Value, double inches2Value) {
        Inches inches1 = new Inches(inches1Value);
        Inches inches2 = new Inches(inches2Value);
        return inches1.equals(inches2);
    }

    /**
     * Static method to check equality of two Quantity values.
     * Supports cross-unit comparison (e.g., 1 foot equals 12 inches).
     *
     * @param value1 the first measurement value
     * @param unit1 the unit of the first measurement
     * @param value2 the second measurement value
     * @param unit2 the unit of the second measurement
     * @return true if the two quantities are equal (after conversion to base unit), false otherwise
     */
    public static boolean checkQuantityEquality(double value1, LengthUnit unit1, 
                                                 double value2, LengthUnit unit2) {
        Quantity quantity1 = new Quantity(value1, unit1);
        Quantity quantity2 = new Quantity(value2, unit2);
        return quantity1.equals(quantity2);
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

        System.out.println("\n========== UC3: Generic Quantity Class (Same-Unit Comparisons) ==========");
        
        // Test Case 13: Feet to Feet comparison
        Quantity feet_qty1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity feet_qty2 = new Quantity(1.0, LengthUnit.FEET);
        System.out.println("Test 13 - Feet to Feet (1.0 ft and 1.0 ft): " + feet_qty1.equals(feet_qty2));

        // Test Case 14: Inch to Inch comparison
        Quantity inch_qty1 = new Quantity(1.0, LengthUnit.INCH);
        Quantity inch_qty2 = new Quantity(1.0, LengthUnit.INCH);
        System.out.println("Test 14 - Inch to Inch (1.0 inch and 1.0 inch): " + inch_qty1.equals(inch_qty2));

        // Test Case 15: Yard to Yard comparison
        Quantity yard_qty1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity yard_qty2 = new Quantity(1.0, LengthUnit.YARD);
        System.out.println("Test 15 - Yard to Yard (1.0 yard and 1.0 yard): " + yard_qty1.equals(yard_qty2));

        System.out.println("\n========== UC3: Cross-Unit Comparisons (Equivalent Values) ==========");
        
        // Test Case 16: Feet to Inches (1 ft = 12 inches)
        Quantity one_foot = new Quantity(1.0, LengthUnit.FEET);
        Quantity twelve_inches = new Quantity(12.0, LengthUnit.INCH);
        System.out.println("Test 16 - Cross-Unit: 1.0 ft and 12.0 inches: " + one_foot.equals(twelve_inches));

        // Test Case 17: Inches to Feet (symmetric property)
        Quantity twelve_inches_qty = new Quantity(12.0, LengthUnit.INCH);
        Quantity one_foot_qty = new Quantity(1.0, LengthUnit.FEET);
        System.out.println("Test 17 - Cross-Unit Symmetric: 12.0 inches and 1.0 ft: " + twelve_inches_qty.equals(one_foot_qty));

        // Test Case 18: Yards to Feet (1 yard = 3 feet)
        Quantity one_yard = new Quantity(1.0, LengthUnit.YARD);
        Quantity three_feet = new Quantity(3.0, LengthUnit.FEET);
        System.out.println("Test 18 - Cross-Unit: 1.0 yard and 3.0 feet: " + one_yard.equals(three_feet));

        // Test Case 19: Different values across units
        Quantity two_feet = new Quantity(2.0, LengthUnit.FEET);
        Quantity twelve_inches_diff = new Quantity(12.0, LengthUnit.INCH);
        System.out.println("Test 19 - Cross-Unit Different: 2.0 ft and 12.0 inches (should be false): " + two_feet.equals(twelve_inches_diff));

        System.out.println("\n========== UC3: Static Method for Generic Quantity ==========");
        
        // Test Case 20: Static method with cross-unit comparison
        boolean crossUnitResult = checkQuantityEquality(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCH);
        System.out.println("Test 20 - Static method: 1.0 ft and 12.0 inches: " + crossUnitResult);

        // Test Case 21: Static method with same unit
        boolean sameUnitResult = checkQuantityEquality(1.0, LengthUnit.FEET, 1.0, LengthUnit.FEET);
        System.out.println("Test 21 - Static method: 1.0 ft and 1.0 ft: " + sameUnitResult);

        System.out.println("\n========== UC4: Extended Unit Support (Yards and Centimeters) ==========");

        // Yard to Yard comparison
        Quantity yard_qty_same1 = new Quantity(2.0, LengthUnit.YARD);
        Quantity yard_qty_same2 = new Quantity(2.0, LengthUnit.YARD);
        System.out.println("Test 22 - Yard to Yard (2.0 yard and 2.0 yard): " + yard_qty_same1.equals(yard_qty_same2));

        // Yard to Feet conversion (1 yard = 3 feet)
        Quantity one_yard_qty = new Quantity(1.0, LengthUnit.YARD);
        Quantity three_feet_qty = new Quantity(3.0, LengthUnit.FEET);
        System.out.println("Test 23 - Cross-Unit: 1.0 yard and 3.0 feet: " + one_yard_qty.equals(three_feet_qty));

        // Yard to Inches conversion (1 yard = 36 inches)
        Quantity one_yard_inch = new Quantity(1.0, LengthUnit.YARD);
        Quantity thirty_six_inches = new Quantity(36.0, LengthUnit.INCH);
        System.out.println("Test 24 - Cross-Unit: 1.0 yard and 36.0 inches: " + one_yard_inch.equals(thirty_six_inches));

        // Centimeter to Centimeter comparison
        Quantity cm_qty_same1 = new Quantity(2.0, LengthUnit.CENTIMETER);
        Quantity cm_qty_same2 = new Quantity(2.0, LengthUnit.CENTIMETER);
        System.out.println("Test 25 - Centimeter to Centimeter (2.0 cm and 2.0 cm): " + cm_qty_same1.equals(cm_qty_same2));

        // Centimeter to Inches conversion (2.54 cm = 1 inch exactly)
        Quantity two_point_54_cm = new Quantity(2.54, LengthUnit.CENTIMETER);
        Quantity one_inch_cm = new Quantity(1.0, LengthUnit.INCH);
        System.out.println("Test 26 - Cross-Unit: 2.54 cm and 1.0 inch: " + two_point_54_cm.equals(one_inch_cm));

        // Multiple yards conversion (2 yards = 6 feet)
        Quantity two_yards = new Quantity(2.0, LengthUnit.YARD);
        Quantity six_feet = new Quantity(6.0, LengthUnit.FEET);
        System.out.println("Test 27 - Cross-Unit: 2.0 yards and 6.0 feet: " + two_yards.equals(six_feet));

        // Complex transitive property: 1 yard = 3 feet = 36 inches
        Quantity yard_transitive = new Quantity(1.0, LengthUnit.YARD);
        Quantity feet_transitive = new Quantity(3.0, LengthUnit.FEET);
        Quantity inches_transitive = new Quantity(36.0, LengthUnit.INCH);
        System.out.println("Test 28 - Transitive: 1 yard = 3 feet = 36 inches:");
        System.out.println("    - 1 yard equals 3 feet: " + yard_transitive.equals(feet_transitive));
        System.out.println("    - 3 feet equals 36 inches: " + feet_transitive.equals(inches_transitive));
        System.out.println("    - 1 yard equals 36 inches: " + yard_transitive.equals(inches_transitive));

        // Static method with yards
        boolean yard_static = checkQuantityEquality(1.0, LengthUnit.YARD, 3.0, LengthUnit.FEET);
        System.out.println("Test 29 - Static method (Yards): 1.0 yard and 3.0 feet: " + yard_static);

        // Static method with centimeters (2.54 cm = 1 inch)
        boolean cm_static = checkQuantityEquality(2.54, LengthUnit.CENTIMETER, 1.0, LengthUnit.INCH);
        System.out.println("Test 30 - Static method (Centimeters): 2.54 cm and 1.0 inch: " + cm_static);

        System.out.println("\n========== All Tests Completed ==========");
    }
}
