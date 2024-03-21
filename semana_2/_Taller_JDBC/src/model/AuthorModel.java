package model;

import entity.Author;
import repository.AuthorRepository;

import java.util.List;

public class AuthorModel implements AuthorRepository {


    @Override
    public boolean insertAuthor(Author author) {
        return false;
    }

    @Override
    public boolean updateAuthor(Author author) {
        return false;
    }

    @Override
    public boolean deleteAuthor(int authorId) {
        return false;
    }

    @Override
    public List<Author> findAllAuthors() {
        return null;
    }

    @Override
    public Author findAuthorById(int authorId) {
        return null;
    }
}
