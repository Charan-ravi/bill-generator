package bill_generator;

/**
 * This class represents an item in the shopping basket.
 * It stores the name, price, and clearance status of an item.
 * @author charan
 */
public class Item {

    private final String name;
    private final double price;
    private final boolean isClearance;

    public Item(String name, double price, boolean isClearance) {
        this.name = name;
        this.price = price;
        this.isClearance = isClearance;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isClearance() {
        return isClearance;
    }
}
