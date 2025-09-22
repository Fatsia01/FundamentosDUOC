package org.example;

import static org.example.TeatroMoroSystem.CANTIDAD_ENTRADA;
import static org.example.TeatroMoroSystem.PRECIO_ENTRADA;

public class BoletaTeatro {
    public static void sistemaBoleta(teatroMoro asiento) {
        System.out.println("Cantidad de entradas: " + CANTIDAD_ENTRADA);
        System.out.println("Precio total: " + PRECIO_ENTRADA * CANTIDAD_ENTRADA);
        System.out.println("----------------");
    }
}
