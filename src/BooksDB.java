import java.util.ArrayList;
import java.util.Arrays;

public class BooksDB {
    ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Eat that frog","Bryan Tracey",12,Book.Category.MOTIVATIONAL),
            new Book("The Secret","Rhonda Brynn",17,Book.Category.MOTIVATIONAL),
            new Book("Game Of Thrones","George R.R Martin",20,Book.Category.SCIFI),
            new Book("Uglies","Scott Westerfield",54,Book.Category.FANTASY),
            new Book("New Moon","Stephanie Meyer",43,Book.Category.ROMANCE)
    ));
}
