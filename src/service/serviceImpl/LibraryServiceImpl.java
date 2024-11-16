package service.serviceImpl;

import database.Database;
import models.Library;
import service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        return libraries;
    }



    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }


    @Override
    public Library getLibraryById(Long id) {
        return Database.libraries.stream().filter(library -> library.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public Library updateLibrary(Long id, Library library) {
        Library existingLibrary = getLibraryById(id);
        if (existingLibrary != null) {
            Database.libraries.remove(existingLibrary);
            Database.libraries.add(library);
            return library;
        }
        return null;
    }



    @Override
    public String deleteLibrary(Long id) {
        Library library = getLibraryById(id);
        if (library != null) {
            Database.libraries.remove(library);
            return "Library deleted successfully.";
        }
        return "Library not found.";
    }

}
