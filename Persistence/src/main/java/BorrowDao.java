import models.Borrow;

import javax.persistence.EntityManager;

public class BorrowDao extends GenericDao<Borrow, Integer> {
    public BorrowDao(EntityManager em) {
        super(em);
    }
}
