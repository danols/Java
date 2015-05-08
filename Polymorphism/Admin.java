public class Admin extends User {
 
    private String password;
 
    public Admin(String name, String password) {
        super(name);
        this.password = password;
    }
     
}
