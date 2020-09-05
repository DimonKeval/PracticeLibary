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

    public int getIdBorrower() {
        return idBorrower;
    }

}
