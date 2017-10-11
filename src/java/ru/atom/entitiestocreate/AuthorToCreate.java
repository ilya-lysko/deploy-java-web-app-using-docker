package ru.atom.entitiestocreate;

import ru.atom.hibernateentities.Author;

import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
public class AuthorToCreate {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Author convertToHibernateAuthor(AuthorToCreate authorToCreate) {
        Author author = new Author();
        author.setName(authorToCreate.getName());
        author.setBirthDate(new Date());
        return author;
    }
}
