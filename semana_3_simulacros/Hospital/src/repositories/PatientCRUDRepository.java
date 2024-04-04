package repositories;

import java.util.List;

import entities.Patient;

public interface PatientCRUDRepository {
    Patient savePatient(Patient patient);

    void updatePatient(Patient patient);

    void deletePatient(int id);

    Patient findPatientById(int id);

    List<Patient> findAll();
}
