package models;

import java.util.ArrayList;
import java.util.List;

import database.ConfigurationDB;

import entities.Doctor;

import repositories.DoctorCRUDRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorModel implements DoctorCRUDRepository {
    Connection objConnection;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO medico (nombre, apellidos, id_especialidad) VALUES (?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getLastName());
            statement.setInt(3, doctor.getspecialtyId());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                doctor.setId(rs.getInt(1));
            }
            System.out.println("Doctor insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return doctor;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE medico SET nombre = ?, apellidos = ?, id_especialidad = ? WHERE id_medico = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, doctor.getName());
            statement.setString(2, doctor.getLastName());
            statement.setInt(3, doctor.getspecialtyId());
            statement.setInt(4, doctor.getId());

            statement.executeUpdate();

            System.out.println("Doctor was update successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void deleteDoctor(int id) {
        objConnection = ConfigurationDB.openConnection();

        try {
            String sql = "DELETE FROM medico WHERE id_medico = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public Doctor findDoctorById(int id) {
        objConnection = ConfigurationDB.openConnection();
        Doctor doctor;
        try {
            String sql = "SELECT * FROM medico WHERE id_medico = " + id + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int idDoctor = resultSet.getInt("id_medico");
                int idSpecialty = resultSet.getInt("id_especialidad");
                String name = resultSet.getString("nombre");
                String lastName = resultSet.getString("apellidos");

                doctor = new Doctor(idDoctor, name, lastName, idSpecialty);
            }
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return doctor;
    }

    @Override
    public List<Doctor> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Doctor> doctors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medico";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_medico");
                    int idSpecialty = resultSet.getInt("id_especialidad");
                    String name = resultSet.getString("nombre");
                    String lastName = resultSet.getString("apellidos");

                    Doctor doctor = new Doctor(id, name, lastName, idSpecialty);
                    doctors.add(doctor);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return doctors;
    }
}
