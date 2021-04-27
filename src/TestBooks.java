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
                    System.out.printf("Enter the books name ");
                    String book = in.nextLine();
                    search(book);
                    break;
                }
                case "-book": {
                    System.out.printf("Enter the books name ");
                    String book = in.nextLine();
                    getBook(book);
                    break;
                }
                case "-all":
                    System.out.println("We have: ");
                    allBooks();
                    break;
                case "-get":
                    System.out.println("Please enter your ID and password : ");
                    System.out.print("ID: ");
                    int id = in.nextInt();
                    System.out.print("Password: ");
                    int password = in.nextInt();
                    if (checkUser(id, password)) {
                        Scanner inp = new Scanner(System.in);
                        System.out.print("What book do you want? ");
                        String book = inp.nextLine();
                        if (have(book)) {
                            System.out.println("Here is your book. ");
                            get(book);
                            System.out.println();
                        }
                    } else {
                        System.out.println("You are not member of the library. please sign up: ");
                        System.out.println("Firstname: ");
                        String name = in.next();
                        System.out.println("Lastname: ");
                        String lname = in.next();
                        System.out.println("NationalCode: (must be 10 digit) ");
                        int nc = in.nextInt();
                        Person p1 = new Person(name, lname, nc, (nc / 1000) + 1000);
                        PersonDB.personDB.add(p1);
                        System.out.println("Thanks your ID is the last four digit of your national code and your password is your nc. ");
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

    public static boolean checkUser(int ID, int password) {
        boolean flag = false;
        for (int i = 0; i < BooksDB.booksDb.size()-1; i++) {
            flag = PersonDB.personDB.get(i).getUsername() == ID && PersonDB.personDB.get(i).getNc() == password;
            break;
        }
        return flag;
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

    public static void search(String book) {
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
    }

    public static void getBook(String book) {
        search(book);
        boolean have = false;
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if (BooksDB.booksDb.get(i).getName().equals(book)) {
                System.out.println("We have it");
                System.out.println(BooksDB.booksDb.get(i).toString());
                have = true;
            }
        }
        if (!have) {
            System.out.println("Sorry we're out.");
        }
        System.out.println();
    }

    public static void allBooks() {
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            System.out.println(BooksDB.booksDb.get(i).getName());

        }
        System.out.println("Total Books: " + BooksDB.getAllBooks());
    }

    public static void get(String book) {
        for (int i = 0; i < BooksDB.booksDb.size(); i++) {
            if (BooksDB.booksDb.get(i).getName().equals(book)) {
                BooksDB.booksDb.get(i).setQuantity(BooksDB.booksDb.get(i).getQuantity() - 1);
            }
        }
    }
}
