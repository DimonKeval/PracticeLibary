import models.Book;

import javax.persistence.EntityManager;
import java.math.BigInteger;

public class BookDao extends GenericDao<Book, BigInteger>{
    public BookDao(EntityManager em) {
        super(em);
    }
}
