package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import guru.springframework.jdbc.domain.Book;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDaoHibernate implements AuthorDao {
    private final EntityManagerFactory emf;

    public AuthorDaoHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Author> findAllBooks(Pageable pageable) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a", Author.class);
            query.setFirstResult(Math.toIntExact(pageable.getOffset()));
            query.setMaxResults(pageable.getPageSize());
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    @Override
    public Author getById(Long id) {
        return null;
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Author saveNewAuthor(Author author) {
        return null;
    }

    @Override
    public Author updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteAuthorById(Long id) {

    }

    @Override
    public List<Author> findAllAuthorsByLastName(String lastname, Pageable pageable) {
        return null;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
