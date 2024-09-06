package io.andrepinho.library.dao;

import io.andrepinho.library.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDao implements Dao<Book> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book findById(Integer id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        CriteriaQuery<Book> criteriaQuery = em.getCriteriaBuilder().createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(Book.class, id));
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return em.merge(book);
    }
}
