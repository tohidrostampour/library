public class Person {
    private String fname;
    private String lname;
    private long nc;
    private int username;


    public Person(String fname, String lname, long nc, int username) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;

        this.nc = nc;
    }

    public long getNc() {
        return nc;
    }

    public int getUsername() {
        return username;
    }


}
