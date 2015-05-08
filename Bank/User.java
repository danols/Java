public class User {
    public static void main(String[] args) {
 
        Bank bank1 = new Bank(3);
        Bank bank2 = new Bank(2);
 
        Client client = new Client(null,null);
        Account account = new Account(0);
 
        bank1.addClient("Daniel Lopez","01123581");
        bank1.addClient("Manuel Lara","57810023");
        bank1.addClient("Jefferson Ramirez","85374450");
 
        bank2.addClient("Carlos Martinez","75981235");
        bank2.addClient("Jorge Campos","96325871");
 
        client = bank1.getClient(1);
        //System.out.println("\n\t Cliente 1" + client);
 
        client.setAccount(account);
        account = client.getAccount();
        account.deposit(1200);
        System.out.println("\t\tSaldo: $ " + account.consult());
        account.withdraw(200);
        System.out.println("\t\tSaldo: $ " + account.consult());
        account.deposit(12000);
        System.out.println("\t\tSaldo: $ " + account.consult());
        account.withdraw(1100);
        System.out.println("\t\tSaldo: $ " + account.consult());
        account.deposit(120);
        System.out.println("\t\tSaldo: $ " + account.consult());
        account.withdraw(300);
        System.out.println("\t\tSaldo: $ " + account.consult());
        //System.out.println("\n\t Cliente 1" + client);
 
        bank1.viewClients();
 
    }
}
