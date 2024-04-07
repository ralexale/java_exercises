package controller;

import entity.Airplane;
import model.ModelAvion;

import javax.swing.*;

public class ControllerAvion {

    public static void crearAvion(){
        ModelAvion objModelAvion = new ModelAvion();
        Airplane objAirplane = new Airplane();

        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del avion");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del avion"));


        objAirplane.setModel(modelo);
        objAirplane.setCapacity(capacidad);


        Airplane airplane = (Airplane) objModelAvion.create(objAirplane);

        if (airplane != null){
            JOptionPane.showMessageDialog(null, "El usuario se ha creado: \n" + airplane);
        }

    }
    public static void listarAviones(){
        ModelAvion objModelAvion = new ModelAvion();
        String listaDeAviones = "Lista aviones \n";


        for (Object objAvion: objModelAvion.listar()){
            listaDeAviones += (Airplane) objAvion + "\n";
        }

        JOptionPane.showMessageDialog(null, listaDeAviones);
    }
    public static String listarAvionesString(){
        ModelAvion objModelAvion = new ModelAvion();
        String listaDeAviones = "Lista aviones \n";


        for (Object objAvion: objModelAvion.listar()){
            listaDeAviones += (Airplane) objAvion + "\n";
        }

        return listaDeAviones;
    }
    public static void actualizarAvion(){
        ModelAvion objModelAvion = new ModelAvion();
        Airplane objAirplane = new Airplane();

        int id = Integer.parseInt(JOptionPane.showInputDialog( listarAvionesString() + "\nIngresa el id del avion que deseas actualizar"));


        Airplane airplane =  (Airplane) objModelAvion.findByID(id);
        String modelo =JOptionPane.showInputDialog("ingresa el nombre del modelo", airplane.getModel());
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la capacidad del avion", airplane.getCapacity()));

        objAirplane.setId(id);
        objAirplane.setModel(modelo);
        objAirplane.setCapacity(capacidad);


        boolean validacion = objModelAvion.update(objAirplane);

        if (validacion){
            JOptionPane.showMessageDialog(null, "Avion actualizado con exito" );
        }

    }
    public static void eliminarAvion(){
        ModelAvion objModelAvion = new ModelAvion();
        Airplane objAirplane = new Airplane();

        int id = Integer.parseInt(JOptionPane.showInputDialog(listarAvionesString() + "\n Ingrese el id del avion que desea eliminar"));

        objAirplane.setId(id);


        boolean validacion = objModelAvion.delete(objAirplane);;

        if (validacion){
            JOptionPane.showMessageDialog(null, "Avion eliminado con exito" );
        }


    }


}
