package models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class Borrow {
    @Id
    private int borrowId;
    private LocalDate dateOfBorrowing;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

}
