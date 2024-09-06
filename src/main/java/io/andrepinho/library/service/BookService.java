package io.andrepinho.library.service;

import io.andrepinho.library.dao.BookDao;
import io.andrepinho.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public Book get(Integer id) {
        return bookDao.findById(id);
    }

    public List<Book> list() {
        return bookDao.findAll();
    }

    @Transactional
    public Book save(Book book) {
        return bookDao.saveOrUpdate(book);
    }

    @Transactional
    public void delete(Integer id) {
        bookDao.delete(id);
    }
}
