package models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private Long id;
    private String name;
    private String address;
    private List<Book> books;
    private List<Reader> readers;


    public Library(Long id, String name, String address, List<Book> books, List<Reader> readers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = books;
        this.readers = readers;
    }


    public Library(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    @Override
    public String toString() {
        return "Library{ " +
                "ID=" + id +
                ",   name='" + name + '\'' +
                ",   address='" + address + '\'' +
                ",   books=" + books +
                ",  readers=" + readers +
                '}';
    }
}
