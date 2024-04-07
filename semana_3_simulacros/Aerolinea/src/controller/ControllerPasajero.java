package controller;

import entity.Passenger;
import model.ModelPasajero;

import javax.swing.*;

public class ControllerPasajero {
    public static void crearPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        Passenger objPassenger = new Passenger();

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pasajero");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del pasajero");
        String documento_identidad = JOptionPane.showInputDialog("Ingrese el documento_identidad del pasajero");

        objPassenger.setName(nombre);
        objPassenger.setLastname(apellido);
        objPassenger.setId_document(documento_identidad);



        Passenger passenger = (Passenger) objModelPasajero.create(objPassenger);

        if (passenger != null){
            JOptionPane.showMessageDialog(null, "El usuario se ha creado: \n" + passenger);
        }

    }
    public static void listarPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        String listaDePasajero  = "Lista pasajero\n";


        for (Object objPasajero: objModelPasajero.listar()){
            listaDePasajero += (Passenger) objPasajero + "\n";
        }

        JOptionPane.showMessageDialog(null, listaDePasajero);
    }
    public static String listarPasajeroString(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        String listaDePasajero  = "Lista pasajero\n";


        for (Object objPasajero: objModelPasajero.listar()){
            listaDePasajero += (Passenger) objPasajero + "\n";
        }

        return listaDePasajero;
    }
    public static void actualizarPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        Passenger objPassenger = new Passenger();

        int id = Integer.parseInt(JOptionPane.showInputDialog( listarPasajeroString() + "\nIngresa el id del pasajero que deseas actualizar"));

        Passenger passenger =  (Passenger) objModelPasajero.findByID(id);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pasajero", passenger.getName());
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del pasajero", passenger.getLastname());
        String documento_identidad = JOptionPane.showInputDialog("Ingrese el documento_identidad del pasajero", passenger.getId_document());

        objPassenger.setName(nombre);
        objPassenger.setLastname(apellido);
        objPassenger.setId_document(documento_identidad);
        objPassenger.setId(id);


        boolean validacion = objModelPasajero.update(objPassenger);

        if (validacion){
            JOptionPane.showMessageDialog(null, "Pasajero actualizado con exito" );
        }

    }
    public static void eliminarPasajero(){
        ModelPasajero objModelPasajero = new ModelPasajero();
        Passenger objPassenger = new Passenger();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarPasajeroString() + "\n Ingrese el id del pasajero que desea eliminar"));

        objPassenger.setId(id);


        boolean validacion = objModelPasajero.delete(objPassenger);;

        if (validacion){
            JOptionPane.showMessageDialog(null, "Pasajero eliminado con exito" );
        }


    }

}
