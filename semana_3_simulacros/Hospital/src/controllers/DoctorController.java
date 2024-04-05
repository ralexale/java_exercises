package controllers;

import java.util.List;

import entities.Doctor;

import models.DoctorModel;

import javax.swing.*;

public class DoctorController {
    private DoctorModel objDoctorModel;
    private SpecialtyController objSpecialtyController;

    public DoctorController() {
        objDoctorModel = new DoctorModel();
        objSpecialtyController = new SpecialtyController();
    }

    public void saveDoctor() {
        Doctor objDoctor = new Doctor();

        String name = JOptionPane.showInputDialog("Insert doctor name: ");
        String description = JOptionPane.showInputDialog("Insert doctor lastname: ");

        objDoctor.setName(description);
        objDoctor.setLastName(name);

        objDoctor.setspecialtyId(this.objSpecialtyController.selectSpecialtyId());

        objDoctorModel.saveDoctor(objDoctor);
    };

    public void updateDoctor(int id) {
        Doctor objDoctor = new Doctor();

        String name = JOptionPane.showInputDialog("Insert doctor name: ");
        String description = JOptionPane.showInputDialog("Insert doctor lastname: ");

        objDoctor.setName(description);
        objDoctor.setLastName(name);
        objDoctor.setId(id);

        objDoctor.setspecialtyId(this.objSpecialtyController.selectSpecialtyId());

        objDoctorModel.updateDoctor(objDoctor);
    };

    public void deleteDoctor(int id) {
        objDoctorModel.deleteDoctor(id);
    };

    public void findDoctorById() {

    };

    public String findAll() {
        List<Doctor> doctors = objDoctorModel.findAll();
        String menuList = "";

        for (Doctor doctorTemp : doctors) {
            menuList += doctorTemp.toString() + "\n";
        }

        return menuList;
    };

    public int selectDoctorId() {
        return Integer.parseInt(JOptionPane.showInputDialog(this.findAll() + "\n" + "Insert the doctor id"));

    }

    public void showMenu() {
        String option = "";

        do {
            option = JOptionPane.showInputDialog(null, """
                    1. Create a new Doctor
                    2. Show all Doctor
                    3. Delete an Doctor
                    4. Update an Doctor
                    5. show Doctor by id
                    6. Exit
                    choose and option:
                    """);

            switch (option) {
                case "1":
                    this.saveDoctor();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, this.findAll());
                    break;
                case "3":
                    this.deleteDoctor(selectDoctorId());
                    break;
                case "4":
                    this.updateDoctor(selectDoctorId());
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,
                            this.objDoctorModel.findDoctorById(selectDoctorId()).toString());
                    break;

            }
        } while (!option.equals("6"));
    }

}
