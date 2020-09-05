package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {
    private String name;
    private String lastname;
    private String placeOfBrith;
    @Id
    @GeneratedValue
    private int authorId;

    public Author(String name, String lastname, String placeOfBrith) {
        this.name = name;
        this.lastname = lastname;
        this.placeOfBrith = placeOfBrith;
    }

    public Author() {
    }
}
