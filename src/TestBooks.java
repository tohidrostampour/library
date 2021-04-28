import java.util.Scanner;

public class TestBooks {
    //static BooksDB books = new BooksDB();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String operation;
        do {
            System.out.println("What do you want to do? \n" +
                    "-search  to see if a book exits or not \n" +
                    "-book  to get information about a book \n" +
                    "-all  to get a list of all books in the library \n" +
                    "-get  to borrow a book \n" +
                    "-q  to quit");
            operation = in.nextLine().toLowerCase();

            switch (operation) {
                case "-search": {
                    System.out.print("Enter the books name ");
                    String book = in.nextLine();
                    if (have(book)) {
                        System.out.println("We have it. You can borrow it by -get");
                    } else System.out.println("Sorry we're out.");
                    System.out.println();
                    break;
                }
                case "-book": {
                    System.out.print("Enter the books name ");
                    String book = in.nextLine();
                    if (have(book)) {
                        getBook(book);
                    }
                    break;
                }
                case "-all":
                    System.out.println("We have: ");
                    allBooks();
                    break;

                case "-get":
                    System.out.println("Please enter your username and password : ");
                    System.out.print("Username: ");
                    long username = in.nextLong();
                    System.out.print("Password: ");
                    long password = in.nextLong();
                    if (checkUser(username, password)) {
                        System.out.println("!!haveuser");
                        Scanner inp = new Scanner(System.in);
                        System.out.print("What book do you want? ");
                        String book = inp.nextLine();
                        if (have(book)) {
                            System.out.println("Here is your book. ");
                            get(book);
                            System.out.println();
                            break;
                        }
                    } else {
                        System.out.println("!!Dont have user");
                        System.out.println("You are not member of the library. please sign up: ");
                        System.out.println("Firstname: ");
                        String name = in.next();
                        System.out.println("Lastname: ");
                        String lname = in.next();
                        System.out.println("NationalCode: (must be 10 digit) ");
                        long nc = in.nextLong();
                        Person p1 = new Person(name, lname, nc, (nc / 1000000) + 1000);
                        PersonDB.personDB.add(p1);
                        System.out.println("Thanks your ID is "+((nc/1000000)+1000)+" and your password is your nc. ");
                        System.out.println();
                        System.out.print("What book do you want? ");
                        Scanner inp = new Scanner(System.in);
                        String book = inp.nextLine();
                        if (have(book)) {
                            System.out.println("Here is your book. ");
                            get(book);
                        }
                    }
                    break;
            }
        } while (!operation.equals("-q"));
    }

    public static boolean checkUser(long Username, long password) {
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if(PersonDB.personDB.get(i).getUsername() == Username && PersonDB.personDB.get(i).getNc() == password)
                return true;
        }
        return false;
    }

    public static boolean have(String book) {
        boolean flag = false;
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if (BooksDB.booksDb.get(i).getName().equals(book)) {
                flag = true;
            }
        }
        return flag;
    }

    /*public static void search(String book) {
        boolean have = false;
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if (BooksDB.booksDb.get(i).getName().equals(book)) {
                System.out.println("We have it");
                have = true;
            }
        }
        if (!have) {
            System.out.println("Sorry we're out.");
            System.out.println();
        }
    }*/


    public static void getBook(String book) {
        if (have(book)) {
            System.out.println("We have it");
            System.out.println(bookInfo(book));
        } else System.out.println("Sorry we're out.");
        System.out.println();
    }

    public static String bookInfo(String book) {
        String info = "";
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if (BooksDB.booksDb.get(i).getName().equals(book)) {
                info += BooksDB.booksDb.get(i).toString();
                break;
            }
        }
        return info;
    }

    public static void allBooks() {
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            System.out.println(BooksDB.booksDb.get(i).getName());
        }
        System.out.println();
        System.out.println("Total Books: " + BooksDB.getAllBooks());
        System.out.println();
    }

    public static void get(String book) {
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if (BooksDB.booksDb.get(i).getName().equals(book)&&BooksDB.booksDb.get(i).getQuantity()>0) {
                BooksDB.booksDb.get(i).setQuantity(BooksDB.booksDb.get(i).getQuantity() - 1);
            }else if(BooksDB.booksDb.get(i).getQuantity()<0){
                System.out.println("Sorry we just finished that book.");
            }
        }
    }
}
