package hh.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.bookstore.domain.BookRepository;

@Controller
public class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/index")
    public String welcomeMessage(Model model) {
        model.addAttribute("welcomeMessage", "Welcome to the Bookstore!");
        return "index";
    }
}
