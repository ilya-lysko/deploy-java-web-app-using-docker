package ru.atom.hibernateentities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
@Entity
@Table(name = "reader", schema = "learndeploywithdocker", catalog = "")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reader_id")
    private Integer readerId;

    public Integer getReaderId() {
        return readerId;
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
