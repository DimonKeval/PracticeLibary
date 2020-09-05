package models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Borrower {
    private String name;
    private String lastname;
    private String address;
    private String phoneNumber;
    private String email;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_borrower;

    public int getId_borrower() {
        return id_borrower;
    }
}
