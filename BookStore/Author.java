import java.util.Vector;
 
public class Author {
 
    private String name;
    private String nationality;
    private String gender;
    private Vector<Book> books;
 
    public Author(String name, String nationality, String gender) {
        this.name = name;
        this.nationality = nationality;
        this.gender = gender;
        books = new Vector<Book>();
    }
 
    public Author(Author author) {
        this.name = author.name;
        this.nationality = author.nationality;
        this.gender = author.gender;
        books = new Vector<Book>();
    }
 
    public String getName() { return name; }
 
    public void addBook(Book book) {
        books.addElement(book);
    }
 
    public void listBooks() {
        System.out.println("\n\t\tObras Disponibles Del Autor " + name);
        for(int i=0;i<books.size();i++) {
            System.out.println("(" + (i+1) + ") " + (books.elementAt(i)).toString(true));
        }
    }
 
    public Vector<Book> getBooks() {
        return books;
    }
}
