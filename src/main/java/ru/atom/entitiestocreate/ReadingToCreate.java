package ru.atom.entitiestocreate;

import ru.atom.dao.BookDao;
import ru.atom.dao.ReaderDao;
import ru.atom.hibernateentities.Book;
import ru.atom.hibernateentities.Reader;
import ru.atom.hibernateentities.Reading;

import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
public class ReadingToCreate {
    private Integer readerId;
    private Integer bookId;

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public static Reading convertToHibernateReading(ReadingToCreate readingToCreate) {
        Reading reading = new Reading();
        Book book = BookDao.getBook(readingToCreate.getBookId());
        reading.setBook(book);
        Reader reader = ReaderDao.getReader(readingToCreate.getReaderId());
        reading.setReader(reader);
        reading.setStartDate(new Date());
        return reading;
    }
}
