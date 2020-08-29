import models.Borrower;

import javax.persistence.EntityManager;

public class BorrowerDao extends GenericDao<Borrower, Integer>{
    public BorrowerDao(EntityManager em) {
        super(em);
    }
}
