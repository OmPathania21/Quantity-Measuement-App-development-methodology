import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the QuantityMeasurementApp class - UC3 Refactoring.
 * Tests the generic Quantity class with LengthUnit enum for comprehensive unit testing.
 * Includes tests from UC1, UC2, and new UC3 tests for cross-unit comparison.
 */
@DisplayName("Quantity Measurement App - UC3 Generic Quantity Tests")
public class QuantityMeasurementAppTest {

    // ============== Feet Tests (UC1) ==============

    /**
     * Test: Feet equality with same numerical value (1.0 ft and 1.0 ft)
     * Verifies that two Feet objects with the same value are considered equal.
     * Tests: equals() returns true when comparing equivalent values.
     */
    @Test
    @DisplayName("testEquality_SameValue - Two Feet objects with value 1.0 should be equal")
    public void testFeetEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "Two Feet objects with the same value (1.0) should be equal");
    }

    /**
     * Test: Feet inequality with different numerical values (1.0 ft and 2.0 ft)
     * Verifies that two Feet objects with different values are not equal.
     * Tests: equals() returns false when comparing different values.
     */
    @Test
    @DisplayName("testEquality_DifferentValue - Two Feet objects with different values should not be equal")
    public void testFeetEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(feet1.equals(feet2), "Two Feet objects with different values (1.0 and 2.0) should not be equal");
    }

    /**
     * Test: Feet comparison with null
     * Verifies that a Feet object is not equal to null.
     * Tests: equals() returns false when comparing with null.
     */
    @Test
    @DisplayName("testEquality_NullComparison - Feet object should not be equal to null")
    public void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(feet.equals(null), "Feet object should not be equal to null");
    }

    /**
     * Test: Feet equality with same reference (reflexive property)
     * Verifies that a Feet object is equal to itself.
     * Tests: equals() returns true when comparing an object with itself.
     * Tests the reflexive property: a.equals(a) must return true.
     */
    @Test
    @DisplayName("testEquality_SameReference - Feet object should equal itself")
    public void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet.equals(feet), "Feet object should equal itself (reflexive property)");
    }

    /**
     * Test: Feet symmetric property of equality
     * Verifies that if a.equals(b) then b.equals(a).
     * Tests the symmetric property of the equals contract.
     */
    @Test
    @DisplayName("testEquality_SymmetricProperty - Symmetric property: if a.equals(b) then b.equals(a)")
    public void testFeetEquality_SymmetricProperty() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "feet1 should equal feet2");
        assertTrue(feet2.equals(feet1), "feet2 should equal feet1 (symmetric property)");
    }

    /**
     * Test: Feet transitive property of equality
     * Verifies that if a.equals(b) and b.equals(c) then a.equals(c).
     * Tests the transitive property of the equals contract.
     */
    @Test
    @DisplayName("testEquality_TransitiveProperty - Transitive property: if a.equals(b) and b.equals(c) then a.equals(c)")
    public void testFeetEquality_TransitiveProperty() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet3 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "feet1 should equal feet2");
        assertTrue(feet2.equals(feet3), "feet2 should equal feet3");
        assertTrue(feet1.equals(feet3), "feet1 should equal feet3 (transitive property)");
    }

    /**
     * Test: Feet consistent property of equality
     * Verifies that multiple calls to equals() return the same result.
     * Tests the consistent property of the equals contract.
     */
    @Test
    @DisplayName("testEquality_ConsistentProperty - Multiple calls to equals should return the same result")
    public void testFeetEquality_ConsistentProperty() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        boolean firstCall = feet1.equals(feet2);
        boolean secondCall = feet1.equals(feet2);
        boolean thirdCall = feet1.equals(feet2);

        assertTrue(firstCall, "First call should return true");
        assertTrue(secondCall, "Second call should return true");
        assertTrue(thirdCall, "Third call should return true");
        assertTrue(firstCall == secondCall && secondCall == thirdCall, 
            "Multiple calls should return consistent results");
    }

    /**
     * Test: Feet comparison with different type
     * Verifies that a Feet object is not equal to objects of different types.
     * Tests type safety.
     */
    @Test
    @DisplayName("testEquality_NonNumericInput - Feet object should not be equal to different types")
    public void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        String notAFeet = "1.0";

        assertFalse(feet.equals(notAFeet), "Feet object should not be equal to a String object");
    }

    /**
     * Test: Feet comparison with floating-point precision
     * Verifies that two Feet objects with floating-point values are compared correctly.
     * Tests Double.compare() usage for precise comparison.
     */
    @Test
    @DisplayName("testEquality_FloatingPointComparison - Feet objects with floating-point values should compare correctly")
    public void testFeetEquality_FloatingPointComparison() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.5);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.5);

        assertTrue(feet1.equals(feet2), "Feet objects with same floating-point value (1.5) should be equal");
    }

    /**
     * Test: Feet comparison with zero value
     * Verifies that Feet objects with zero values are compared correctly.
     */
    @Test
    @DisplayName("testEquality_ZeroValue - Feet objects with zero value should be equal")
    public void testFeetEquality_ZeroValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(0.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(0.0);

        assertTrue(feet1.equals(feet2), "Feet objects with zero value (0.0) should be equal");
    }

    /**
     * Test: Feet comparison with negative values
     * Verifies that Feet objects with negative values are compared correctly.
     */
    @Test
    @DisplayName("testEquality_NegativeValue - Feet objects with negative values should be compared correctly")
    public void testFeetEquality_NegativeValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(-1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(-1.0);

        assertTrue(feet1.equals(feet2), "Feet objects with negative values (-1.0) should be equal");
    }

    /**
     * Test: Feet HashCode consistency
     * Verifies that equal objects have the same hash code.
     * Tests the hash code contract: if a.equals(b) then a.hashCode() == b.hashCode().
     */
    @Test
    @DisplayName("testHashCode_Consistency - Equal Feet objects should have the same hash code")
    public void testFeetHashCode_Consistency() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "feet1 should equal feet2");
        assertEquals(feet1.hashCode(), feet2.hashCode(), 
            "Equal objects should have the same hash code");
    }

    /**
     * Test: Feet value retrieval
     * Verifies that the getValue() method returns the correct measurement value.
     */
    @Test
    @DisplayName("testGetValue - getValue should return the correct measurement value")
    public void testFeetGetValue() {
        double expectedValue = 5.5;
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(expectedValue);

        assertEquals(expectedValue, feet.getValue(), 
            "getValue() should return the correct measurement value");
    }

    // ============== Inches Tests (UC2) ==============

    /**
     * Test: Inches equality with same numerical value (1.0 inch and 1.0 inch)
     * Verifies that two Inches objects with the same value are considered equal.
     * Tests: equals() returns true when comparing equivalent values.
     */
    @Test
    @DisplayName("testInchesEquality_SameValue - Two Inches objects with value 1.0 should be equal")
    public void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches1.equals(inches2), "Two Inches objects with the same value (1.0) should be equal");
    }

    /**
     * Test: Inches inequality with different numerical values (1.0 inch and 2.0 inch)
     * Verifies that two Inches objects with different values are not equal.
     * Tests: equals() returns false when comparing different values.
     */
    @Test
    @DisplayName("testInchesEquality_DifferentValue - Two Inches objects with different values should not be equal")
    public void testInchesEquality_DifferentValue() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(2.0);

        assertFalse(inches1.equals(inches2), "Two Inches objects with different values (1.0 and 2.0) should not be equal");
    }

    /**
     * Test: Inches comparison with null
     * Verifies that an Inches object is not equal to null.
     * Tests: equals() returns false when comparing with null.
     */
    @Test
    @DisplayName("testInchesEquality_NullComparison - Inches object should not be equal to null")
    public void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);

        assertFalse(inches.equals(null), "Inches object should not be equal to null");
    }

    /**
     * Test: Inches equality with same reference (reflexive property)
     * Verifies that an Inches object is equal to itself.
     * Tests: equals() returns true when comparing an object with itself.
     * Tests the reflexive property: a.equals(a) must return true.
     */
    @Test
    @DisplayName("testInchesEquality_SameReference - Inches object should equal itself")
    public void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches.equals(inches), "Inches object should equal itself (reflexive property)");
    }

    /**
     * Test: Inches symmetric property of equality
     * Verifies that if a.equals(b) then b.equals(a).
     * Tests the symmetric property of the equals contract.
     */
    @Test
    @DisplayName("testInchesEquality_SymmetricProperty - Symmetric property: if a.equals(b) then b.equals(a)")
    public void testInchesEquality_SymmetricProperty() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches1.equals(inches2), "inches1 should equal inches2");
        assertTrue(inches2.equals(inches1), "inches2 should equal inches1 (symmetric property)");
    }

    /**
     * Test: Inches transitive property of equality
     * Verifies that if a.equals(b) and b.equals(c) then a.equals(c).
     * Tests the transitive property of the equals contract.
     */
    @Test
    @DisplayName("testInchesEquality_TransitiveProperty - Transitive property: if a.equals(b) and b.equals(c) then a.equals(c)")
    public void testInchesEquality_TransitiveProperty() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches3 = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches1.equals(inches2), "inches1 should equal inches2");
        assertTrue(inches2.equals(inches3), "inches2 should equal inches3");
        assertTrue(inches1.equals(inches3), "inches1 should equal inches3 (transitive property)");
    }

    /**
     * Test: Inches consistent property of equality
     * Verifies that multiple calls to equals() return the same result.
     * Tests the consistent property of the equals contract.
     */
    @Test
    @DisplayName("testInchesEquality_ConsistentProperty - Multiple calls to equals should return the same result")
    public void testInchesEquality_ConsistentProperty() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.0);

        boolean firstCall = inches1.equals(inches2);
        boolean secondCall = inches1.equals(inches2);
        boolean thirdCall = inches1.equals(inches2);

        assertTrue(firstCall, "First call should return true");
        assertTrue(secondCall, "Second call should return true");
        assertTrue(thirdCall, "Third call should return true");
        assertTrue(firstCall == secondCall && secondCall == thirdCall, 
            "Multiple calls should return consistent results");
    }

    /**
     * Test: Inches comparison with different type
     * Verifies that an Inches object is not equal to objects of different types.
     * Tests type safety.
     */
    @Test
    @DisplayName("testInchesEquality_NonNumericInput - Inches object should not be equal to different types")
    public void testInchesEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);
        String notAnInches = "1.0";

        assertFalse(inches.equals(notAnInches), "Inches object should not be equal to a String object");
    }

    /**
     * Test: Inches comparison with floating-point precision
     * Verifies that two Inches objects with floating-point values are compared correctly.
     * Tests Double.compare() usage for precise comparison.
     */
    @Test
    @DisplayName("testInchesEquality_FloatingPointComparison - Inches objects with floating-point values should compare correctly")
    public void testInchesEquality_FloatingPointComparison() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.5);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.5);

        assertTrue(inches1.equals(inches2), "Inches objects with same floating-point value (1.5) should be equal");
    }

    /**
     * Test: Inches comparison with zero value
     * Verifies that Inches objects with zero values are compared correctly.
     */
    @Test
    @DisplayName("testInchesEquality_ZeroValue - Inches objects with zero value should be equal")
    public void testInchesEquality_ZeroValue() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(0.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(0.0);

        assertTrue(inches1.equals(inches2), "Inches objects with zero value (0.0) should be equal");
    }

    /**
     * Test: Inches comparison with negative values
     * Verifies that Inches objects with negative values are compared correctly.
     */
    @Test
    @DisplayName("testInchesEquality_NegativeValue - Inches objects with negative values should be compared correctly")
    public void testInchesEquality_NegativeValue() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(-1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(-1.0);

        assertTrue(inches1.equals(inches2), "Inches objects with negative values (-1.0) should be equal");
    }

    /**
     * Test: Inches HashCode consistency
     * Verifies that equal objects have the same hash code.
     * Tests the hash code contract: if a.equals(b) then a.hashCode() == b.hashCode().
     */
    @Test
    @DisplayName("testInchesHashCode_Consistency - Equal Inches objects should have the same hash code")
    public void testInchesHashCode_Consistency() {
        QuantityMeasurementApp.Inches inches1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inches2 = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inches1.equals(inches2), "inches1 should equal inches2");
        assertEquals(inches1.hashCode(), inches2.hashCode(), 
            "Equal objects should have the same hash code");
    }

    /**
     * Test: Inches value retrieval
     * Verifies that the getValue() method returns the correct measurement value.
     */
    @Test
    @DisplayName("testInchesGetValue - getValue should return the correct measurement value")
    public void testInchesGetValue() {
        double expectedValue = 5.5;
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(expectedValue);

        assertEquals(expectedValue, inches.getValue(), 
            "getValue() should return the correct measurement value");
    }

    // ============== Static Method Tests (UC2) ==============

    /**
     * Test: Static method for feet equality with same values
     * Verifies that the checkFeetEquality static method works correctly.
     */
    @Test
    @DisplayName("testStaticMethod_FeetEquality_SameValue - Static method should return true for equal feet values")
    public void testStaticMethod_FeetEquality_SameValue() {
        boolean result = QuantityMeasurementApp.checkFeetEquality(1.0, 1.0);
        assertTrue(result, "Static method checkFeetEquality(1.0, 1.0) should return true");
    }

    /**
     * Test: Static method for feet equality with different values
     * Verifies that the checkFeetEquality static method returns false for different values.
     */
    @Test
    @DisplayName("testStaticMethod_FeetEquality_DifferentValue - Static method should return false for different feet values")
    public void testStaticMethod_FeetEquality_DifferentValue() {
        boolean result = QuantityMeasurementApp.checkFeetEquality(1.0, 2.0);
        assertFalse(result, "Static method checkFeetEquality(1.0, 2.0) should return false");
    }

    /**
     * Test: Static method for inches equality with same values
     * Verifies that the checkInchesEquality static method works correctly.
     */
    @Test
    @DisplayName("testStaticMethod_InchesEquality_SameValue - Static method should return true for equal inches values")
    public void testStaticMethod_InchesEquality_SameValue() {
        boolean result = QuantityMeasurementApp.checkInchesEquality(1.0, 1.0);
        assertTrue(result, "Static method checkInchesEquality(1.0, 1.0) should return true");
    }

    /**
     * Test: Static method for inches equality with different values
     * Verifies that the checkInchesEquality static method returns false for different values.
     */
    @Test
    @DisplayName("testStaticMethod_InchesEquality_DifferentValue - Static method should return false for different inches values")
    public void testStaticMethod_InchesEquality_DifferentValue() {
        boolean result = QuantityMeasurementApp.checkInchesEquality(1.0, 2.0);
        assertFalse(result, "Static method checkInchesEquality(1.0, 2.0) should return false");
    }

    // ============== Cross-Type Inequality Tests ==============

    /**
     * Test: Feet and Inches are different types
     * Verifies that Feet and Inches objects are not equal to each other.
     * They should be treated as separate types (no cross-unit comparison).
     */
    @Test
    @DisplayName("testCrossType_FeetAndInchesNotEqual - Feet and Inches should not be equal as different types")
    public void testCrossType_FeetAndInchesNotEqual() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Inches inches = new QuantityMeasurementApp.Inches(1.0);

        assertFalse(feet.equals(inches), "Feet object should not be equal to Inches object (different types)");
    }

    // ============== UC3: Quantity Class - Same Unit Tests ==============

    /**
     * Test: Quantity equality with Feet to Feet (same unit, same value)
     */
    @Test
    @DisplayName("testQuantity_FeetToFeet_SameValue - Two Feet quantities with same value should be equal")
    public void testQuantity_FeetToFeet_SameValue() {
        QuantityMeasurementApp.Quantity feet1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity feet2 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(feet1.equals(feet2), "Two Feet quantities with the same value (1.0 ft) should be equal");
    }

    /**
     * Test: Quantity equality with Inches to Inches (same unit, same value)
     */
    @Test
    @DisplayName("testQuantity_InchToInch_SameValue - Two Inch quantities with same value should be equal")
    public void testQuantity_InchToInch_SameValue() {
        QuantityMeasurementApp.Quantity inch1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity inch2 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(inch1.equals(inch2), "Two Inch quantities with the same value (1.0 inch) should be equal");
    }

    /**
     * Test: Quantity equality with Yards to Yards (same unit, same value)
     */
    @Test
    @DisplayName("testQuantity_YardToYard_SameValue - Two Yard quantities with same value should be equal")
    public void testQuantity_YardToYard_SameValue() {
        QuantityMeasurementApp.Quantity yard1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.Quantity yard2 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertTrue(yard1.equals(yard2), "Two Yard quantities with the same value (1.0 yard) should be equal");
    }

    /**
     * Test: Quantity inequality with Feet to Feet (same unit, different values)
     */
    @Test
    @DisplayName("testQuantity_FeetToFeet_DifferentValue - Two Feet quantities with different values should not be equal")
    public void testQuantity_FeetToFeet_DifferentValue() {
        QuantityMeasurementApp.Quantity feet1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity feet2 = new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(feet1.equals(feet2), "Two Feet quantities with different values (1.0 and 2.0 ft) should not be equal");
    }

    /**
     * Test: Quantity inequality with Inches to Inches (same unit, different values)
     */
    @Test
    @DisplayName("testQuantity_InchToInch_DifferentValue - Two Inch quantities with different values should not be equal")
    public void testQuantity_InchToInch_DifferentValue() {
        QuantityMeasurementApp.Quantity inch1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity inch2 = new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertFalse(inch1.equals(inch2), "Two Inch quantities with different values (1.0 and 2.0 inch) should not be equal");
    }

    // ============== UC3: Quantity Class - Cross-Unit Tests ==============

    /**
     * Test: Cross-unit equality - Feet to Inches (1 foot = 12 inches)
     */
    @Test
    @DisplayName("testQuantity_FeetToInch_EquivalentValue - 1 foot equals 12 inches (cross-unit)")
    public void testQuantity_FeetToInch_EquivalentValue() {
        QuantityMeasurementApp.Quantity one_foot = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity twelve_inches = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(one_foot.equals(twelve_inches), "1 foot should equal 12 inches (cross-unit comparison)");
    }

    /**
     * Test: Cross-unit equality (symmetric) - Inches to Feet
     */
    @Test
    @DisplayName("testQuantity_InchToFeet_EquivalentValue_Symmetric - 12 inches equals 1 foot (symmetry)")
    public void testQuantity_InchToFeet_EquivalentValue_Symmetric() {
        QuantityMeasurementApp.Quantity twelve_inches = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity one_foot = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(twelve_inches.equals(one_foot), "12 inches should equal 1 foot (symmetric property)");
    }

    /**
     * Test: Cross-unit equality - Yards to Feet (1 yard = 3 feet)
     */
    @Test
    @DisplayName("testQuantity_YardToFeet_EquivalentValue - 1 yard equals 3 feet (cross-unit)")
    public void testQuantity_YardToFeet_EquivalentValue() {
        QuantityMeasurementApp.Quantity one_yard = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.Quantity three_feet = new QuantityMeasurementApp.Quantity(3.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(one_yard.equals(three_feet), "1 yard should equal 3 feet (cross-unit comparison)");
    }

    /**
     * Test: Cross-unit equality - Feet to Yards (symmetric)
     */
    @Test
    @DisplayName("testQuantity_FeetToYard_EquivalentValue_Symmetric - 3 feet equals 1 yard (symmetry)")
    public void testQuantity_FeetToYard_EquivalentValue_Symmetric() {
        QuantityMeasurementApp.Quantity three_feet = new QuantityMeasurementApp.Quantity(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity one_yard = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertTrue(three_feet.equals(one_yard), "3 feet should equal 1 yard (symmetric property)");
    }

    /**
     * Test: Cross-unit inequality - 2 feet does not equal 12 inches
     */
    @Test
    @DisplayName("testQuantity_CrossUnit_DifferentValue - 2 feet does not equal 12 inches")
    public void testQuantity_CrossUnit_DifferentValue() {
        QuantityMeasurementApp.Quantity two_feet = new QuantityMeasurementApp.Quantity(2.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity twelve_inches = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertFalse(two_feet.equals(twelve_inches), "2 feet should not equal 12 inches");
    }

    /**
     * Test: Cross-unit - Inches to Yards (equivalent)
     */
    @Test
    @DisplayName("testQuantity_InchToYard_EquivalentValue - 36 inches equals 1 yard")
    public void testQuantity_InchToYard_EquivalentValue() {
        QuantityMeasurementApp.Quantity thirtysix_inches = new QuantityMeasurementApp.Quantity(36.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity one_yard = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.YARD);

        assertTrue(thirtysix_inches.equals(one_yard), "36 inches should equal 1 yard");
    }

    // ============== UC3: Quantity Class - Equality Contract Tests ==============

    /**
     * Test: Reflexive property - a equals itself
     */
    @Test
    @DisplayName("testQuantity_ReflexiveProperty - Quantity should equal itself")
    public void testQuantity_ReflexiveProperty() {
        QuantityMeasurementApp.Quantity quantity = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(quantity.equals(quantity), "Quantity should equal itself (reflexive property)");
    }

    /**
     * Test: Symmetric property - if a equals b then b equals a
     */
    @Test
    @DisplayName("testQuantity_SymmetricProperty - Symmetric property for cross-unit comparison")
    public void testQuantity_SymmetricProperty() {
        QuantityMeasurementApp.Quantity one_foot = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity twelve_inches = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(one_foot.equals(twelve_inches), "one_foot should equal twelve_inches");
        assertTrue(twelve_inches.equals(one_foot), "twelve_inches should equal one_foot (symmetric property)");
    }

    /**
     * Test: Transitive property - if a equals b and b equals c then a equals c
     */
    @Test
    @DisplayName("testQuantity_TransitiveProperty - Transitive property for cross-unit comparison")
    public void testQuantity_TransitiveProperty() {
        QuantityMeasurementApp.Quantity twelve_inches = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);
        QuantityMeasurementApp.Quantity one_foot = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity one_foot_again = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(twelve_inches.equals(one_foot), "12 inches should equal 1 foot");
        assertTrue(one_foot.equals(one_foot_again), "1 foot should equal 1 foot");
        assertTrue(twelve_inches.equals(one_foot_again), "12 inches should equal 1 foot (transitive property)");
    }

    /**
     * Test: Null comparison
     */
    @Test
    @DisplayName("testQuantity_NullComparison - Quantity should not equal null")
    public void testQuantity_NullComparison() {
        QuantityMeasurementApp.Quantity quantity = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(quantity.equals(null), "Quantity should not equal null");
    }

    /**
     * Test: Different type comparison
     */
    @Test
    @DisplayName("testQuantity_DifferentTypeComparison - Quantity should not equal different types")
    public void testQuantity_DifferentTypeComparison() {
        QuantityMeasurementApp.Quantity quantity = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        String notAQuantity = "1.0";

        assertFalse(quantity.equals(notAQuantity), "Quantity should not equal a String");
    }

    /**
     * Test: Null unit throws exception
     */
    @Test
    @DisplayName("testQuantity_NullUnit - Constructor should throw exception for null unit")
    public void testQuantity_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityMeasurementApp.Quantity(1.0, null);
        }, "Constructor should throw IllegalArgumentException for null unit");
    }

    // ============== UC3: Quantity Class - Hash Code Tests ==============

    /**
     * Test: Hash code consistency for same-unit equal quantities
     */
    @Test
    @DisplayName("testQuantity_HashCode_SameUnit - Equal quantities should have same hash code")
    public void testQuantity_HashCode_SameUnit() {
        QuantityMeasurementApp.Quantity feet1 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity feet2 = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(feet1.equals(feet2), "feet1 should equal feet2");
        assertEquals(feet1.hashCode(), feet2.hashCode(), "Equal quantities should have the same hash code");
    }

    /**
     * Test: Hash code consistency for cross-unit equal quantities
     */
    @Test
    @DisplayName("testQuantity_HashCode_CrossUnit - Cross-unit equal quantities should have same hash code")
    public void testQuantity_HashCode_CrossUnit() {
        QuantityMeasurementApp.Quantity one_foot = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity twelve_inches = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(one_foot.equals(twelve_inches), "1 foot should equal 12 inches");
        assertEquals(one_foot.hashCode(), twelve_inches.hashCode(), 
            "Cross-unit equal quantities should have the same hash code");
    }

    // ============== UC3: Static Method Tests ==============

    /**
     * Test: Static method for same-unit comparison
     */
    @Test
    @DisplayName("testStaticMethod_QuantityEquality_SameUnit - Static method for same-unit comparison")
    public void testStaticMethod_QuantityEquality_SameUnit() {
        boolean result = QuantityMeasurementApp.checkQuantityEquality(1.0, QuantityMeasurementApp.LengthUnit.FEET, 
                                                                       1.0, QuantityMeasurementApp.LengthUnit.FEET);
        assertTrue(result, "Static method should return true for equal feet quantities");
    }

    /**
     * Test: Static method for cross-unit comparison
     */
    @Test
    @DisplayName("testStaticMethod_QuantityEquality_CrossUnit - Static method for cross-unit comparison")
    public void testStaticMethod_QuantityEquality_CrossUnit() {
        boolean result = QuantityMeasurementApp.checkQuantityEquality(1.0, QuantityMeasurementApp.LengthUnit.FEET, 
                                                                       12.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertTrue(result, "Static method should return true for 1 foot and 12 inches");
    }

    /**
     * Test: Static method for different values
     */
    @Test
    @DisplayName("testStaticMethod_QuantityEquality_DifferentValue - Static method should return false for different values")
    public void testStaticMethod_QuantityEquality_DifferentValue() {
        boolean result = QuantityMeasurementApp.checkQuantityEquality(2.0, QuantityMeasurementApp.LengthUnit.FEET, 
                                                                       12.0, QuantityMeasurementApp.LengthUnit.INCH);
        assertFalse(result, "Static method should return false for 2 feet and 12 inches");
    }

    // ============== Backward Compatibility Tests (UC1 & UC2) ==============

    /**
     * Test: Legacy Feet class still works (backward compatibility)
     */
    @Test
    @DisplayName("testBackwardCompatibility_Feet - Legacy Feet class should still work")
    public void testBackwardCompatibility_Feet() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "Legacy Feet class should work for backward compatibility");
    }

    /**
     * Test: Legacy Inches class still works (backward compatibility)
     */
    @Test
    @DisplayName("testBackwardCompatibility_Inches - Legacy Inches class should still work")
    public void testBackwardCompatibility_Inches() {
        QuantityMeasurementApp.Inches inch1 = new QuantityMeasurementApp.Inches(1.0);
        QuantityMeasurementApp.Inches inch2 = new QuantityMeasurementApp.Inches(1.0);

        assertTrue(inch1.equals(inch2), "Legacy Inches class should work for backward compatibility");
    }

    /**
     * Test: Legacy static methods still work (backward compatibility)
     */
    @Test
    @DisplayName("testBackwardCompatibility_StaticMethods - Legacy static methods should still work")
    public void testBackwardCompatibility_StaticMethods() {
        boolean feetResult = QuantityMeasurementApp.checkFeetEquality(1.0, 1.0);
        boolean inchResult = QuantityMeasurementApp.checkInchesEquality(1.0, 1.0);

        assertTrue(feetResult, "Legacy checkFeetEquality should work");
        assertTrue(inchResult, "Legacy checkInchesEquality should work");
    }

    // ============== Additional Quantity Tests ==============

    /**
     * Test: Quantity getValue() method
     */
    @Test
    @DisplayName("testQuantity_GetValue - getValue should return the correct value")
    public void testQuantity_GetValue() {
        QuantityMeasurementApp.Quantity quantity = new QuantityMeasurementApp.Quantity(5.5, QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(5.5, quantity.getValue(), "getValue() should return the correct value");
    }

    /**
     * Test: Quantity getUnit() method
     */
    @Test
    @DisplayName("testQuantity_GetUnit - getUnit should return the correct unit")
    public void testQuantity_GetUnit() {
        QuantityMeasurementApp.Quantity quantity = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(QuantityMeasurementApp.LengthUnit.FEET, quantity.getUnit(), "getUnit() should return FEET");
    }

    /**
     * Test: Quantity getValueInFeet() method
     */
    @Test
    @DisplayName("testQuantity_GetValueInFeet - getValueInFeet should convert correctly")
    public void testQuantity_GetValueInFeet() {
        QuantityMeasurementApp.Quantity twelve_inches = new QuantityMeasurementApp.Quantity(12.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(1.0, twelve_inches.getValueInFeet(), 0.0001, "12 inches should convert to 1 foot");
    }

    /**
     * Test: Multiple cross-unit conversions (transitive)
     */
    @Test
    @DisplayName("testQuantity_MultipleConversions - Test multiple unit conversions transitively")
    public void testQuantity_MultipleConversions() {
        QuantityMeasurementApp.Quantity one_yard = new QuantityMeasurementApp.Quantity(1.0, QuantityMeasurementApp.LengthUnit.YARD);
        QuantityMeasurementApp.Quantity three_feet = new QuantityMeasurementApp.Quantity(3.0, QuantityMeasurementApp.LengthUnit.FEET);
        QuantityMeasurementApp.Quantity thirtysix_inches = new QuantityMeasurementApp.Quantity(36.0, QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(one_yard.equals(three_feet), "1 yard should equal 3 feet");
        assertTrue(three_feet.equals(thirtysix_inches), "3 feet should equal 36 inches");
        assertTrue(one_yard.equals(thirtysix_inches), "1 yard should equal 36 inches (transitive)");
    }
}
