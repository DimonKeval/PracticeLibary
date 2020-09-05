package launching;

import daos.AuthorDao;
import daos.BookDao;
import models.Author;
import models.Book;
import models.BookType;
import services.AuthorService;
import services.BookService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class AppLauncher {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory;
        EntityManager em;
        managerFactory = Persistence.createEntityManagerFactory("LibraryPersistenceUnit");
        em = managerFactory.createEntityManager();
        AuthorService authorService = new AuthorService(em);
        AuthorDao authorDao = new AuthorDao(em);
        BookService bookService = new BookService(em);
        BookDao bookDao = new BookDao(em);
        Scanner scanFromConsole = new Scanner(System.in);
        System.out.println(" - - - - - - - - - - - - \nStarting the program.\n - - - - - - - - - - - - \n");

        System.out.println(" - - - - - - - - - - - - \nPlease, choose an option:\n - - - - - - - - - - - - \n" +
                "1 - Add new book\n" +
                "2 - Remove existing book\n" +
                "3 - Borrow some book\n" +
                "4 - Give back borrowed book\n");
        int option = scanFromConsole.nextInt();
        scanFromConsole.nextLine();

        switch (option) {
            case 1:
                System.out.println("Write book's title: ");
                String title = scanFromConsole.nextLine();

                System.out.println("Write date of book release (yyyy-mm-dd): ");
                LocalDate dateOfRelease = LocalDate.parse(scanFromConsole.nextLine());

                System.out.println("Write book's ISBN number: ");
                BigInteger isbn = scanFromConsole.nextBigInteger();

                System.out.println("Choose number of book's type from list " + Arrays.toString(BookType.values()));
                BookType type = BookType.values()[scanFromConsole.nextInt()];

                System.out.println("Write how many pages has book: ");
                int pages = scanFromConsole.nextInt();
                scanFromConsole.nextLine();

                System.out.println("Write book's description: ");
                String description = scanFromConsole.nextLine();

                System.out.println("Write author's id: ");
                int authorId = scanFromConsole.nextInt();
                Author author;
                if (authorService.existsAuthor(authorId)) {
                    author = authorDao.read(authorId);
                } else {
                    System.out.println("Write author's name: ");
                    scanFromConsole.nextLine();
                    String name = scanFromConsole.nextLine();
                    System.out.println("Write author's lastname: ");
                    String lastname = scanFromConsole.nextLine();
                    System.out.println("Write author's place of birth: ");
                    String placeOfBrith = scanFromConsole.nextLine();
                    author = new Author(name, lastname, placeOfBrith);
                    authorService.createNewAuthor(author);
                }

                Book book = new Book(title, dateOfRelease, isbn, type, pages, description, author, false);
                bookService.AddNewBook(book);
                break;
            case 2:
                System.out.println(" - - - - - - - - - - - - -\nPlease write ISBN of which book would you like to " +
                        "remove from library?");
                BigInteger isbnForRemove = scanFromConsole.nextBigInteger();
                if (bookDao.read(isbnForRemove) != null){
                    bookService.DeleteFromList(isbnForRemove);
                } else {
                    System.out.println("Wrong ISBN or book is already removed.");
                }
            default:
                break;
        }
    }
}