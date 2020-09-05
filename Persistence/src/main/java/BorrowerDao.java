import models.Borrower;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BorrowerDao extends GenericDao<Borrower, Integer>{
    public BorrowerDao(EntityManager em) {
        super(em);
    }


    public int createNewUser(Borrower borrower) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(borrower);
            em.flush();
            transaction.commit();
            return borrower.getId_borrower();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return 0;
    }
}
