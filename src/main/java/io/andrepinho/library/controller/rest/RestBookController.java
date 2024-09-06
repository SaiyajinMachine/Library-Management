package io.andrepinho.library.controller.rest;

import io.andrepinho.library.converter.BookDtoToBook;
import io.andrepinho.library.converter.BookToBookDto;
import io.andrepinho.library.dto.BookDto;
import io.andrepinho.library.model.Book;
import io.andrepinho.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class RestBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookToBookDto bookToBookDto;

    @Autowired
    private BookDtoToBook bookDtoToBook;

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<BookDto>> listBooks() {

        return new ResponseEntity<>(bookToBookDto.convertList(bookService.list()), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable Integer id) {
        Book book = bookService.get(id);

        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookToBookDto.convert(book), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"", "/"})
    public ResponseEntity<String> addBook(@Valid @RequestBody BookDto bookDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors() || bookDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        bookService.save(bookDtoToBook.convert(bookDto));

        return new ResponseEntity<>("Book added", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<String> editBook(@Valid @RequestBody BookDto bookDto, BindingResult bindingResult, @PathVariable Integer id) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(bookDto.getId() != null && !bookDto.getId().equals(id)) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

        if(bookService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookDto.setId(id);

        bookService.save(bookDtoToBook.convert(bookDto));

        return new ResponseEntity<>("Book edited", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/{id}"})
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {

        if(bookService.get(id) == null) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }

        bookService.delete(id);

        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }

}