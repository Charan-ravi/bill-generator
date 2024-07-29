package bill_generator;

/**
 * This class is the start of the application.
 * It handles user input, creates items, and generates the receipt.
 * @author charan
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of items: ");
            int numberOfItems = Integer.parseInt(scanner.nextLine());
            
            Receipt receipt = new Receipt();
            
            for (int i = 0; i < numberOfItems; i++) {
                System.out.print("Enter item details (e.g., '1 book at 14.49'): ");
                String input = scanner.nextLine();
                String[] parts = input.split(" at ");
                String itemName = parts[0].substring(2); // Remove quantity
                double itemPrice = Double.parseDouble(parts[1]);
                boolean isClearance = itemName.toLowerCase().contains("clearance");
                
                Item item = new Item(itemName, itemPrice, isClearance);
                receipt.addItem(item);
            }
            
            receipt.printReceipt();
            scanner.close();
        }
    }
}
