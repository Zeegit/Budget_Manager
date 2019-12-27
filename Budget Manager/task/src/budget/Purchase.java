package budget;

public class Purchase {
    private Category сategory;
    private String name;
    private double price;

    public Purchase(Category сategory, String name, double price) {
        this.сategory = сategory;
        this.name = name;
        this.price = price;
    }

    public Category getСategory() {
        return сategory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setСategory(Category сategory) {
        this.сategory = сategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
