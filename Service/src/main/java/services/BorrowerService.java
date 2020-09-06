package services;

import daos.BorrowerDao;
import models.Borrower;

import javax.persistence.EntityManager;

public class BorrowerService {
    private BorrowerDao borrowerDao;

    public BorrowerService(EntityManager em) {
        this.borrowerDao = new BorrowerDao(em);
    }

    public int createNewAccount(Borrower borrower) {
        int idBorrower = borrowerDao.createNewUser(borrower);
        if (idBorrower != 0) {
            System.out.println("Congrats, your account created successfully. You \"user id\" is " + idBorrower);
            return idBorrower;
        } else {
            System.out.println("Something was wrong when you tried to create new account.");
            return 0;
        }
    }
}
