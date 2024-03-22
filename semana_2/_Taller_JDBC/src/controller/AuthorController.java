package controller;

import entity.Author;
import entity.Book;
import model.AuthorModel;

import javax.swing.*;
import java.util.List;

public class AuthorController {
    AuthorModel objAuthorModel;


    public AuthorController() {
        objAuthorModel = new AuthorModel();
    }

    public void insertAuthor() {
        Author objAuthor = new Author();

        String name = JOptionPane.showInputDialog("Insert author name: ");
        String nationality = JOptionPane.showInputDialog("Insert author nationality: ");

        objAuthor.setName(name);
        objAuthor.setNationality(nationality);

        objAuthorModel.insertAuthor(objAuthor);
    }

    public String getAllAuthors() {
        List<Author> listAuthors = this.objAuthorModel.findAllAuthors();

        String menuList = "List of authors \n";

        for (Author authorTemp : listAuthors) {
            menuList += authorTemp.toString() + "\n";
        }

        return menuList;
    }

    public void deleteAuthorById(int authorId) {

        this.objAuthorModel.deleteAuthor(authorId);
    }

    public void updateAuthor(int authorId) {
        Author objAuthor = this.objAuthorModel.findAuthorById(authorId);

        String name = JOptionPane.showInputDialog("Insert author name: ");
        String nationality = JOptionPane.showInputDialog("Insert author nationality: ");

        objAuthor.setName(name);
        objAuthor.setNationality(nationality);

        this.objAuthorModel.updateAuthor(objAuthor);
    }

    public String showAuthorBooks(int authorId) {
        List<Book> books = this.objAuthorModel.findBooksByAuthor(authorId);
        String booksString = "";


        for (Book objBookTemp : books) {
            booksString += objBookTemp.toString();
        }

        return booksString;
    }

    public void showMenu() {
        String option = "";

        do {
            option = JOptionPane.showInputDialog(null, """
                    1. Create a new author
                    2. Show all authors
                    3. Delete an author
                    4. Update an author
                    5. show author by id
                    6. show author books
                    7. Exit      
                    choose and option:   
                    """);

            switch (option) {
                case "1":
                    this.insertAuthor();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, this.getAllAuthors());
                    break;
                case "3":
                    int authorDeleteId = Integer.parseInt(JOptionPane.showInputDialog(this.getAllAuthors() + "\n" + "Insert the author id"));
                    this.deleteAuthorById(authorDeleteId);
                    break;
                case "4":
                    int authorUpdateId = Integer.parseInt(JOptionPane.showInputDialog(this.getAllAuthors() + "\n" + "Insert the author id"));
                    this.updateAuthor(authorUpdateId);
                    break;
                case "5":
                    int authorId = Integer.parseInt(JOptionPane.showInputDialog(this.getAllAuthors() + "\n" + "Insert the author id"));
                    JOptionPane.showMessageDialog(null, this.objAuthorModel.findAuthorById(authorId).toString());
                    break;
                case "6":
                    int authorIdBook = Integer.parseInt(JOptionPane.showInputDialog(this.getAllAuthors() + "\n" + "Insert the author id"));
                    JOptionPane.showMessageDialog(null, this.showAuthorBooks(authorIdBook));
            }
        } while (option != "7");
    }
}
