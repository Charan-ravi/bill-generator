package sale;

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
		double discountTotal = 0.0;

		for (Item item : items) {
			double itemTotal = item.getTotalPrice();
			total += itemTotal;
			discountTotal += item.getPrice() * item.getQuantity() - itemTotal;
			System.out.printf("%d %s at %.2f%n", item.getQuantity(), item.getName(), itemTotal);
		}
		System.out.println("Total: $" + String.format("%.2f", total));
		System.out.println("You saved: $" + String.format("%.2f", discountTotal));
	}
}
