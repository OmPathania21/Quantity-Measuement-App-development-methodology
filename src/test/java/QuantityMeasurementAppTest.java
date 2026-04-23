import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the QuantityMeasurementApp class.
 * Tests the equality comparison of Feet and Inches measurements following the equality contract.
 */
@DisplayName("Quantity Measurement App - Feet and Inches Equality Tests")
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
}
