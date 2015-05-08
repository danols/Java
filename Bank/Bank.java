public class Bank {
 
    private int numClients;
    private Client[] clients;
 
    public Bank(int n) {
        clients = new Client[n];
        numClients = 0;
    }
 
    public void addClient(String name, String numAccount) {
        clients[numClients] = new Client(name,numAccount);
        numClients++;
    }
 
    public int getNumClients() {
        return numClients;
    }
 
    public Client getClient(int index) {
        return clients[index-1];
    }
 
    public void viewClients() {
        for(int i=0;i<numClients;i++) {
            System.out.println(clients[i]);
        }
    }
}
