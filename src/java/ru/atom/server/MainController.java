package ru.atom.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.atom.dao.AuthorDao;
import ru.atom.dao.BookDao;
import ru.atom.dao.ReaderDao;
import ru.atom.dao.ReadingDao;
import ru.atom.entitiestocreate.AuthorToCreate;
import ru.atom.entitiestocreate.BookToCreate;
import ru.atom.entitiestocreate.ReaderToCreate;
import ru.atom.entitiestocreate.ReadingToCreate;
import ru.atom.hibernateentities.Author;
import ru.atom.hibernateentities.Book;
import ru.atom.hibernateentities.Reader;
import ru.atom.hibernateentities.Reading;

import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/addBook", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Book addBook(@RequestBody BookToCreate bookToCreate) {
        Book book = BookToCreate.convertToHibernateBook(bookToCreate);
        BookDao.saveBook(book);
        return book;
    }

    @RequestMapping(value = "/addReader", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Reader addReader(@RequestBody ReaderToCreate readerToCreate) {
        Reader reader = ReaderToCreate.convertToHibernateReader(readerToCreate);
        ReaderDao.saveReader(reader);
        return reader;
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Author addAuthor(@RequestBody AuthorToCreate authorToCreate) {
        Author author = AuthorToCreate.convertToHibernateAuthor(authorToCreate);
        AuthorDao.saveAuthor(author);
        return author;
    }

    @RequestMapping(value = "/addReading", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public Reading addReader(@RequestBody ReadingToCreate readingToCreate) {
        Reading reading = ReadingToCreate.convertToHibernateReading(readingToCreate);
        ReadingDao.saveReading(reading);
        return reading;
    }
}
