package client;

import java.util.List;
import dao.BookDAO;
import dao.BookDAOImpl;
import model.Book;

public class BookApp {
    private static BookDAO bookDao = new BookDAOImpl();

    public static void main(String[] args) {
        System.out.println("Listing all Books:");
        findAllBooks();
        System.out.println();
        System.out.println("Search book by keyword in book title:");
        searchBooks("Groovy");
        System.out.println();
        System.out.println("Search book by keyword in author's name:");
        searchBooks("Josh");
    }

    private static void findAllBooks() {
        List<Book> books = bookDao.findAllBooks();
        for(Book book : books) {
            System.out.println(book);
        }
    }
 
    private static void searchBooks(String keyword) {
        List<Book> books = bookDao.searchBooksBykeyword(keyword);
        for(Book book : books) {
            System.out.println(book);
        }
    }
}
