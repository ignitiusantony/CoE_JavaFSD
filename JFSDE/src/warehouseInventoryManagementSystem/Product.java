package warehouseInventoryManagementSystem;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String productID;
    private String name;
    private int quantity;
    private Location location;
    private transient final Object lock = new Object(); // Marked as transient

    public Product(String productID, String name, int quantity, Location location) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    public void updateQuantity(int delta) throws OutOfStockException {
        synchronized (lock) { // This will now work fine
            int newQuantity = this.quantity + delta;
            if (newQuantity < 0) {
                throw new OutOfStockException("Insufficient stock for product: " + productID);
            }
            this.quantity = newQuantity;
        }
    }

    // Getters and setters
    public String getProductID() { return productID; }
    public void setProductID(String productID) { this.productID = productID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}
