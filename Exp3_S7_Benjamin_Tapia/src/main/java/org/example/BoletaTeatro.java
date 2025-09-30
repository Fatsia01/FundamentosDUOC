package org.example;
import static org.example.TeatroMoro.reservaciones;

public class BoletaTeatro {
    public static void bucleBoleta() {
        for (ReservaTeatro reservaTeatro : reservaciones) {
            System.out.println("---------------" + "\n" +
                    "    Teatro Moro    " + "\n" +
                    "---------------" + "\n" +
                    "Ubicacion: " + reservaTeatro.getUbicacion() + "\n" +
                    "Costo Base: " + reservaTeatro.getCostoBase() + "\n" +
                    "Descuento: " + reservaTeatro.getDescuentoAplicado() + "\n" +
                    "Costo Final: " + reservaTeatro.getCostoFinal() + "\n" +
                    "---------------" + "\n" +
                    "¡Gracias por su visita al teatro!" + "\n" +
                    "---------------");
        }
    }
}