package model;

import database.ConfigDB;
import entity.Author;
import entity.Book;
import repository.AuthorRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AuthorModel implements AuthorRepository {


    @Override
    public boolean insertAuthor(Author author) {
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO author (name, nationality) VALUES (?,?);";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, author.getName());
            objPrepare.setString(2, author.getNationality());

            objPrepare.execute();

            objPrepare.close();

            JOptionPane.showMessageDialog(null, " Author insertion was successful.");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error adding Author " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return false;
    }

    @Override
    public boolean updateAuthor(Author author) {
        Connection objConnection = ConfigDB.openConnection();
        boolean isUpdated = false;
        try {
            String sql = "UPDATE author SET name = ? , nationality = ? WHERE id = ?;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            objPrepare.setString(1, author.getName());
            objPrepare.setString(2, author.getNationality());
            objPrepare.setInt(3, author.getId());

            int rowAffected = objPrepare.executeUpdate();

            if (rowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "The update was successful.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating author" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean deleteAuthor(int authorId) {
        Connection objConnection = ConfigDB.openConnection();
        boolean isDeletedAuthor = false;

        try {
            String sql = "DELETE FROM author WHERE id = ?;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            objPrepare.setInt(1, authorId);
            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeletedAuthor = true;
                JOptionPane.showMessageDialog(null, "The delete was successful.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting >>>" + e.getMessage());
        }


        ConfigDB.closeConnection();
        return isDeletedAuthor;
    }

    @Override
    public List<Author> findAllAuthors() {
        List<Author> authorsList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM author;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResultSet = objPrepare.executeQuery();

            while (objResultSet.next()) {
                Author author = new Author();

                author.setId(objResultSet.getInt("id"));
                author.setNationality(objResultSet.getString("nationality"));
                author.setName(objResultSet.getString("name"));

                authorsList.add(author);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot get the authors" + e.getMessage());
        }


        ConfigDB.closeConnection();

        return authorsList;
    }

    @Override
    public Author findAuthorById(int authorId) {
        Connection objConnection = ConfigDB.openConnection();
        Author author = null;
        try {
            String sql = "Select * from author WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, authorId);

            ResultSet objResultSet = objPrepare.executeQuery();

            while (objResultSet.next()) {
                author = new Author();

                author.setId(objResultSet.getInt("id"));
                author.setNationality(objResultSet.getString("nationality"));
                author.setName(objResultSet.getString("name"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot get the author" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return author;
    }

    @Override
    public List<Book> findBooksByAuthor(int authorId) {

        Connection objConnection = ConfigDB.openConnection();

        List<Book> booksList = new ArrayList<Book>();

        try {
            String sql = "SELECT book.id, book.title, book.year_publication, book.price FROM author \n" +
                    "INNER JOIN book ON \n" +
                    "author.id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, authorId);

            ResultSet objResultSet = objPrepare.executeQuery();

            while (objResultSet.next()) {
                Book book = new Book();

                book.setId(objResultSet.getInt("id"));
                book.setTitle(objResultSet.getString("title"));
                book.setYearOfPublication(objResultSet.getInt("year_publication"));
                book.setPrice(objResultSet.getInt("price"));
                book.setAuthorId(authorId);

                booksList.add(book);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error cannot get the books" + e.getMessage());
        }


        ConfigDB.closeConnection();

        return booksList;
    }

}
