public class Book {
 
    private int id;
    private String name;
    private Author author;
    private String editorial;
    private int numPages;
    private int year;
    private String review;
    private double price;
    private boolean status;
    private int numCopies = 1;
 
    public Book(String name, Author author, String editorial, int numPages, int year, double price) {
        this.name = name;
        this.author = author;
        this.editorial =  editorial;
        this.numPages = numPages;
        this.year = year;
        this.author = new Author(author);
        this.price = price;
        this.status = true;
    }
 
    public Book(Book book) {
        this.name = book.name;
        this.author = book.author;
        this.editorial =  book.editorial;
        this.numPages = book.numPages;
        this.year = book.year;
        this.author = new Author(book.author);
        this.price = book.price;
        this.status = true;
    }
 
    public void setReview(String review) {
        this.review = review;
    } 
 
    public String getReview() {
        return this.review;
    }
 
    public boolean getStatus() { return status; }
 
    public int getNumCopies() { return numCopies; }
 
    public void addCopie() { numCopies++; }
 
    public void quitCopie() { numCopies--; }
 
    public void updateStatus() {
        if(numCopies == 0) status = false;
    }
 
    public double getPrice() { return price; }
 
    public String toString(boolean b) {
        if(b) {
            return "\t" + name + "\t$ " + price;
        }
        return "\t" + name + 
        "\n\t" + author.getName() +  
        "\n\t" + editorial +  
        "\n\t" + Integer.toString(numPages) + " pgs." +  
        "\n\t" + year + 
        "\n\t$ " + price +
        "\n\tEjemplares Disponibles: " + numCopies;
    }
 
}
