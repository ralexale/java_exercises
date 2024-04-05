package controllers;

import java.util.List;

import javax.swing.*;
import java.awt.*;

import java.util.Date;

import entities.Patient;
import models.PatientModel;

public class PatientController {
    PatientModel objPatientModel;

    public PatientController() {
        objPatientModel = new PatientModel();
    }

    public void savePatient() {
        Patient objPatient = new Patient();

        String name = JOptionPane.showInputDialog("Insert patient name: ");
        String description = JOptionPane.showInputDialog("Insert patient lastname: ");
        Date dateBirth = showDatePickerDialog();
        String identityCard = JOptionPane.showInputDialog("Insert patient identityCard lastname: ");

        objPatient.setName(description);
        objPatient.setLastName(name);
        objPatient.setDateBirth(dateBirth);
        objPatient.setIdentityCard(identityCard);

        objPatientModel.savePatient(objPatient);
    };

    public static Date showDatePickerDialog() {
        // Crear un JSpinner para seleccionar la fecha
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy/MM/dd"));

        // Crear el panel que contiene el JSpinner
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(spinner, BorderLayout.CENTER);

        // Mostrar el JOptionPane con el JSpinner
        int result = JOptionPane.showConfirmDialog(null, panel, "Select a patient birthdate",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Obtener la fecha seleccionada
            Date selectedDate = (Date) spinner.getValue();
            return selectedDate;
        }
        return null; // Retornar null si el usuario cancela la selección
    }

    public void updatePatient(int id) {
        Patient objPatient = new Patient();

        String name = JOptionPane.showInputDialog("Insert patient name: ");
        String description = JOptionPane.showInputDialog("Insert patient lastname: ");
        Date dateBirth = showDatePickerDialog();
        String identityCard = JOptionPane.showInputDialog("Insert patient identityCard lastname: ");

        objPatient.setName(description);
        objPatient.setLastName(name);
        objPatient.setDateBirth(dateBirth);
        objPatient.setIdentityCard(identityCard);
        objPatient.setId(id);

        this.objPatientModel.updatePatient(objPatient);
    };

    public void deletePatient(int id) {
        this.objPatientModel.deletePatient(id);
    };

    public void findPatientById() {

    };

    public String findAll() {
        List<Patient> patients = objPatientModel.findAll();
        String menuList = "";

        for (Patient patientTemp : patients) {
            menuList += patientTemp.toString() + "\n";
        }

        return menuList;
    };

    public int selectPatientId() {
        return Integer.parseInt(JOptionPane.showInputDialog(this.findAll() + "\n" + "Insert the patient id"));

    }

    public void showMenu() {
        String option = "";

        do {
            option = JOptionPane.showInputDialog(null, """
                    1. Create a new Patient
                    2. Show all Patient
                    3. Delete an Patient
                    4. Update an Patient
                    5. show Patient by id
                    6. Exit
                    choose and option:
                    """);

            switch (option) {
                case "1":
                    this.savePatient();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, this.findAll());
                    break;
                case "3":
                    this.deletePatient(selectPatientId());
                    break;
                case "4":
                    this.updatePatient(selectPatientId());
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,
                            this.objPatientModel.findPatientById(selectPatientId()).toString());
                    break;
            }
        } while (!option.equals("6"));
    }

}
