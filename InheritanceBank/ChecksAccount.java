public class ChecksAccount extends Account {
 
    private double overdraftAmount;
 
    public ChecksAccount(double openingBalance, double overdraftAmount) {
        super(openingBalance);
        this.overdraftAmount = overdraftAmount;
    }
 
    public ChecksAccount(double openingBalance) {
        super(openingBalance);
        overdraftAmount = 0;
    }
 
    public void withdraw(double amount) {
        double difference = 0; 
        if(amount <= balance) {
            balance -=amount;
            deposits_withdraws.addElement(new Pair(2,amount));
            System.out.println("\n\t\tRetiro Exitoso");
        }
        else {
            if(amount <= (balance + overdraftAmount)) {
                difference = amount - balance;
                overdraftAmount -= difference;
                balance -= amount;
                deposits_withdraws.addElement(new Pair(2,amount));
                System.out.println("\n\t\tRetiro Exitoso");
            } else System.out.println("\n\t\tSobregiro Sobrepasado");
        }
    }
 
    public String toString() {
        return "\n\t\t\tSaldo: " + Double.toString(balance) + "\tSobregiro: " +  Double.toString(overdraftAmount);
    }
 
}
