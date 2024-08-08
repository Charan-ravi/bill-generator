package sale;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Testsale {
	@Test
    public void testBookDiscount() {
        Item book = new Item("book",1, 14.49,Category.BOOK, false);
        assertEquals(13.77, book.getTotalPrice(),0.01);
    }
	 @Test
	    public void testShirtDiscount() {
	        Item shirt = new Item("shirt", 1, 19.99, Category.CLOTHING, false);
	        assertEquals(15.99, shirt.getTotalPrice(), 0.01);
	    }

	    @Test
	    public void testClearanceChocolateBarDiscount() {
	        Item clearanceChocolateBar = new Item("chocolate", 2, 2.00, Category.FOOD, true);
	        assertEquals(3.04, clearanceChocolateBar.getTotalPrice(), 0.01);
	    }

	    @Test
	    public void testPerfumeDiscount() {
	        Item perfume = new Item("perfume", 1, 27.99, Category.OTHER, false);
	        assertEquals(27.15, perfume.getTotalPrice(), 0.01);
	    }
}
