package models;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

public class Book {
    String title;
    LocalDate dateOfRelease;
    BigInteger isbn;
    BookType type;
    int pages;
    String description;
    @ManyToOne
    @JoinColumn (name = "author_id")
    private Author author;
}
