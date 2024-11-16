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
        for (Library library: Database.libraries){
            if(library.getId()==libraryId){
                library.getBooks().add(book);

                break;
            }
        }return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        Library library = Database.libraries.stream()
                .filter(l -> l.getId().equals(libraryId))
                .findFirst()
                .orElse(null);

        if (library != null) {
            return library.getBooks();
        }
        return new ArrayList<>();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        Library library = Database.libraries.stream()
                .filter(l -> l.getId().equals(libraryId))
                .findFirst()
                .orElse(null);

        if (library != null) {
            return library.getBooks().stream()
                    .filter(b -> b.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        Library library = Database.libraries.stream()
                .filter(l -> l.getId().equals(libraryId))
                .findFirst()
                .orElse(null);

        if (library != null) {
            Book book = library.getBooks().stream()
                    .filter(b -> b.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);

            if (book != null) {
                library.getBooks().remove(book);
                Database.books.remove(book);
                return "Book deleted successfully.";
            }
        }
        return "Book not found.";
    }


    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        if (library != null) {
            library.getBooks().clear();
        }
    }


}
