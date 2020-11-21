package pl.edu.pb.wi.libraryapp.database.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;

import java.util.List;

import pl.edu.pb.wi.libraryapp.database.dao.BookDao;
import pl.edu.pb.wi.libraryapp.database.BookDatabase;
import pl.edu.pb.wi.libraryapp.database.entity.Book;

public class BookRepository {
    private BookDao bookDao;
    private LiveData<List<Book>> books;

    public BookRepository(Application application) {
        BookDatabase database = BookDatabase.getDatabase(application);
        BookDao bookDao = database.bookDao();
        books = bookDao.findAll();
    }

    public LiveData<List<Book>> findAllBooks() {
        return books;
    }

    void insert(Book book) {
        BookDatabase.databaseWriterExecutor.execute(() -> {
            bookDao.insert(book);
        });
    }

    void update(Book book) {
        BookDatabase.databaseWriterExecutor.execute(() -> {
            bookDao.update(book);
        });
    }
    
}
