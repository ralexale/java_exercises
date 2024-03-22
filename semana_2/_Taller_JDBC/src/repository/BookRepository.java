package repository;

import entity.Book;

import java.util.List;

public interface BookRepository {

    public boolean insertBook(Book book);

    public boolean updateBook(Book book);

    public boolean deleteBook(int bookId);

    public List<Book> findAllBooks();

    public Book findBookById(int bookId);

    public Book findBookByName(String bookName);

    public Book findBookByAuthor(int authorId);
}
