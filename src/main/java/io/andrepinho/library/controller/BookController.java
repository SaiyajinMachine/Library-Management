package io.andrepinho.library.controller;

import io.andrepinho.library.converter.BookDtoToBook;
import io.andrepinho.library.converter.BookToBookDto;
import io.andrepinho.library.dto.BookDto;
import io.andrepinho.library.model.Book;
import io.andrepinho.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookToBookDto bookToBookDto;

    @Autowired
    private BookDtoToBook bookDtoToBook;

    @RequestMapping(method = RequestMethod.GET, path = {"", "/"})
    public String listBooks(Model model){

        model.addAttribute("books", bookToBookDto.convertList(bookService.list()));
        return "books";

    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public String viewBook(@PathVariable Integer id, Model model) {

        model.addAttribute("book", bookToBookDto.convert(bookService.get(id)));
        return "view-book";

    }

    @RequestMapping(method = RequestMethod.GET, path = {"/add"})
    public String addBook(Model model) {
        model.addAttribute("book", new BookDto());
        return "add-update";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}/edit"})
    public String editBook(@PathVariable Integer id ,Model model){
        model.addAttribute("book", bookToBookDto.convert(bookService.get(id)));
        return "add-update";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/save"}, params = "action=save")
    public String saveBook(@Valid @ModelAttribute("book") BookDto bookDto, BindingResult bindingResult ,RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            return "add-update";
        }

        Book addedBook = bookService.save(bookDtoToBook.convert(bookDto));

        redirectAttributes.addFlashAttribute("lastAction", "Book added/edited!");
        return "redirect:/books/" + addedBook.getId();

    }

    @RequestMapping(method = RequestMethod.POST, path = {"/save"}, params = "action=cancel")
    public String cancelSaveBook() {
        return "redirect:/books";
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}/delete"})
    public String deleteBook(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

        bookService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Book has been deleted.");
        return "redirect:/books";

    }
}
