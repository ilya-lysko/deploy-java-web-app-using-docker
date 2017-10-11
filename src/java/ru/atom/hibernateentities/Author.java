package ru.atom.hibernateentities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
@Entity
@Table(name = "author", schema = "learndeploywithdocker", catalog = "")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;

    public Integer getAuthorId() {
        return authorId;
    }

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
