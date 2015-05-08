public class Guest extends User {
 
    private boolean isEnabledPass;
    private String password;
 
    public Guest(String name) {
        super(name);
        isEnabledPass = false;
    }
 
    public Guest(String name, String password) {
        super(name);
        this.password = password;
        isEnabledPass = true;
    }
     
}
