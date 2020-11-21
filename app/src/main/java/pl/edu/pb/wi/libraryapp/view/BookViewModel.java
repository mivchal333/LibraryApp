package pl.edu.pb.wi.libraryapp.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pl.edu.pb.wi.libraryapp.database.entity.Book;
import pl.edu.pb.wi.libraryapp.database.repository.BookRepository;

public class BookViewModel extends AndroidViewModel {
    private final BookRepository bookRepository;
    private final LiveData<List<Book>> books;

    public BookViewModel(@NonNull Application application) {
        super(application);
        bookRepository = new BookRepository(application);
        books = bookRepository.findAllBooks();
    }

    public LiveData<List<Book>> findAll() {
        return books;
    }

    public void insert(Book book) {
        bookRepository.insert(book);
    }

    public void update(Book book) {
        bookRepository.update(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }
}

