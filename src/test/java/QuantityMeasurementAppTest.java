import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the QuantityMeasurementApp class.
 * Tests the equality comparison of Feet measurements following the equality contract.
 */
@DisplayName("Quantity Measurement App - Feet Equality Tests")
public class QuantityMeasurementAppTest {

    /**
     * Test: Feet equality with same numerical value (1.0 ft and 1.0 ft)
     * Verifies that two Feet objects with the same value are considered equal.
     * Tests: equals() returns true when comparing equivalent values.
     */
    @Test
    @DisplayName("testEquality_SameValue - Two Feet objects with value 1.0 should be equal")
    public void testEquality_SameValue() {
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
    public void testEquality_DifferentValue() {
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
    public void testEquality_NullComparison() {
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
    public void testEquality_SameReference() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet.equals(feet), "Feet object should equal itself (reflexive property)");
    }

    /**
     * Test: Symmetric property of equality
     * Verifies that if a.equals(b) then b.equals(a).
     * Tests the symmetric property of the equals contract.
     */
    @Test
    @DisplayName("testEquality_SymmetricProperty - Symmetric property: if a.equals(b) then b.equals(a)")
    public void testEquality_SymmetricProperty() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "feet1 should equal feet2");
        assertTrue(feet2.equals(feet1), "feet2 should equal feet1 (symmetric property)");
    }

    /**
     * Test: Transitive property of equality
     * Verifies that if a.equals(b) and b.equals(c) then a.equals(c).
     * Tests the transitive property of the equals contract.
     */
    @Test
    @DisplayName("testEquality_TransitiveProperty - Transitive property: if a.equals(b) and b.equals(c) then a.equals(c)")
    public void testEquality_TransitiveProperty() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet feet3 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(feet1.equals(feet2), "feet1 should equal feet2");
        assertTrue(feet2.equals(feet3), "feet2 should equal feet3");
        assertTrue(feet1.equals(feet3), "feet1 should equal feet3 (transitive property)");
    }

    /**
     * Test: Consistent property of equality
     * Verifies that multiple calls to equals() return the same result.
     * Tests the consistent property of the equals contract.
     */
    @Test
    @DisplayName("testEquality_ConsistentProperty - Multiple calls to equals should return the same result")
    public void testEquality_ConsistentProperty() {
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
    public void testEquality_NonNumericInput() {
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
    public void testEquality_FloatingPointComparison() {
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
    public void testEquality_ZeroValue() {
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
    public void testEquality_NegativeValue() {
        QuantityMeasurementApp.Feet feet1 = new QuantityMeasurementApp.Feet(-1.0);
        QuantityMeasurementApp.Feet feet2 = new QuantityMeasurementApp.Feet(-1.0);

        assertTrue(feet1.equals(feet2), "Feet objects with negative values (-1.0) should be equal");
    }

    /**
     * Test: HashCode consistency
     * Verifies that equal objects have the same hash code.
     * Tests the hash code contract: if a.equals(b) then a.hashCode() == b.hashCode().
     */
    @Test
    @DisplayName("testHashCode_Consistency - Equal Feet objects should have the same hash code")
    public void testHashCode_Consistency() {
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
    public void testGetValue() {
        double expectedValue = 5.5;
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(expectedValue);

        assertEquals(expectedValue, feet.getValue(), 
            "getValue() should return the correct measurement value");
    }
}
