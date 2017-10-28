package ru.atom.server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

/**
 * Created by ilysko on 11.10.17.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/addBook", method = RequestMethod.POST,
            consumes = "application/json", produces="application/json")
    @ResponseBody
    public ResponseEntity addBook(@RequestBody BookToCreate bookToCreate) {
        if (AuthorDao.getAuhtor(bookToCreate.getAuthorId()) == null ||
                bookToCreate.getName().equals("") ||
                bookToCreate.getName().length() > 50 ||
                bookToCreate.getPagesCount() < 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Book book = BookToCreate.convertToHibernateBook(bookToCreate);
        BookDao.saveBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addReader", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public ResponseEntity addReader(@RequestBody ReaderToCreate readerToCreate) {
        if (readerToCreate.getName().equals("") ||
                readerToCreate.getName().length() > 50) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Reader reader = ReaderToCreate.convertToHibernateReader(readerToCreate);
        ReaderDao.saveReader(reader);
        return new ResponseEntity<Reader>(reader, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public ResponseEntity addAuthor(@RequestBody AuthorToCreate authorToCreate) {
        if (authorToCreate.getName().equals("") ||
                authorToCreate.getName().length() > 50) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Author author = AuthorToCreate.convertToHibernateAuthor(authorToCreate);
        AuthorDao.saveAuthor(author);
        return new ResponseEntity<Author>(author, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addReading", method = RequestMethod.POST,
            consumes = "application/json")
    @ResponseBody
    public ResponseEntity addReading(@RequestBody ReadingToCreate readingToCreate) {
        if (ReaderDao.getReader(readingToCreate.getReaderId()) == null ||
                BookDao.getBook(readingToCreate.getBookId()) == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        Reading reading = ReadingToCreate.convertToHibernateReading(readingToCreate);
        ReadingDao.saveReading(reading);
        return new ResponseEntity<Reading>(reading, HttpStatus.CREATED);
    }
}
