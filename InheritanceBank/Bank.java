import java.util.Vector;
 
public class Bank {
 
    private String name;
    private Vector<Client> clients;
    private int numClients;
 
    public Bank(String name) {
        this.name = name;
        clients = new Vector<Client>();
        numClients = 0;
    }
 
    public Bank(String name, Vector<Client> clients) {
        this.name = name;
        this.clients = clients;
        numClients = clients.size();
    }
 
    public Client getClient(int index) {
        return clients.elementAt(index - 1);
    }
 
    public void addClient(Client client) {
        clients.addElement(client);
        numClients = clients.size();
    } 
 
    public void printClients() {
        System.out.println("\n\n\t\t***Clientes de " + name + "***");
        for(Client c : clients) {
            System.out.print(c);
            c.getInfo();
        }
    }
 
    public String toString() {
        return "\n\tBanco " + name +
        "\n\tNúmero de Clientes: " + numClients;
    }
}
