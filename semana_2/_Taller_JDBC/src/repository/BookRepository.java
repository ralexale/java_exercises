package repository;

import entity.Book;

import java.util.List;

public interface BookRepository {
    public void test(int test);
    public Book insertBook(Book book);

    public boolean updateBook(Book book);

    public boolean deleteBook(Book bookId);

    public List<Book> findAllBooks();

    public Book findBookById(int bookId);

    public Book findBookByName(String bookName);

    public Book findBookByAuthor(int authorId);
}
