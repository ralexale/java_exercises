package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.ConfigurationDB;
import entities.Patient;
import repositories.PatientCRUDRepository;

public class PatientModel implements PatientCRUDRepository {
    Connection objConnection;

    @Override
    public Patient savePatient(Patient patient) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO paciente (nombre, apellidos, fecha_nacimiento,documento_identidad) VALUES (?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getLastName());
            statement.setDate(3, (Date) patient.getDateBirth());
            statement.setString(4, patient.getIdentityCard());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                patient.setId(rs.getInt(1));
            }
            System.out.println("Patient insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return patient;
    }

    @Override
    public void updatePatient(Patient patient) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE paciente SET nombre = ?, apellidos = ?, fecha_nacimiento = ?, documento_identidad = ? WHERE id_paciente = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getLastName());
            statement.setDate(3, (Date) patient.getDateBirth());
            statement.setString(4, patient.getIdentityCard());
            statement.setInt(5, patient.getId());

            statement.executeUpdate();

            System.out.println("Patient was update successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void deletePatient(int id) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "DELETE FROM paciente WHERE id = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Patient findPatientById(int id) {
        objConnection = ConfigurationDB.openConnection();
        Patient patient;
        try {
            String sql = "SELECT * FROM paciente WHERE id_paciente = " + id + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int patientId = resultSet.getInt("id_medico");
                String name = resultSet.getString("nombre");
                String lastName = resultSet.getString("apellidos");
                Date dateBirth = resultSet.getDate("fecha_nacimiento");
                String identity_car = resultSet.getString("documento_identidad");

                patient = new Patient(patientId, name, lastName, dateBirth, identity_car);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Patient> patients = new ArrayList<>();
        try {
            String sql = "SELECT * FROM paciente";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_medico");
                    String name = resultSet.getString("nombre");
                    String lastName = resultSet.getString("apellidos");
                    Date dateBirth = resultSet.getDate("fecha_nacimiento");
                    String identity_car = resultSet.getString("documento_identidad");

                    Patient patient = new Patient(id, name, lastName, dateBirth, identity_car);
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return patients;
    }
}
