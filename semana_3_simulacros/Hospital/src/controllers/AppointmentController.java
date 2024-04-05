package controllers;

import java.util.Date;

import javax.swing.JOptionPane;

import entities.Appointment;
import models.AppointmentModel;

public class AppointmentController extends DateGenerator {

    AppointmentModel objAppointmentModel;
    DoctorController objDoctorController;
    PatientController objPatientController;

    public AppointmentController() {
        objAppointmentModel = new AppointmentModel();
    }

    public void saveAppointment() {
        Appointment objAppointment = new Appointment();

        int doctorId =  objDoctorController.selectDoctorId();
        int  patientId = objPatientController.selectPatientId();

        Date  date = showDatePickerDialog();


    };

    public void updateAppointment() {

    };

    public void deleteAppointment() {

    };

    public void findAppointmentById() {

    };

    public String findAll() {

        return "";
    };

    public int selectAppointmentId() {
        return Integer.parseInt(JOptionPane.showInputDialog(this.findAll() + "\n" + "Insert the appointment id"));

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
                    this.saveAppointment();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, this.findAll());
                    break;
                case "3":
                    this.deleteAppointment();
                    break;
                case "4":
                    this.updateAppointment();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null,
                            this.objAppointmentModel.findAppointmentById(selectAppointmentId()).toString());
                    break;

            }
        } while (!option.equals("6"));
    }
}
