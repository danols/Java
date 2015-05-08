import java.util.Vector;
 
public class Account {
 
    protected double balance;
    protected Vector<Pair> deposits_withdraws = new Vector<Pair>();
 
    public Account(double balance) { this.balance = balance; }
 
    public double consult() { return balance; }
 
    public void deposit(double amount) { 
        deposits_withdraws.addElement(new Pair(1,amount));
        balance += amount; 
    }
 
    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            deposits_withdraws.addElement(new Pair(2,amount));
            System.out.println("\n\t\tRetiro Satisfactorio");
        }
        else System.out.println("\n\t\tSaldo Insuficiente");
    }
 
    public void viewDepositsAndWithdraws() {
        for(Pair p : deposits_withdraws) {
            System.out.print(p);
        }
        //System.out.print("\n\t\t\tSaldo: " + this.consult());
        System.out.print(this);
        System.out.println();
    }
 
}
