package repositories;

import java.util.List;

import entities.Specialty;

public interface SpecialtyCRUDRepository {
    Specialty saveSpecialty(Specialty specialty);

    void deleteSpecialty(int id);

    void updateSpecialty(Specialty specialty);

    Specialty findSpecialtyById(int id);

    Specialty findSpecialtyByName(String name);

    List<Specialty> findAll();

}
