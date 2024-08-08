package sale;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Billgenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of items: ");
		int numberOfItems = Integer.parseInt(scanner.nextLine());

		Receipt receipt = new Receipt();

		Map<String, Category> categoryMap = new HashMap<>();
		categoryMap.put("book", Category.BOOK);
		categoryMap.put("shirt", Category.CLOTHING);
		categoryMap.put("dress", Category.CLOTHING);
		categoryMap.put("chocolate", Category.FOOD);
		categoryMap.put("wine", Category.DRINK);
		categoryMap.put("perfume", Category.OTHER);

		for (int i = 0; i < numberOfItems; i++) {
			int quantity = 0;
			String itemName = "";
			double price = 0.0;
			boolean isClearance = false;

			while (quantity <= 0) {
				System.out.print("Enter item details (e.g., '2 books at 14.49'): ");
				String itemDescription = scanner.nextLine();

				try {
					String[] parts = itemDescription.split(" at ");
					String[] quantityAndName = parts[0].split("\\s+"); // Split by whitespace
					quantity = Integer.parseInt(quantityAndName[0]);
					itemName = String.join(" ", Arrays.copyOfRange(quantityAndName, 1, quantityAndName.length));

					price = Double.parseDouble(parts[1]);
					isClearance = itemName.toLowerCase().contains("clearance");

				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid quantity. Please enter a number.");
					quantity = 0; // Skip to next iteration if quantity parsing fails
				}

			}
			Category category = categoryMap.getOrDefault(itemName.toLowerCase(), Category.OTHER);
                if (itemName.toLowerCase().contains("book")) {
                    category = Category.BOOK;
                } else if (itemName.toLowerCase().contains("shirt") || itemName.toLowerCase().contains("dress")) {
                    category = Category.CLOTHING;
                } else if(itemName.toLowerCase().contains("chocolate") ){
                    category = Category.FOOD;
                } else if( itemName.toLowerCase().contains("wine")){
                    category = Category.DRINK;
                }

			Item item = new Item(itemName, quantity, price, category, isClearance);
			receipt.addItem(item);
		}
		System.out.println("OUTPUT :");
		receipt.printReceipt();
		scanner.close();
	}
}
