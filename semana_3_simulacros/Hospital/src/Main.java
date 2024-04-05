import javax.swing.JOptionPane;

import controllers.AppointmentController;
import controllers.DoctorController;
import controllers.PatientController;
import controllers.SpecialtyController;

public class Main {
    public static void main(String[] args) {
        SpecialtyController objSpecialtyController = new SpecialtyController();
        DoctorController objDoctorController = new DoctorController();
        PatientController objPatientController = new PatientController();
        AppointmentController objAppointmentController = new AppointmentController();

        String option = "";

        do {
            option = JOptionPane.showInputDialog("""
                    --- Hospital ---
                    1. Specialties
                    2. Doctors
                    3. Patients
                    4. Appointments
                    5. exit

                    choose and option:
                    """);

            switch (option) {
                case "1":
                    objSpecialtyController.showMenu();
                    break;
                case "2":
                    objDoctorController.showMenu();
                    break;
                case "3":
                    objPatientController.showMenu();
                    break;
                case "4":
                    objAppointmentController.showMenu();
                    break;

            }
        } while (!option.equals("5"));
    }
}