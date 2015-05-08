import java.util.Vector;
 
public class Client {
 
    private String name;
    private long phoneNumber;
    private String email;
    private Vector<Book> books;
    private int age;
    private String gender;
 
    public Client(String name, long phoneNumber, String email, int age, String gender) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email =  email;
        this.age = age;
        this.gender = gender;
        books = new Vector<Book>();
    }
 
    public Client(Client client) {
        this.name = client.name;
        this.phoneNumber = client.phoneNumber;
        this.email = client.email;
        this.age = client.age;
        this.gender = client.gender;
        books = new Vector<Book>();
    }
 
    public void buyBook(Book book, BookStore bookStore) {
        if(bookStore.effectSale(book,this))
            books.addElement(book);
    }
 
    public void viewBooks() {
        System.out.println("\n\t\tLibros Comprados");
        for(int i=0;i<books.size();i++) {
            System.out.println("(" + (i+1) + ") " + (books.elementAt(i)).toString(true));
        }
        System.out.println();
    }
 
    public String toString() {
        return "\tNombre: " + name +
        "\n\tTeléfono: " + phoneNumber + 
        "\n\tE-mail: " + email;
    }
 
}
