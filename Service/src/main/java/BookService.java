import models.Book;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigInteger;

public class BookService {

    public String DeleteFromList(BigInteger isbn, EntityManager em) {
        BookDao bookDao = new BookDao(em);
        Book book = bookDao.read(isbn);
        if (book.isBorrow()) {
            return "Action is unpossible: book is borrowed";
        } else {
            bookDao.delete(isbn);
        }
        return "Book has been deleted from BookList.";
    }
}
