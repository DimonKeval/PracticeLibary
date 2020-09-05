package models;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Borrow")
public class Borrow {
    @Id
    @GeneratedValue
    private int borrowId;
    private LocalDate dateOfBorrowing;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    public Borrow(LocalDate dateOfBorrowing, Book book, Borrower borrower) {
        this.dateOfBorrowing = dateOfBorrowing;
        this.book = book;
        this.borrower = borrower;
    }
}
