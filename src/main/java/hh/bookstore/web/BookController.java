package hh.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.bookstore.domain.Book;
import hh.bookstore.domain.BookRepository;
import hh.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
   
    private BookRepository repository;

    public BookController(BookRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    private CategoryRepository categoryRepository;

    @GetMapping("/index")
    public String welcomeMessage(Model model) {
        model.addAttribute("welcomeMessage", "Welcome to the Bookstore!");
        return "index";
    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id)));
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Book book) {
        book.setId(id);
        repository.save(book);
        return "redirect:/booklist";
    }
}