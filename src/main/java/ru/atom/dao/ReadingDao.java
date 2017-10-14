package ru.atom.dao;

import org.hibernate.Session;
import org.hibernate.cfg.SecondaryTableSecondPass;
import ru.atom.hibernateentities.Reading;
import ru.atom.hibernateutil.HibernateUtil;

import java.util.List;

/**
 * Created by ilysko on 11.10.17.
 */
public class ReadingDao {
    public static void saveReading(Reading reading) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(reading);
        session.getTransaction().commit();
    }

    public static Reading getReading(Integer readingId) {
        Session session = HibernateUtil.getSession();
        List<Reading> result = session.createQuery("from Reading where readingId =:readingId")
                .setParameter("readingId", readingId)
                .list();
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }
}
