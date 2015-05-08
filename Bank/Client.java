public class Client {
 
    private String name;
    private Account account;
    private String numAccount;
 
    public Client(String name, String numAccount) {
        this.name = name;
        this.numAccount = numAccount;
        account = new Account(0);
    }
 
    public String getName() {
        return name;
    }
 
    public String getNumAccount() {
        return numAccount;
    }
 
    public void setAccount(Account newAccount) {
        account = newAccount;
    }
 
    public Account getAccount() {
        return account;
    }
 
    public String toString() {
        return "\n\t\tNombre: " + name + "\n\t\tNumero De Cuenta: " + numAccount  + account +  "\n";
    }
}
