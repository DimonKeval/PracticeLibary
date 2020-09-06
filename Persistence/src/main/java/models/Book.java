package models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
@Entity
@Table(name = "Book")
public class Book {
    private String title;
    private LocalDate dateOfRelease;
    @Id
    @Column(precision = 0)
    private BigInteger isbn;
    @Enumerated(EnumType.STRING)
    private BookType type;
    private int pages;
    private String description;
    @ManyToOne
    @JoinColumn (name = "author_id")
    private Author author;
    private boolean borrow;

    public Book() {
    }

    public Book(String title, LocalDate dateOfRelease, BigInteger isbn, BookType type, int pages, String description, Author author, boolean borrow) {
        this.title = title;
        this.dateOfRelease = dateOfRelease;
        this.isbn = isbn;
        this.type = type;
        this.pages = pages;
        this.description = description;
        this.author = author;
        this.borrow = borrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn=" + isbn +
                ", type=" + type +
                ", pages=" + pages +
                ", author=" + author +
                '}';
    }

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
