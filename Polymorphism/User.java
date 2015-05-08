public class User {
 
    protected String userName;
 
    public User(String userName) {
        this.userName = userName;
    }
 
    protected void changeName(String newaName) {
        userName = newaName;
    }
 
    public String toString() {
        return userName;
    }
}
