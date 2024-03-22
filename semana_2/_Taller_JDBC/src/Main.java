import controller.AuthorController;
import controller.BookController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AuthorController objAuthorController = new AuthorController();
        BookController objBookController = new BookController();

        String option = "";

        do {
            option = JOptionPane.showInputDialog("""
                    --- Library ---
                    1. authors
                    2. books
                    3. exit
                                        
                    choose and option:
                    """);


            switch (option) {
                case "1":
                    objAuthorController.showMenu();
                    break;


            }
        } while (option != "3");


    }

}