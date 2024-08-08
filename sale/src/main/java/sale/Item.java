package sale;

public class Item {

	private final String name;
	private int quantity;
	private final double price;
	private Category category;
	private final boolean isClearance;

	public Item(String name, int quantity, double price, Category category, boolean isClearance) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.isClearance = isClearance;

		String itemNameLower = name.toLowerCase();
		if (itemNameLower.matches("book|books")) {
			category = Category.BOOK;
		} else if (itemNameLower.matches("shirt|shirts|dress")) {
			category = Category.CLOTHING;
		} else if (itemNameLower.matches("chocolate|chocolates|wine")) {
			category = Category.FOOD;
		} else {
			category = Category.OTHER;
		}
	}

	public double getTotalPrice() {
		double basePrice = quantity * price;
		double discount = calculateDiscount(basePrice);
		return basePrice - discount;
	}

	private double calculateDiscount(double basePrice) {
		double discount = 0.0; // Default discount
		if (category == Category.BOOK || category == Category.FOOD || category == Category.DRINK) {
			discount += basePrice * 0.05;
		} else if (category == Category.CLOTHING) {
			discount += basePrice * 0.2;
		} else {
			discount += basePrice * 0.03;
		}

		if (isClearance) {
			discount = basePrice * discount * 1.2; // Additional 20% discount for clearance items
		}
		return discount;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public Category getCategory() {
		return category;
	}

	public boolean isClearance() {
		return isClearance;
	}
}
