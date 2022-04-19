package guru.springframework.jdbc.dao;

import guru.springframework.jdbc.domain.Book;
import guru.springframework.jdbc.repositories.BookRepository;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import java.util.List;

public class BookDaoImpl implements BookDao {

    private final BookRepository bookRepository;

    public BookDaoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooksSortByTitle(Pageable pageable) {
        return null;
    }

    @Override
    public List<Book> findAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Book> findAllBooks(int pageSize, int offset) {
        return null;
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book saveNewBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    @Override
    public Book updateBook(Book book) {
        Book bookFound = bookRepository.getById(book.getId());
        bookFound.setTitle(book.getTitle());
        bookFound.setIsbn(book.getIsbn());
        bookFound.setPublisher(book.getPublisher());
        bookFound.setAuthorId(book.getAuthorId());
        return bookRepository.save(bookFound);
    }

    @Override
    public void deleteBookById(Long id) {

    }
}
