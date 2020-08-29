package models;

import javax.persistence.Id;

public class Borrower {
    private String name;
    private String lastname;
    private String address;
    private String phoneNumber;
    private String email;
    @Id
    private int id;
}
