package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Specialty;
import models.SpecialtyModel;

public class SpecialityController {
    SpecialtyModel objSpecialtyModel;

    public SpecialityController() {
        objSpecialtyModel = new SpecialtyModel();

    }

    public void saveSpecialty() {
        Specialty objSpecialty = new Specialty();

        String name = JOptionPane.showInputDialog("Insert specialty name: ");
        String description = JOptionPane.showInputDialog("Insert description specialty: ");

        objSpecialty.setDescription(description);
        objSpecialty.setName(name);

        objSpecialtyModel.saveSpecialty(objSpecialty);

    };

    void deleteSpecialty(int id) {

        objSpecialtyModel.deleteSpecialty(id);

    };

    void updateSpecialty(int id) {
        Specialty objSpecialty = new Specialty();

        String name = JOptionPane.showInputDialog("Insert specialty name: ");
        String description = JOptionPane.showInputDialog("Insert description specialty: ");

        objSpecialty.setDescription(description);
        objSpecialty.setName(name);
        objSpecialty.setId(id);

        objSpecialtyModel.updateSpecialty(objSpecialty);

    };

    public Specialty findSpecialtyById(int id) {

        return objSpecialtyModel.findSpecialtyById(id);
    };

    public Specialty findSpecialtyByName(String name) {

        return objSpecialtyModel.findSpecialtyByName(name);

    };

    public String findAll() {
        List<Specialty> specialties = objSpecialtyModel.findAll();
        String menuList = "";

        specialties.stream().map( specialty -> 
            menuList += specialty.toString() + "\n"
        ) ;

        return menuList;
    };

    public void showMenu() {
        String option = "";

        do {
            option = JOptionPane.showInputDialog(null, """
                    1. Create a new Specialty
                    2. Show all Specialty
                    3. Delete an Specialty
                    4. Update an Specialty
                    5. show Specialty by id
                    6. show Specialty by name
                    7. Exit
                    choose and option:
                    """);

            switch (option) {
                case "1":
                    this.saveSpecialty();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, this.findAll());
                    break;
                case "3":
                    this.deleteAuthorById(selectAuthorById());
                    break;
                case "4":
                    this.updateAuthor(selectAuthorById());
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,
                            this.objAuthorModel.findAuthorById(selectAuthorById()).toString());
                    break;
                case "6":

                    JOptionPane.showMessageDialog(null, this.showAuthorBooks(selectAuthorById()));
            }
        } while (!option.equals("7"));
    }
}}
