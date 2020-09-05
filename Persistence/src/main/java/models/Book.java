package models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

public class Book {
    private String title;
    private LocalDate dateOfRelease;
    @Id
    private BigInteger isbn;
    private BookType type;
    private int pages;
    private String description;
    @ManyToOne
    @JoinColumn (name = "author_id")
    private Author author;
    private boolean borrow;

    public String getTitle() {
        return title;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public BigInteger getIsbn() {
        return isbn;
    }

    public BookType getType() {
        return type;
    }

    public int getPages() {
        return pages;
    }

    public String getDescription() {
        return description;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }
}
