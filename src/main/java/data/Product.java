package data;

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private int sellerID;
    private int cost;

    public Product(int id, String name, String description, int quantity, int sellerID, int cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.sellerID = sellerID;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean decreaseQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
            return true;
        }
        return false;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
