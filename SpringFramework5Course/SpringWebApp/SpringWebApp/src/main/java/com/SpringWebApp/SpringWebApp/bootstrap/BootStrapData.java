package com.SpringWebApp.SpringWebApp.bootstrap;

import com.SpringWebApp.SpringWebApp.domain.Author;
import com.SpringWebApp.SpringWebApp.domain.Book;
import com.SpringWebApp.SpringWebApp.domain.Publisher;
import com.SpringWebApp.SpringWebApp.repositories.AuthorRepository;
import com.SpringWebApp.SpringWebApp.repositories.BookRepository;
import com.SpringWebApp.SpringWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in BootStrap");

        Author author1 = new Author("Vasil", "Vasilev");
        Book book1 = new Book("DomainDrivenDesign", "112233");

        Publisher publisher1 = new Publisher();
        publisher1.setName("New Wave Publisher");
        publisher1.setCity("Montana");
        publisher1.setState("Montana");
        publisherRepository.save(publisher1);

        author1.getBooksSet().add(book1);
        book1.getAuthorsSet().add(author1);
        book1.setPublisher(publisher1);
        publisher1.getBooks().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher1);

        Author author2 = new Author("Peter", "Petrov");
        Book book2 = new Book("NewBooks2022", "998877");
        author2.getBooksSet().add(book2);
        book2.getAuthorsSet().add(author2);
        book2.setPublisher(publisher1);
        publisher1.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher1);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher1.getBooks().size());


    }
}
