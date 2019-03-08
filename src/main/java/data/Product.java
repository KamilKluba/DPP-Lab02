package data;

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private Account seller;
    private int cost;

    public Product(int id, String name, String description, int quantity, Account seller, int cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.seller = seller;
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

    public Account getSeller() {
        return seller;
    }

    public void setSeller(Account seller) {
        this.seller = seller;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
