package bill_generator;

/**
 *
 * @author charan
 */
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final List<Item> items;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void printReceipt() {
        double total = 0.0;
        double totalSaved = 0.0;

        for (Item item : items) {
            double originalPrice = item.getPrice();
            double discountedPrice = DiscountCalculator.calculateDiscountedPrice(item);
            total += discountedPrice;

            // Calculate the amount saved
            double saved = originalPrice - discountedPrice;
            totalSaved += saved;

            System.out.printf("%s at %.2f%n", item.getName(), discountedPrice);
        }

        System.out.printf("Total: %.2f%n", roundToNearestCent(total));
        System.out.printf("You saved: %.2f%n", roundToNearestCent(totalSaved));
    }

    private double roundToNearestCent(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
