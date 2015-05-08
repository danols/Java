import java.util.Vector;
 
public class BookStore {
 
    private String name;
    private Vector<Book> books;
    private Vector<Client> clients;
    private String location;
    private String schedule;
    private int numSales;
    private double earnings;
    private long phoneNumber;
    private String email;
 
    public BookStore(String name, String location, String schedule, long phoneNumber, String email) {
        this.name = name;
        this.location = location;
        this.schedule =  schedule;
        this.phoneNumber = phoneNumber;
        this.email = email;
        books = new Vector<Book>();
        clients = new Vector<Client>();
        earnings = 0;
        numSales = 0;
    }
 
    public BookStore(BookStore bookStore) {
        this.name = bookStore.name;
        this.location = bookStore.location;
        this.schedule =  bookStore.schedule;
        this.phoneNumber = bookStore.phoneNumber;
        this.email = bookStore.email;
        books = new Vector<Book>();
        clients = new Vector<Client>();
        earnings = 0;
        numSales = 0;
    }
 
    public void addClient(Client client) {
        clients.addElement(client);
    }
 
    public void addBook(Book book) {
        if(books.contains(book)) {
            int index = books.indexOf(book);
            (books.elementAt(index)).addCopie();
        }
        else books.addElement(book);
    }
 
    public boolean effectSale(Book book, Client client) {
        if(books.contains(book)) {
            int index = books.indexOf(book);
            if( (books.elementAt(index)).getNumCopies() > 0) {
                (books.elementAt(index)).quitCopie();
                (books.elementAt(index)).updateStatus();
                clients.addElement(client);
                earnings += book.getPrice();
                if(!(books.elementAt(index)).getStatus()) books.remove(index);
                return true;
            } else return false;
        } 
        return false;
    }
 
    public void listBooks() {
        System.out.println("\n\t\tLibros Disponibles En " + name);
        for(int i=0;i<books.size();i++) {
            if((books.elementAt(i)).getStatus())
                System.out.println("(" + (i+1) + ") " + (books.elementAt(i)).toString(false));
            System.out.println();
        }
    }
 
    public void getBooksOfAuthor(Author author) {
        books = author.getBooks();
    }
 
    public Book getBook(int index) {
        return books.elementAt(index - 1);
    }
 
    public void viewClients() {
        System.out.println("\n\t\tLista De Clientes En La Librería " + name);
        for(int i=0;i<clients.size();i++) {
            System.out.println("(" + (i+1) + ") " + clients.elementAt(i));
        }
    }
 
    public String toString() {
        return "\tLibrería " + name + 
        "\n\t" + location + 
        "\n\t" + schedule + 
        "\n\t" + Long.toString(phoneNumber) + 
        "\n\t" + email +
        "\n\t$ " + earnings;
 
    }
}
