package controllers;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public abstract class DateGenerator {

      Date showDatePickerDialog() {
        // Crear un JSpinner para seleccionar la fecha
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy/MM/dd"));

        // Crear el panel que contiene el JSpinner
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(spinner, BorderLayout.CENTER);

        // Mostrar el JOptionPane con el JSpinner
        int result = JOptionPane.showConfirmDialog(null, panel, "Select a patient birthdate",
                JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            // Obtener la fecha seleccionadaa
            Date selectedDate = (Date) spinner.getValue();
            return selectedDate;
        }
        return null; // Retornar null si el usuario cancela la selección
    }

}
