import java.util.Vector;
 
public class Client {
 
    private String name;
    private Vector<Account> accounts;
    private int numAccounts;
 
    public Client(String name) {
        this.name = name;
        accounts = new Vector<Account>();
        numAccounts = 0;
    }
 
    public void getInfo() {
        System.out.println("\n");
        for(Account a : accounts) {
            if(a instanceof SavingsAccount) System.out.println("\t\tCuenta de Ahorros");
            else System.out.println("\n\t\tCuenta de Cheques");
            a.viewDepositsAndWithdraws();
        }
    }
 
    public Account getAccount(int index) {
        return accounts.elementAt(index - 1);
    }
 
    public void addAccount(Account account) {
        accounts.addElement(account);
        numAccounts = accounts.size();
    }
 
    public int getNumAccounts() {
        return numAccounts;
    }
 
    public String toString() {
        return "\n\tCliente: " + name;
    }
}
