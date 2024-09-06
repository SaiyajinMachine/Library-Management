package io.andrepinho.library.converter;

import io.andrepinho.library.dto.BookDto;
import io.andrepinho.library.model.Book;
import io.andrepinho.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookDtoToBook implements Converter<Book, BookDto> {

    @Autowired
    private BookService bookService;

    @Override
    public List<Book> convertList(List<BookDto> bookDtoList) {
        return bookDtoList.stream().map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Book convert(BookDto bookDto) {
        Book book = (bookDto.getId() != null ? bookService.get(bookDto.getId()) : new Book());

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setPrice(bookDto.getPrice());
        book.setPublished_date(bookDto.getPublished_date());

        return book;
    }
}
