public class mainSystem {
 
    public static void main(String[] args) {
 
        Bank bank1 = new Bank("Banamex");
        Bank bank2 = new Bank("Bancomer");
 
        Client client1 = new Client("Fernando Sánchez");
        Client client2 = new Client("Karla López");
        Client client3 = new Client("Gabriel Estrada");
        Client client4 = new Client("Carlos Fuentes");
        Client client5 = new Client("Luis Ocampo");
        Client client6 = new Client("Edith Contreras");
 
        SavingsAccount sAccount1 = new SavingsAccount(20000,0.12);
        ChecksAccount cAccount1 = new ChecksAccount(10000,5000);
        client1.addAccount(sAccount1);
        client1.addAccount(cAccount1);
 
        SavingsAccount sAccount2 = new SavingsAccount(8000,0.15);
        ChecksAccount cAccount2 = new ChecksAccount(4000,3500);
        client2.addAccount(sAccount2);
        client2.addAccount(cAccount2);
 
        SavingsAccount sAccount3 = new SavingsAccount(2000,0.10);
        ChecksAccount cAccount3 = new ChecksAccount(5000,1000);
        client3.addAccount(sAccount3);
        client3.addAccount(cAccount3);
 
        SavingsAccount sAccount4 = new SavingsAccount(6500,0.18);
        ChecksAccount cAccount4 = new ChecksAccount(12000,5000);
        client4.addAccount(sAccount4);
        client4.addAccount(cAccount4);
 
        SavingsAccount sAccount5 = new SavingsAccount(7800,0.12);
        ChecksAccount cAccount5 = new ChecksAccount(6400,3000);
        client5.addAccount(sAccount5);
        client5.addAccount(cAccount5);
 
        SavingsAccount sAccount6 = new SavingsAccount(20000,0.2);
        ChecksAccount cAccount6 = new ChecksAccount(1000,3500);
        client6.addAccount(sAccount6);
        client6.addAccount(cAccount6);
 
        bank1.addClient(client1);
        bank1.addClient(client2);
        bank1.addClient(client3);
        bank2.addClient(client4);
        bank2.addClient(client5);
        bank2.addClient(client6);
 
        sAccount1.deposit(1000);
        sAccount1.withdraw(700);
        sAccount1.deposit(1500);
 
        cAccount1.deposit(500);
        cAccount1.withdraw(200);
         
        sAccount2.deposit(300);
        sAccount2.withdraw(1500);
        sAccount2.withdraw(800);
 
        cAccount2.deposit(3000);
        cAccount2.withdraw(2000);
 
        sAccount3.deposit(300);
        sAccount3.withdraw(1500);
 
        cAccount3.deposit(3000);
        cAccount3.withdraw(2000);
        cAccount3.withdraw(7000);
        cAccount3.withdraw(7000);
 
        sAccount4.deposit(300);
        sAccount4.withdraw(1500);
 
        cAccount4.deposit(3000);
        cAccount4.withdraw(2000);
 
        sAccount5.deposit(300);
        sAccount5.withdraw(1500);
 
        cAccount5.deposit(3000);
        cAccount5.withdraw(2000);
 
        sAccount6.deposit(300);
        sAccount6.withdraw(1500);
 
        cAccount6.deposit(3000);
        cAccount6.withdraw(2000);
         
        bank1.printClients();
        bank2.printClients();
 
        System.out.println();
    }
}
