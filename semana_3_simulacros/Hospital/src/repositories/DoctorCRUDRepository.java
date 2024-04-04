package repositories;

import java.util.List;

import entities.Doctor;

public interface DoctorCRUDRepository {
    Doctor saveDoctor(Doctor doctor);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(int id);

    Doctor findDoctorById(int id);

    List<Doctor> findAll();
}
