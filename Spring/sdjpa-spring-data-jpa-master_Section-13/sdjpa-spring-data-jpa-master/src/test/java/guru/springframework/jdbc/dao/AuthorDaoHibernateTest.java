package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Author;
import guru.springframework.jdbc.domain.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"guru.springframework.jdbc.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AuthorDaoHibernateTest {
    @Autowired
    EntityManagerFactory emf;

    AuthorDao authorDao;

    @BeforeEach
    void setUp() {
        authorDao = new AuthorDaoHibernate(emf);
    }

    @Test
    void testFindAllAuthors() {
        List<Author> authors = authorDao.findAllBooks(PageRequest.of(0, 43));

        assertThat(authors).isNotNull();
//        assertThat(authors.size()).isEqualTo(10);
        for (Author author : authors) {
            System.out.println(author.getFirstName() + " " + author.getLastName());
        }
    }
}
