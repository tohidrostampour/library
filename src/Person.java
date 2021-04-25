public class Person {
    private String fname;
    private String lname;
    private long nc;
    private String username;

    public Person(String fname, String lname, long nc, String username) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        if(nc<10 || nc >10){
            throw new IllegalArgumentException("your national code must be 10 digits");
        }
        this.nc = nc;
    }

}
