package services;

import daos.AuthorDao;
import models.Author;

import javax.persistence.EntityManager;

public class AuthorService {
    private EntityManager em;
    private AuthorDao authorDao;

    public AuthorService(EntityManager em) {
        this.em = em;
        this.authorDao = new AuthorDao(em);
    }

    public boolean createNewAuthor(Author author) {
        authorDao.create(author);
        return true;
    }

    public boolean existsAuthor(int authorId) {
        return authorDao.read(authorId) != null;
    }
}
