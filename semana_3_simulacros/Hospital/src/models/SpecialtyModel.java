package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConfigurationDB;
import entities.Specialty;
import repositories.SpecialtyCRUDRepository;

public class SpecialtyModel implements SpecialtyCRUDRepository {
    Connection objConnection;

    @Override
    public Specialty saveSpecialty(Specialty specialty) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO especialidad (nombre, descripcion) VALUES (?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, specialty.getName());
            statement.setString(2, specialty.getDescription());
            ;

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                specialty.setId(rs.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "specialty insertion completed successfully");

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return specialty;
    }

    @Override
    public void deleteSpecialty(int id) {
        objConnection = ConfigurationDB.openConnection();

        try {
            String sql = "DELETE FROM especialidad WHERE id_especialidad = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.execute();
            System.out.println("The row was deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSpecialty(Specialty specialty) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE especialidad SET nombre = ?, descripcion = ? WHERE id_especialidad = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
            statement.setString(1, specialty.getName());
            statement.setString(2, specialty.getDescription());
            ;
            statement.setInt(3, specialty.getId());

            statement.executeUpdate();

            System.out.println("Specialty was update successfully");
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public Specialty findSpecialtyById(int id) {
        objConnection = ConfigurationDB.openConnection();
        Specialty specialty;
        try {
            String sql = "SELECT * FROM especialidad WHERE id_especialidad = " + id + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int idSpecialty = resultSet.getInt("id_especialidad");
                String name = resultSet.getString("nombre");
                String description = resultSet.getString("descripcion");

                specialty = new Specialty(idSpecialty, name, description);
            }
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return specialty;
    }

    @Override
    public Specialty findSpecialtyByName(String name) {
        objConnection = ConfigurationDB.openConnection();
        Specialty specialty;
        try {
            String sql = "SELECT * FROM especialidad WHERE nombre = " + name + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int idSpecialty = resultSet.getInt("id_especialidad");
                String specialtyName = resultSet.getString("nombre");
                String description = resultSet.getString("descripcion");

                specialty = new Specialty(idSpecialty, specialtyName, description);
            }
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return specialty;
    }

    @Override
    public List<Specialty> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Specialty> specialties = new ArrayList<>();
        try {
            String sql = "SELECT * FROM especialidad";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_especialidad");
                    String name = resultSet.getString("nombre");
                    String description = resultSet.getString("descripcion");

                    Specialty specialty = new Specialty(id, name, description);
                    specialties.add(specialty);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return specialties;
    }
}
