package repository;

import entity.Author;
import entity.Book;

import java.util.List;

public interface AuthorRepository {

    public boolean insertAuthor(Author author);

    public boolean updateAuthor(Author author);

    public boolean deleteAuthor(int authorId);

    public List<Author> findAllAuthors();

    public Author findAuthorById(int authorId);

    public List<Book> findBooksByAuthor(int authorId);
}
