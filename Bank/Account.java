import java.util.Vector; 
public class Account {
 
    private double balance;
    private Vector<Double> deposits = new Vector<Double>();
    private Vector<Double> retreats = new Vector<Double>();
 
    public Account(Account newAccount) {
        balance = newAccount.balance;
    }
 
    public Account(double openingBalance) {
        balance = openingBalance;
    }
 
    public double consult() {
        return balance;
    }
 
    public void deposit(double amount) {
        balance += amount;
        deposits.addElement(amount);
        System.out.println("\n\t\tDeposito Satisfactorio De $ " + amount);
    }
 
    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            retreats.addElement(amount);
            System.out.println("\n\t\tRetiro Satisfactorio De $ " + amount);
        } else {
            System.out.println("\n\t\tSaldo Insuficiente");
        }
    }
 
    public String toString() {
        return "\n\t\tNumero De Depositos: " + 
        Integer.toString(deposits.size()) + 
        "\n\t\t\t " + deposits.toString() + 
        "\n\t\tNumero De Retiros:" + 
        Integer.toString(retreats.size())  + 
        "\n\t\t\t " + retreats.toString() + 
        "\n\t\tSaldo: $ " + 
        String.valueOf(balance);
    }
}
