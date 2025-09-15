package hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository repository) {
		return args -> {
			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", 10.99));
			repository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "9780747532699", 8.99));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 7.99));
		};
	}
}
