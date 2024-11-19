package service.serviceImpl;

import database.Database;
import models.Book;
import models.Library;
import service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {


      @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : Database.libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().add(book);
                return book;
            }
        }
        System.out.println("not found!");
        return null;
    }




    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library library :Database.libraries ) {
            if (library.getId().equals(libraryId)) {
                return library.getBooks();
            }
        }
        return null;
    }


    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)) {
                for (Book book : library.getBooks()) {
                    if (book.getId().equals(bookId)) {
                        return book;
                    }
                }
            }
        }
        return null;
    }


    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)) {
                for (Book book : library.getBooks()) {
                    if (book.getId().equals(bookId)) {
                        library.getBooks().remove(book);
                        Database.books.remove(book);
                        return "Book deleted successfully.";
                    }
                }
            }
        }
        return "Book not found.";
    }


    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)) {
                library.getBooks().clear();
                return;
            }
        }
    }






}
