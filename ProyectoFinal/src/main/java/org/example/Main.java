package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        InterseccionEscenario1 escenario1 = new InterseccionEscenario1();

        Calle norte = escenario1.getNorte();
        Calle sur = escenario1.getSur();
        Calle este = escenario1.getEste();
        Calle oeste = escenario1.getOeste();

        List<Vehiculo> vehiculoQueue = escenario1.getVehiculoQueue();

        boolean siguienteVehiculo = false;
        boolean stopRun = false;

        while(!stopRun){

            if(vehiculoQueue.isEmpty()) {
                continue;
            }

            siguienteVehiculo = false;

            // Revisar si hay un vehiculo de emergencia
            for (Vehiculo vehiculo : vehiculoQueue) {

                if (siguienteVehiculo) {
                    break;
                }

                if (vehiculo.isTipoEmergencia()){
                    escenario1.dejarPasar(vehiculo);
                    siguienteVehiculo = true;
                }
            }

            if (siguienteVehiculo){
                continue;
            }

            escenario1.dejarPasar(vehiculoQueue.getFirst());
        }


    }
}