package ru.atom.entitiestocreate;

import ru.atom.hibernateentities.Reader;

import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
public class ReaderToCreate {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Reader convertToHibernateReader(ReaderToCreate readerToCreate) {
        Reader reader = new Reader();
        reader.setName(readerToCreate.getName());
        reader.setBirthDate(new Date());
        return reader;
    }
}
