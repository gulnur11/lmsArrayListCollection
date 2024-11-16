package service.serviceImpl;

import database.Database;
import models.Library;
import models.Reader;
import service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {

    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        return Database.readers.stream()
                .filter(reader -> reader.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        Reader existingReader = getReaderById(id);
        if (existingReader != null) {
            Database.readers.remove(existingReader);
            Database.readers.add(reader);
            return reader;
        }
        return null;
    }


    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        Reader reader = getReaderById(readerId);
        Library library = new LibraryServiceImpl().getLibraryById(libraryId);
        if (reader != null && library != null) {
            library.getReaders().add(reader);
        }
    }
}
