package services;

import daos.BookDao;
import daos.BorrowDao;
import daos.BorrowerDao;
import models.Book;
import models.Borrow;
import models.Borrower;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookService {
    private EntityManager em;
    private BookDao bookDao;
    BorrowDao borrowDao;
    BorrowerDao borrowerDao;
    Scanner scan = new Scanner(System.in);

    public BookService(EntityManager em) {
        this.em = em;
        this.bookDao = new BookDao(em);
        this.borrowDao = new BorrowDao(em);
        this.borrowerDao = new BorrowerDao(em);
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


        BorrowerService borrowerService = new BorrowerService(em);
        int borrowID = 0;
        if (book.isBorrow()) {
            return " - - - - - - - - - - - - - - - \nYou can't borrow this book now - this book is already borrowed " +
                    "by somebody.";
        } else {

            if (borrowerDao.exists(borrowerId)) {
                book.setBorrow(true);
                borrowDao.create(new Borrow(LocalDate.now(), book, borrowerDao.read(borrowerId)));
            } else {
                System.out.println(" - - - - - - - -\nAccount whit this id doesn't exist. Please write your data for " +
                        "creating new " +
                        "account");

                System.out.println("Name: ");
                String name = scan.nextLine();
                System.out.println("Lastname: ");
                String lastname = scan.nextLine();
                System.out.println("Address: ");
                String address = scan.nextLine();
                System.out.println("Phone number: ");
                String phoneNumber = scan.nextLine();
                System.out.println("E-mail: ");
                String email = scan.nextLine();
                Borrower borrower = new Borrower(name, lastname, address, phoneNumber, email);
                borrowerId = borrowerService.createNewAccount(borrower);
                book.setBorrow(true);
                borrowID = borrowDao.borrowABook(new Borrow(LocalDate.now(), book, borrowerDao.read(borrowerId)));
            }
        }
        bookDao.update(book);
        return " - - - - - - - - - - - - - - - - \nEnjoy reading this wonder book.\n - - - - - - - - - - - - - - - - " +
                "\n Your borrow ID is: " + borrowID;
    }

    public boolean BookReturn() {
        List<Borrow> borrowList = borrowDao.findAll();
        borrowList.forEach(b -> System.out.println("Borrow ID: " + b.getBorrowId() + ": " + b.getBorrower().getIdBorrower() + " " + b.getBorrower().getName() + " " + b.getBorrower().getLastname() + " - - - " + b.getBook().getTitle() + " " + b.getBook().getIsbn()));

        System.out.println("Choose Borrow ID, which do you want to close.");
        int borrowID = scan.nextInt();
        try {
            Book returnBook = borrowDao.read(borrowID).getBook();
            returnBook.setBorrow(false);
            bookDao.update(returnBook);
            borrowDao.delete(borrowID);
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
