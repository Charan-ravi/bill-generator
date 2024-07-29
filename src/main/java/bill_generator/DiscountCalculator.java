package bill_generator;

/**
 * This class is responsible for calculating the discounted price of an item,
 * based on its type and clearance status.
 * @author charan
 */
public class DiscountCalculator {

    public static double calculateDiscountedPrice(Item item) {
        double discount = 0.0;

        String itemName = item.getName().toLowerCase();
        if (itemName.contains("book")
                || itemName.contains("food")
                || itemName.contains("drink")
                || itemName.contains("wine")
                || itemName.contains("chocolate")) {
            discount = 0.05; // 5% discount for books, food, drinks, and chocolates
        } else if (itemName.contains("shirt")
                || itemName.contains("clothes")
                || itemName.contains("dress")) {
            discount = 0.20; // 20% discount for clothing
        } else {
            discount = 0.03; // 3% discount for all other items
        }
        double discountedPrice = item.getPrice() * (1 - discount);

        // Additional 20% discount for clearance items
        if (item.isClearance()) {
            discountedPrice *= 0.80; // 20% off on discounted price
        }

        return roundToNearestCent(discountedPrice);
    }

    private static double roundToNearestCent(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
