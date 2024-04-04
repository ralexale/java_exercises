package repositories;

import java.util.List;

import entities.Appointment;

public interface AppointmentCRUDRepository {
    Appointment saveAppointment(Appointment appointment);

    void updateAppointment(Appointment appointment);

    void deleteAppointment(int id);

    Appointment findAppointmentById(int id);

    List<Appointment> findAll();
}
