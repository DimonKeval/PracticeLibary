package services;

import daos.BookDao;
import daos.BorrowDao;
import daos.BorrowerDao;
import models.Book;
import models.Borrow;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.time.LocalDate;

public class BookService {
    private EntityManager em;
    private BookDao bookDao;

    public BookService(EntityManager em) {
        this.em = em;
        this.bookDao = new BookDao(em);
    }

    public String DeleteFromList(BigInteger isbn) {
        Book book = bookDao.read(isbn);
        if (book.isBorrow()) {
            return "Action is impossible: book is borrowed.";
        } else {
            bookDao.delete(isbn);
        }
        return "Book has been deleted from BookList.";
    }

    public String AddNewBook(Book book) {
        if (bookDao.create(book)) {
            return "Book is added to library.";
        }
        return "Adding is failed.";
    }

    public String BookBorrowing(BigInteger isbn, int borrowerId) {
        Book book = bookDao.read(isbn);
        BorrowDao borrowDao = new BorrowDao(em);
        BorrowerDao borrowerDao = new BorrowerDao(em);
        if (book.isBorrow()) {
            return "You can't borrow this book now - this book is already borrowed by somebody.";
        } else {

            if (borrowerDao.exists(borrowerId)) {
                book.setBorrow(true);
                borrowDao.create(new Borrow(LocalDate.now(), book, borrowerDao.read(borrowerId)));
            }
        }
        bookDao.update(book);
        return "Enjoy reading this wonder book.";
    }
}
