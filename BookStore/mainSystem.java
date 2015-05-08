public class mainSystem {
 
    public static void main(String[] args) {
 
        BookStore bookStore1 = new BookStore (
            "Gandhi",
            "Gustavo A. Madero N.15",
            "Lunes A Viernes 8:00 AM - 7:00 PM",
            56871235,
            "gandhiamadero@gandhi.com"
        );
        Author author1 = new Author (
            "Gabriel García Márquez",
            "Colombiana",
            "Masculino"
        );
        Client client1 = new Client("Daniel López",
            58677628,
            "jdaniel.ipn@gmail.com",
            19,"Masculino"
        );
 
        author1.addBook(new Book("Cien Años De Soledad",author1,"Leer-e",471,1967,150));
        author1.addBook(new Book("El Amor En Tiempos De Cólera",author1,"Cátedra",254,1980,90));
        bookStore1.getBooksOfAuthor(author1);
        System.out.println(bookStore1);
        bookStore1.listBooks();
        author1.listBooks();
        client1.buyBook(bookStore1.getBook(1),bookStore1);
        bookStore1.listBooks();
        bookStore1.viewClients();
        client1.viewBooks();
        System.out.println(bookStore1);
    }
}
