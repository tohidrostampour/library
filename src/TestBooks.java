import java.util.Scanner;

public class TestBooks {
    //static BooksDB books = new BooksDB();
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        String operation;
        do{
            System.out.println("What do you want to do? \n"+
                    "-search  to see if a book exits or not \n"+
                    "-book  to get information about a book \n"+
                    "-all  to get a list of all books in the library \n"+
                    "-get  to borrow a book \n"+
                    "-q  to quit");
            operation = in.nextLine().toLowerCase();
            if (operation.equals("-search")) {
                System.out.printf("Enter the books name ");
                String book = in.nextLine();
                search(book);
            }else if(operation.equals("-book")){
                System.out.printf("Enter the books name ");
                String book = in.nextLine();
                getBook(book);
            }else if(operation.equals("-all")){
                System.out.println("We have: ");
                allBooks();
            }else if(operation.equals("-get")){
                System.out.println("What book do you want? ");
                String book = in.nextLine();
                if(have(book)){
                    get(book);
                }
            }
        }while(!operation.equals("-q"));
    }

    public static boolean have(String book){
        boolean flag = false;
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if(BooksDB.booksDb.get(i).getName().equals(book)){
                flag = true;
            }
        }
        return flag;
    }

    public static void search(String book){
        boolean have = false;
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if(BooksDB.booksDb.get(i).getName().equals(book)){
                System.out.println("We have it");
                have = true;
            }
        }
        if(!have){
            System.out.println("Sorry we're out.");
        }
    }
    public static void getBook(String book){
        search(book);
        boolean have = false;
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if(BooksDB.booksDb.get(i).getName().equals(book)){
                System.out.println("We have it");
                System.out.println(BooksDB.booksDb.get(i).toString());
                have = true;
            }
        }
        if(!have){
            System.out.println("Sorry we're out.");
        }
    }
    public static void allBooks(){
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            System.out.println(BooksDB.booksDb.get(i).getName());

        }
        System.out.println("Total Books: "+BooksDB.getAllBooks());
    }

    public static void get(String book){
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if(BooksDB.booksDb.get(i).getName().equals(book)){
                BooksDB.booksDb.get(i).setQuantity(BooksDB.booksDb.get(i).getQuantity() - 1);
            }
        }
    }
}
