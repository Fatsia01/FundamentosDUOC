package org.example;
import static org.example.TeatroMoro.reservaciones;

public class VentasTeatro {

    public static int entradasVendidas = 0;
    public static double ingresosTotales = 0;

    public static void bucleVentas() {
        for (ReservaTeatro reservaTeatro : reservaciones) {
            ingresosTotales += reservaTeatro.getCostoFinal();
        }

        System.out.println("La suma total de las ventas es : $" + ingresosTotales);
    }
}
