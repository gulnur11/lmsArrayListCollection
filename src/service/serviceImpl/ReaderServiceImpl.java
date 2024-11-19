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
        for (Reader reader : Database.readers) {
            if (reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
    }


    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader r : Database.readers) {
            if (r.getId().equals(id)) {
                Database.readers.remove(r);
                Database.readers.add(reader);
                return reader;
            }
        }
        return null;
    }




 @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Library library: Database.libraries ) {
            if (library.getId() == libraryId){
                for (Reader reader: Database.readers) {
                    if (reader.getId() == readerId){
                        library.getReaders().add(reader);
                    }}}}}



}
