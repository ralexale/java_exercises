package controllers;

import java.util.List;

import javax.swing.JOptionPane;

import entities.Specialty;
import models.SpecialtyModel;

public class SpecialtyController {
    SpecialtyModel objSpecialtyModel;

    public SpecialtyController() {
        objSpecialtyModel = new SpecialtyModel();

    }

    public void saveSpecialty() {
        Specialty objSpecialty = new Specialty();

        String name = JOptionPane.showInputDialog("Insert specialty name: ");
        String description = JOptionPane.showInputDialog("Insert description specialty: ");

        objSpecialty.setDescription(description);
        objSpecialty.setName(name);

        objSpecialtyModel.saveSpecialty(objSpecialty);

    }

    void deleteSpecialty(int id) {

        objSpecialtyModel.deleteSpecialty(id);

    }

    void updateSpecialty(int id) {
        Specialty objSpecialty = new Specialty();

        String name = JOptionPane.showInputDialog("Insert specialty name: ");
        String description = JOptionPane.showInputDialog("Insert description specialty: ");

        objSpecialty.setDescription(description);
        objSpecialty.setName(name);
        objSpecialty.setId(id);

        objSpecialtyModel.updateSpecialty(objSpecialty);

    }

    public int selectSpecialtyId() {
        return Integer.parseInt(JOptionPane.showInputDialog(this.findAll() + "\n" + "Insert the specialty id"));

    }


    public Specialty findSpecialtyById(int id) {

        return objSpecialtyModel.findSpecialtyById(id);
    }


    public String findAll() {
        List<Specialty> specialties = objSpecialtyModel.findAll();
        String menuList = "";

        for (Specialty specialtyTemp : specialties) {
            menuList += specialtyTemp.toString() + "\n";
        }

        return menuList;
    }

    public void showMenu() {
        String option = "";

        do {
            option = JOptionPane.showInputDialog(null, """
                    1. Create a new Specialty
                    2. Show all Specialty
                    3. Delete an Specialty
                    4. Update an Specialty
                    5. show Specialty by id
                    6. Exit
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
                    this.deleteSpecialty(selectSpecialtyId());
                    break;
                case "4":
                    this.updateSpecialty(selectSpecialtyId());
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,
                            this.objSpecialtyModel.findSpecialtyById(selectSpecialtyId()).toString());
                    break;
            }
        } while (!option.equals("6"));
    }
}
