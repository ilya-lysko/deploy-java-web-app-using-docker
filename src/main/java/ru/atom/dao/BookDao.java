package ru.atom.dao;

import org.hibernate.Session;
import ru.atom.hibernateentities.Book;
import ru.atom.hibernateutil.HibernateUtil;

import java.util.List;

/**
 * Created by ilysko on 11.10.17.
 */
public class BookDao {
    public static void saveBook(Book book) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
    }

    public static Book getBook(Integer bookId) {
        Session session = HibernateUtil.getSession();
        List<Book> result = session.createQuery("from Book where bookId =:bookId")
                .setParameter("bookId", bookId)
                .list();
        session.close();
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
