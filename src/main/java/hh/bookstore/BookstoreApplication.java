package hh.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository repository, CategoryRepository categoryRepository) {
		return args -> {
			log.info("Save some categories");
			Category classic = new Category("Classic Literature");
			categoryRepository.save(classic);
			Category fantasy = new Category("Fantasy");
			categoryRepository.save(fantasy);
			Category mystery = new Category("Mystery");
			categoryRepository.save(mystery);
			Category scienceFiction = new Category("Science Fiction");
			categoryRepository.save(scienceFiction);
			Category horror = new Category("Horror");
			categoryRepository.save(horror);
			Category youngAdult = new Category("Young Adult Fiction");
			categoryRepository.save(youngAdult);
			Category children = new Category("Children's Literature");
			categoryRepository.save(children);
			Category nonFiction = new Category("Non-Fiction");
			categoryRepository.save(nonFiction);
			Category other = new Category("Other");
			categoryRepository.save(other);

			log.info("Save some books");
			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", 10.99, classic));
			repository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, "9780747532699", 8.99, fantasy));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 7.99, classic));
			repository.save(new Book("The Fault in Our Stars", "John Green", 2012, "9780525478812", 9.99, youngAdult));
			repository.save(new Book("Mauri Kunnaksen Koiramäki", "Mauri Kunnas", 1996, "9789511317134", 12.99, children));
			repository.save(new Book("Murder on the Orient Express", "Agatha Christie", 1934, "9780007119318", 6.99, mystery));

			log.info("Fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			log.info("Fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
