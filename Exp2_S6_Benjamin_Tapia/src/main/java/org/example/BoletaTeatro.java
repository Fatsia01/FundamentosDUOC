package org.example;
import java.util.Scanner;
import static org.example.TeatroMoroSystem.CANTIDAD_ENTRADA;
import static org.example.TeatroMoroSystem.PRECIO_ENTRADA;

public class BoletaTeatro {
    public static void sistemaBoleta() {
        Scanner input = new Scanner(System.in);
        teatroMoro[] boletas = new teatroMoro[CANTIDAD_ENTRADA];

        for (int i = 0; i <= CANTIDAD_ENTRADA - 1; i++) {
            System.out.println("Ingrese el numero del asiento " + (i + 1) );
            boletas[i] = new teatroMoro(input.nextInt());
        }

        System.out.println("-----BOLETA-----");
        for (int i = 0; i<= CANTIDAD_ENTRADA - 1; i++) {
            System.out.println("Asiento N° " + boletas[i].getNumeroAsiento());
        }
        System.out.println("Cantidad de entradas: " + CANTIDAD_ENTRADA);
        System.out.println("Precio total: " + PRECIO_ENTRADA * CANTIDAD_ENTRADA);
        System.out.println("----------------");
    }
}
