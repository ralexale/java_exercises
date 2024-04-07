import controller.ControllerAvion;
import controller.ControllerPasajero;
import controller.ControllerReservacion;
import controller.ControllerVuelo;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion = 0, opcionAvion = 0, opcionPasajero = 0, opcionReservacion = 0 , opcionVuelo = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Ingrese una opción
                    1 -  AVION
                    2 -  PASAJERO
                    3 -  RESERVACION
                    4 -  VUELO
                    """));

            switch (opcion){
                case 1:
                    do {
                        opcionAvion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear avión
                                2 - Eliminar avión 
                                3 - Actualizar avión
                                4 - Listar avión
                                5 - Salir 
                                """));

                        switch (opcionAvion){
                            case 1:
                                ControllerAvion.crearAvion();
                                break;
                            case 2:
                                ControllerAvion.eliminarAvion();
                                break;
                            case 3:
                                ControllerAvion.actualizarAvion();
                                break;
                            case 4:
                                ControllerAvion.listarAviones();
                                break;
                        }
                    }while (opcionAvion != 5);

                    break;

                case 2:
                    do {
                        opcionPasajero = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear passenger
                                2 - Eliminar passenger 
                                3 - Actualizar passenger
                                4 - Listar passenger
                                5 - Salir 
                                """));

                        switch (opcionPasajero){
                            case 1:
                                ControllerPasajero.crearPasajero();
                                break;
                            case 2:
                                ControllerPasajero.eliminarPasajero();
                                break;
                            case 3:
                                ControllerPasajero.actualizarPasajero();
                                break;
                            case 4:
                                ControllerPasajero.listarPasajero();
                                break;
                        }
                    }while (opcionPasajero != 5);
                    break;

                case 3:
                    do {
                        opcionReservacion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear reservation
                                2 - Eliminar reservation 
                                3 - Actualizar reservation
                                4 - Listar reservation
                                5 - Salir 
                                 """));

                        switch (opcionReservacion){
                            case 1:
                                ControllerReservacion.crearReservacion();
                                break;
                            case 2:
                                ControllerReservacion.eliminarReservacion();
                                break;
                            case 3:
                                ControllerReservacion.actualizarReservacion();
                                break;
                            case 4:
                                ControllerReservacion.listarReservacion();
                                break;
                        }

                    }while (opcionReservacion != 5);
                    break;

                case 4:
                    do {
                        opcionVuelo = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear flight
                                2 - Eliminar flight 
                                3 - Actualizar flight 
                                4 - Listar flight 
                                5 - Salir
                                
                                """));

                        switch (opcionVuelo){
                            case 1:
                                ControllerVuelo.crearVuelo();
                                break;
                            case 2:
                                ControllerVuelo.eliminarVuelo();
                                break;
                            case 3:
                                ControllerVuelo.actualizarVuelo();
                                break;
                            case 4:
                                ControllerVuelo.listarVuelos();
                                break;
                        }
                    }while (opcionVuelo != 5);
                    break;
            }


        }while (opcion != 5);


    }
}