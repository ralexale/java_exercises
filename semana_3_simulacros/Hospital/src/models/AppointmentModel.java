package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.ConfigurationDB;
import entities.Appointment;
import repositories.AppointmentCRUDRepository;

public class AppointmentModel implements AppointmentCRUDRepository {
    Connection objConnection;

    @Override
    public Appointment saveAppointment(Appointment appointment) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "INSERT INTO cita (id_paciente, id_medico, fecha_cita,hora,motivo) VALUES (?,?,?,?,?);";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());

            java.sql.Date sqlDate = new java.sql.Date(appointment.getDate().getTime());
            statement.setDate(3, sqlDate);

            java.sql.Time sqlTime = new java.sql.Time(appointment.getTime_appointment().getHour());
            statement.setTime(4,  sqlTime);
            ;
            statement.setString(5, appointment.getReason());

            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();

            while (rs.next()) {
                appointment.setId(rs.getInt(1));
            }
            System.out.println("Appointment insertion completed successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return appointment;
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "UPDATE cita SET id_paciente = ?, id_medico = ?, fecha_cita = ?, hora = ?, motivo = ? WHERE id_cita = ?;";
            PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);

            statement.setInt(1, appointment.getPatientId());
            statement.setInt(2, appointment.getDoctorId());

            java.sql.Date sqlDate = new java.sql.Date(appointment.getDate().getTime());
            statement.setDate(3, sqlDate);

            java.sql.Time sqlTime = new java.sql.Time(appointment.getTime_appointment().getTime());
            statement.setTime(4,  sqlTime);

            statement.setString(5, appointment.getReason());
            statement.setInt(6, appointment.getId());

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Appointment was update successfully", sql, 0);

        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
    }

    @Override
    public void deleteAppointment(int id) {
        objConnection = ConfigurationDB.openConnection();
        try {
            String sql = "DELETE FROM cita WHERE id_cita = ?;";
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
    public Appointment findAppointmentById(int id) {
        objConnection = ConfigurationDB.openConnection();
        Appointment appointment;
        try {
            String sql = "SELECT * FROM cita WHERE id_cita = " + id + ";";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {

                resultSet.next();
                int idDoctor = resultSet.getInt("id_medico");
                int idDate = resultSet.getInt("id_cita");
                int idPatient = resultSet.getInt("id_paciente");
                Date date = resultSet.getDate("fecha_cita");
                Date time = resultSet.getDate("hora");
                String reason = resultSet.getString("motivo");

                appointment = new Appointment(idDate, idDoctor, idPatient, date, time, reason);
            }
        } catch (Exception e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException(e);
        }
        ConfigurationDB.closeConnection();
        return appointment;
    }

    @Override
    public List<Appointment> findAll() {
        objConnection = ConfigurationDB.openConnection();
        List<Appointment> appointments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cita";
            try (PreparedStatement statement = (PreparedStatement) objConnection.prepareStatement(sql);
                    ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idDoctor = resultSet.getInt("id_medico");
                    int idDate = resultSet.getInt("id_cita");
                    int idPatient = resultSet.getInt("id_paciente");
                    Date date = resultSet.getDate("fecha_cita");
                    Date time = resultSet.getDate("hora");
                    String reason = resultSet.getString("motivo");

                    Appointment appointment = new Appointment(idDate, idDoctor, idPatient, date, time, reason);
                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            ConfigurationDB.closeConnection();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
        ConfigurationDB.closeConnection();
        return appointments;
    }
}
