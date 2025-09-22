package hh.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.Category;
import hh.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository repository, CategoryRepository categoryRepository) {
		return args -> {
			categoryRepository.save(new Category("Classic Literature"));
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Mystery"));
			categoryRepository.save(new Category("Science Fiction"));
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Young Adult Fiction"));
			categoryRepository.save(new Category("Children's Literature"));
			categoryRepository.save(new Category("Non-Fiction"));
			categoryRepository.save(new Category("Other"));

			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", 10.99, categoryRepository.findByName("Classic Literature").get(0)));
			repository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "9780747532699", 8.99, categoryRepository.findByName("Fantasy").get(0)));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 7.99, categoryRepository.findByName("Classic Literature").get(0)));
			repository.save(new Book("The Fault in Our Stars", "John Green", 2012, "9780525478812", 9.99, categoryRepository.findByName("Young Adult Fiction").get(0)));
			repository.save(new Book("Mauri Kunnaksen Koiramäki", "Mauri Kunnas", 1996, "9789511317134", 12.99, categoryRepository.findByName("Children's Literature").get(0)));
			repository.save(new Book("Murder on the Orient Express", "Agatha Christie", 1934, "9780007119318", 6.99, categoryRepository.findByName("Mystery").get(0)));
		};
	}
}
