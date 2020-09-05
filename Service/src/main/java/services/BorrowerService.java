package services;

import daos.BorrowerDao;
import models.Borrower;

import javax.persistence.EntityManager;

public class BorrowerService {
    private BorrowerDao borrowerDao;

    public BorrowerService(EntityManager em) {
        this.borrowerDao = new BorrowerDao(em);
    }

    public String CreateNewAccount(Borrower borrower) {
        int idBorrower = borrowerDao.createNewUser(borrower);
        if (idBorrower != 0) {
            return "Congrats, your account created successfully. You \"user id\" is " + idBorrower;
        } else {
            return "Something was wrong when you tried to create new account.";
        }
    }
}
