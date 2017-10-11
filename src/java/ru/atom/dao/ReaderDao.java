package ru.atom.dao;

import org.hibernate.Session;
import ru.atom.hibernateentities.Reader;
import ru.atom.hibernateutil.HibernateUtil;

import java.util.List;

/**
 * Created by ilysko on 11.10.17.
 */
public class ReaderDao {
    public static void saveReader(Reader reader) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(reader);
        session.getTransaction().commit();
    }

    public static Reader getReader(Integer readerId) {
        Session session = HibernateUtil.getSession();
        List<Reader> result = session.createQuery("from ru.atom.hibernateentities.Reader where readerId =:readerId")
                .setParameter("readerId", readerId)
                .list();
        session.close();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
