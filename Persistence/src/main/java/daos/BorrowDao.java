package daos;

import models.Borrow;
import models.Borrower;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BorrowDao extends GenericDao<Borrow, Integer> {
    public BorrowDao(EntityManager em) {
        super(em);
    }

    public int borrowABook(Borrow borrow) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(borrow);
            em.flush();
            transaction.commit();
            return borrow.getBorrowId();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return 0;
    }
}
