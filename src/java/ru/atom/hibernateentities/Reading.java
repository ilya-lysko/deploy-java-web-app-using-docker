package ru.atom.hibernateentities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ilysko on 11.10.17.
 */
@Entity
@Table(name = "reading", schema = "learndeploywithdocker", catalog = "")
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reading_id")
    private Integer readingId;

    public Integer getReadingId() {
        return readingId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader", nullable = false)
    private Reader reader;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book", nullable = false)
    private Book book;

    public void setBook(Book book) {
        this.book= book;
    }

    public Book getBook() {
        return book;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    public Date getEndDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.startDate = endDate;
    }
}
