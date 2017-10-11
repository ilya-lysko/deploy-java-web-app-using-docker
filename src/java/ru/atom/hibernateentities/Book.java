package ru.atom.hibernateentities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
@Entity
@Table(name = "book", schema = "learndeploywithdocker", catalog = "")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    public Integer getBookId() {
        return bookId;
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
    @Column(name = "write_date", nullable = false)
    private Date writeDate;

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate= writeDate;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author", nullable = false)
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Basic
    @Column(name = "pages_count", nullable = false)
    private Integer pagesCount;

    public Integer getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(Integer pagesCount) {
        this.pagesCount = pagesCount;
    }

}
