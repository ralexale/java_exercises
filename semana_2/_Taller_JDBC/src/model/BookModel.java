package model;

import entity.Book;
import repository.BookRepository;

import java.util.List;

public class BookModel implements BookRepository {

    @Override
    public Book insertBook(Book book) {
        return null;
    }

    @Override
    public boolean updateBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBook(Book bookId) {
        return false;
    }

    @Override
    public List<Book> findAllBooks() {
        return null;
    }

    @Override
    public Book findBookById(int bookId) {
        return null;
    }

    @Override
    public Book findBookByName(String bookName) {
        return null;
    }

    @Override
    public Book findBookByAuthor(int authorId) {
        return null;
    }
}
