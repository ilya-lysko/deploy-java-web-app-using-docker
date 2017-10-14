package ru.atom.entitiestocreate;

import ru.atom.dao.AuthorDao;
import ru.atom.hibernateentities.Author;
import ru.atom.hibernateentities.Book;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
public class BookToCreate {
    private String name;
    private Integer authorId;
    private Integer pagesCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

    public static Book convertToHibernateBook(BookToCreate bookToCreate) {
        Book book = new Book();
        book.setName(bookToCreate.getName());
        Author author = AuthorDao.getAuhtor(bookToCreate.getAuthorId());
        book.setAuthor(author);
        book.setWriteDate(new Date());
        book.setPagesCount(bookToCreate.getPagesCount());
        return book;
    }
}
