package controllers;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Appointment;
import models.AppointmentModel;

public class AppointmentController extends FormatTimeGenerator {

    AppointmentModel objAppointmentModel;
    DoctorController objDoctorController;
    PatientController objPatientController;

    public AppointmentController() {
        objDoctorController = new DoctorController();
        objPatientController = new PatientController();
        objAppointmentModel = new AppointmentModel();
    }

    public void saveAppointment() {
        Appointment objAppointment = new Appointment();

        int doctorId = objDoctorController.selectDoctorId();
        int patientId = objPatientController.selectPatientId();

        Date date = showDatePickerDialog();
        LocalTime time = showTimePickerDialog();

        String reason = JOptionPane.showInputDialog("insert the reason for the appointment");

        objAppointment.setDate(date);
        objAppointment.setTime_appointment(time);
        objAppointment.setReason(reason);

        this.objAppointmentModel.saveAppointment(objAppointment);
    }

    ;

    public void updateAppointment() {

    }

    ;

    public void deleteAppointment() {


    }

    ;

    public void findAppointmentById() {

    }

    ;

    public String findAll() {

        List<Appointment> appointments = objAppointmentModel.findAll();

        String menuList = "";

        for (Appointment appointmentTem : appointments) {
            menuList += appointmentTem.toString() + "\n";
        }

        return menuList;
    }

    ;

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
