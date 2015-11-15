package dao;

import java.util.List;
import model.Book;
import model.Category;

public interface BookDAO {
    public List<Book> findAllBooks();
    public List<Book> searchBooksBykeyword(String keyWord);
    public List<Category> findAllCategories();
}
