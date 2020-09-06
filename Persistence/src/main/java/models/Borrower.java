package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Borrower")
public class Borrower {
    private String name;
    private String lastname;
    private String address;
    private String phoneNumber;
    private String email;
    @Id
    @GeneratedValue
    private int idBorrower;

    public Borrower() {
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Borrower(String name, String lastname, String address, String phoneNumber, String email) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getIdBorrower() {
        return idBorrower;
    }

}
