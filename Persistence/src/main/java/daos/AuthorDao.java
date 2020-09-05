package daos;

import models.Author;

import javax.persistence.EntityManager;

public class AuthorDao extends GenericDao<Author, Integer>{
    public AuthorDao(EntityManager em) {
        super(em);
    }
}
