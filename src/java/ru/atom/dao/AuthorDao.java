package ru.atom.dao;

import org.hibernate.Session;
import ru.atom.hibernateentities.Author;
import ru.atom.hibernateutil.HibernateUtil;

import java.util.List;

/**
 * Created by ilysko on 11.10.17.
 */
public class AuthorDao {
    public static void saveAuthor(Author author) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }

    public static Author getAuhtor(Integer authorId) {
        Session session = HibernateUtil.getSession();
        List<Author> result = session.createQuery("from Author where authorId =:authorId")
                .setParameter("authorId", authorId)
                .list();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
