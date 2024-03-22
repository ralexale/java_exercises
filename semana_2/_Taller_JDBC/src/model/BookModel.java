package model;

import database.ConfigDB;
import entity.Book;
import repository.BookRepository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements BookRepository {

    @Override
    public boolean insertBook(Book book) {
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO book (title,year_publication,author_id,price) VALUES (?, ? , ? ,?);";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            objPrepare.setString(1, book.getTitle());
            objPrepare.setInt(2, book.getYearOfPublication());
            objPrepare.setInt(3, book.getAuthorId());
            objPrepare.setDouble(4, book.getPrice());

            objPrepare.execute();
            objPrepare.close();

            JOptionPane.showMessageDialog(null, " Book insertion was successful.");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error creating book" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return false;
    }

    @Override
    public boolean updateBook(int bookId) {
        return false;
    }

    @Override
    public boolean deleteBook(int bookId) {
        Connection objConnection = ConfigDB.openConnection();
        boolean isDeleteBook = false;
        try {
            String sql = "DELETE * FROM book WHERE id = ?;";
            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            objPrepare.setInt(1, bookId);
            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleteBook = true;
                JOptionPane.showMessageDialog(null, "The delete was successful.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error deleting book" + e.getMessage());
        }


        ConfigDB.closeConnection();
        return isDeleteBook;
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> booksList = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM book;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);
            ResultSet objResultSet = objPrepare.executeQuery();

            while (objResultSet.next()) {
                Book objBook = new Book();

                objBook.setAuthorId(objResultSet.getInt("author_id"));
                objBook.setTitle(objResultSet.getString("title"));
                objBook.setPrice(objResultSet.getDouble("price"));
                objBook.setYearOfPublication(objResultSet.getInt("year_publication"));
                objBook.setId(objResultSet.getInt("id"));

                booksList.add(objBook);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        ConfigDB.closeConnection();
        return booksList;
    }

    @Override
    public Book findBookById(int bookId) {
        Connection objConnection = ConfigDB.openConnection();

        try{
            String sql = "SELECT * FROM book WHERE id = ?;";

            PreparedStatement objPrepare = (PreparedStatement) objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();



        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Cannot get the book" + e.getMessage());
        }

        ConfigDB.closeConnection();
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
