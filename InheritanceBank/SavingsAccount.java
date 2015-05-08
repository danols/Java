public class SavingsAccount extends Account {
 
    private double interestRate;
 
    public SavingsAccount(double openingBalance, double interestRate) {
        super(openingBalance);
        this.interestRate = interestRate;
    }
 
    public double consult() {
        balance += (interestRate * balance);
        return balance;
    }
 
    public String toString() {
        return "\n\t\t\tSaldo: " + Double.toString(balance);
    }
}
