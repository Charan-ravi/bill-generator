package bill_generator;

/**
 * This class contains unit tests for the DiscountCalculator class.
 * It verifies that the discount calculations are correct for various types of items based on sample inputs given.
 * @author charan
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    @Test
    public void testBookDiscount() {
        Item book = new Item("book", 14.49, false);
        assertEquals(13.77, DiscountCalculator.calculateDiscountedPrice(book));
    }

    @Test
    public void testShirtDiscount() {
        Item shirt = new Item("shirt", 19.99, false);
        assertEquals(15.99, DiscountCalculator.calculateDiscountedPrice(shirt));
    }

    @Test
    public void testClearanceChocolateBarDiscount() {
        Item clearanceChocolateBar = new Item("clearance chocolate bar", 2.00, true);
        assertEquals(1.52, DiscountCalculator.calculateDiscountedPrice(clearanceChocolateBar));
    }

    @Test
    public void testPerfumeDiscount() {
        Item perfume = new Item("bottle of perfume", 27.99, false);
        assertEquals(27.15, DiscountCalculator.calculateDiscountedPrice(perfume));
    }
}
