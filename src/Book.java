import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private int quantity;
    private Category category;
    enum  Category {
        MOTIVATIONAL,
        ROMANCE,
        SCIFI,
        THRILLER,
        WESTERNS,
        FANTASY
    }

    public Book(String name, String author, int quantity, Category category) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "author: " + author + "\n" +
                "quantity: " + quantity + "\n"+
                "category: " + category  + "\n";
    }
}
