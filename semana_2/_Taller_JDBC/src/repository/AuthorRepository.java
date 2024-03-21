package repository;

import entity.Author;

import java.util.List;

public interface AuthorRepository {
    public void test(int test);
    public boolean insertAuthor(Author author);

    public boolean updateAuthor(Author author);

    public boolean deleteAuthor(int authorId);

    public List<Author> findAllAuthors();

    public Author findAuthorById(int authorId);
}
