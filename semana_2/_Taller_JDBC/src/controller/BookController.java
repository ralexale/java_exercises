package controller;

import entity.Author;
import entity.Book;
import model.BookModel;

import javax.swing.*;
import java.util.List;

public class BookController {
    BookModel objBookModel;
    AuthorController objAuthorController;

    public BookController() {
        objAuthorController = new AuthorController();
        objBookModel = new BookModel();
    }

    public void createBook() {
        Book objBook = new Book();
        int authorId = objAuthorController.selectAuthorById();

        String title = JOptionPane.showInputDialog("Insert the book title");
        int yearOfPublication = Integer.parseInt(JOptionPane.showInputDialog("Insert the year of publication"));
        double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Insert the price of the book"));

        objBook.setTitle(title);
        objBook.setYearOfPublication(yearOfPublication);
        objBook.setPrice(price);
        objBook.setAuthorId(authorId);

        objBookModel.insertBook(objBook);
    }

    public String getAllBooks() {
        List<Book> booksList = this.objBookModel.findAllBooks();

        String menuList = "List of Books \n";

        for (Book bookTemp : booksList) {
            menuList += bookTemp.toString() + "\n";
        }

        return menuList;
    }

    public void deleteBookById(int bookId) {
        this.objBookModel.deleteBook(bookId);
    }

    public int selectBookById() {
        return Integer.parseInt(JOptionPane.showInputDialog(this.getAllBooks() + "\n" + "Insert the book id"));
    }

    public void updateBook(int bookId) {
        Book objBook = this.objBookModel.findBookById(bookId);

        String title = JOptionPane.showInputDialog("Insert the book title");
        int yearOfPublication = Integer.parseInt(JOptionPane.showInputDialog("Insert the year of publication"));
        double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Insert the price of the book"));
        int authorId = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the author id of the book"));

        objBook.setTitle(title);
        objBook.setYearOfPublication(yearOfPublication);
        objBook.setPrice(price);
        objBook.setAuthorId(authorId);

        this.objBookModel.updateBook(objBook);
    }


    public void showMenu() {
        String option = "";

        do {
            option = JOptionPane.showInputDialog(null, """
                    1. Create a new book
                    2. Show all books
                    3. Delete a book
                    4. Update a book
                    5. Exit      
                    choose and option:   
                    """);

            switch (option) {
                case "1":
                    this.createBook();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, getAllBooks());
                    break;
                case "3":
                    this.deleteBookById(this.selectBookById());
                    break;
                case "4":
                    this.updateBook(this.selectBookById());
                    break;
            }
        } while (!option.equals("5"));
    }


}
