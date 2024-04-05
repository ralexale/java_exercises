package entities;

import java.time.LocalTime;
import java.util.Date;

public class Appointment {
    private int id;
    private int doctorId;
    private int patientId;
    private Date date;
    private LocalTime time_appointment;
    private String reason;
    private Doctor doctor;
    private Patient patient;

    public Appointment() {
    }

    public int getId() {
        return id;
    }

    public void setTime_appointment(LocalTime time_appointment) {
        this.time_appointment = time_appointment;
    }

    public LocalTime getTime_appointment() {
        return time_appointment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", date=" + date +
                ", time=" + time_appointment +
                ", reason='" + reason + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
