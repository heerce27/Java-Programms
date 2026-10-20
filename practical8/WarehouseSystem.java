import java.util.*;
class OutOfStockException extends Exception {
    private int shortfall;
    public OutOfStockException(int shortfall) {
        super("Insufficient stock. Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }

    public int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();
    public Warehouse() {
        stock.put("Laptop", 5);
        stock.put("Mouse", 10);
        stock.put("Keyboard", 3);
    }

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero."
            );
        }
        int available = stock.getOrDefault(item, 0);
        if (qty > available) {
            throw new OutOfStockException(qty - available);
        }
        stock.put(item, available - qty);
        System.out.println( "Issued " + qty + " units of " + item + " successfully." );
    }

    public void displayStock() {
        System.out.println("\nRemaining Stock: " + stock);
    }
}

public class WarehouseSystem {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        String[][] requests = {
            {"Laptop", "3"},
            {"Mouse", "15"},
            {"Keyboard", "0"},
            {"Mouse", "4"},
            {"Laptop", "-2"},
            {"Keyboard", "2"}
        };
        for (String[] request : requests) {
            String item = request[0];
            int qty = Integer.parseInt(request[1]);
            System.out.println("\nProcessing: " + item + ", Quantity: " + qty);
            try {
                warehouse.issue(item, qty);
            } catch (OutOfStockException e) {
                System.out.println("Failed: " + e.getMessage());
                System.out.println( "Additional units required: " + e.getShortfall() );
            } catch (InvalidQuantityException e) {
                System.out.println("Failed: " + e.getMessage());
            }
        }
        warehouse.displayStock();
        System.out.println("\nAll requests processed.");
    }
}