package controller;

import entity.Flight;
import entity.VueloConAvion;
import model.ModelVuelo;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ControllerVuelo {
    public static void crearVuelo(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        Flight objFlight = new Flight();

        String destino = JOptionPane.showInputDialog("Ingresa el destino del vuelo");
        int id_avion = Integer.parseInt(JOptionPane.showInputDialog(ControllerAvion.listarAvionesString() + "\nIngresa el id del avion establecido para el viaje"));


        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                String fecha_salida = JOptionPane.showInputDialog("Ingresa la fecha de salida (yyyy-MM-dd)");
                LocalDate fecha = LocalDate.parse(fecha_salida, formatterDate);
                objFlight.setStart(fecha);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error en patron, recuerda el formato (yyyy-MM-dd)");
                return;
            };

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            String hora_salida = JOptionPane.showInputDialog("Ingresa la hora de salida (HH:mm:ss)");
            LocalTime time = LocalTime.parse(hora_salida, formatterTime);
            objFlight.setTime(time);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en patron, recuerda el formato (HH:mm:ss)");
            return;
        }

        objFlight.setDestination(destino);
        objFlight.setAirplane_id(id_avion);


        Flight flight = (Flight) objModelVuelo.create(objFlight);

        if (flight != null){
            JOptionPane.showMessageDialog(null, "El usuario se ha creado: \n" + flight);
        }

    }
    public static void listarVuelos(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        String listaDeVuelos  = "Lista de vuelos\n";


        for (Object objVuelo: objModelVuelo.listar()){
            listaDeVuelos += (VueloConAvion) objVuelo + "\n";
        }
        JOptionPane.showMessageDialog(null, listaDeVuelos);
    }
    public static String listarVuelosString(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        String listaDeVuelos  = "Lista de vuelos\n";


        for (Object objVuelo: objModelVuelo.listar()){
            listaDeVuelos += (VueloConAvion) objVuelo + "\n";
        }
        return listaDeVuelos;
    }
    public static void actualizarVuelo(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        Flight objFlight = new Flight();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarVuelosString() + "\n Ingresa el id del vuelo que deseas actualizar"));


        VueloConAvion vueloByID = (VueloConAvion) objModelVuelo.findByID(id);
        if (vueloByID == null || vueloByID.getVuelo() == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vuelo con el ID proporcionado.");
            return;
        }

        String destino = JOptionPane.showInputDialog("Ingresa el destino del vuelo", vueloByID.getVuelo().getDestination());
        int id_avion = Integer.parseInt(JOptionPane.showInputDialog(ControllerAvion.listarAvionesString() + "\nIngresa el id del avion establecido para el viaje", vueloByID.getVuelo().getAirplane_id()));

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            String fecha_salida = JOptionPane.showInputDialog("Ingresa la fecha de salida", vueloByID.getVuelo().getStart());
            LocalDate fecha = LocalDate.parse(fecha_salida, formatterDate);
            objFlight.setStart(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha. Recuerda el formato (yyyy-MM-dd)");
            return;
        }

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            String hora_salida = JOptionPane.showInputDialog("Ingresa la hora de salida", vueloByID.getVuelo().getTime());
            LocalTime time = LocalTime.parse(hora_salida, formatterTime);
            objFlight.setTime(time);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la hora. Recuerda el formato (HH:mm:ss)");
            return;
        }

        objFlight.setDestination(destino);
        objFlight.setAirplane_id(id_avion);
        objFlight.setId(id);

        // Actualizar el vuelo existente en la base de datos
        boolean actualizado = objModelVuelo.update(objFlight);

        if (actualizado) {
            JOptionPane.showMessageDialog(null, "El vuelo se ha actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar el vuelo.");
        }
    }
    public static void eliminarVuelo(){
        ModelVuelo objModelVuelo = new ModelVuelo();
        Flight objFlight = new Flight();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarVuelosString()+ "\n Ingrese el id del vuelo que desea eliminar"));

        objFlight.setId(id);

        boolean validacion = objModelVuelo.delete(objFlight);


        if (validacion){
            JOptionPane.showMessageDialog(null, "Avion eliminado con exito" );
        }
    }




}
