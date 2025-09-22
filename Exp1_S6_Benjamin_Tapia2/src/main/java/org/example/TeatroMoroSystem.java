package org.example;
import java.util.Scanner;

public class TeatroMoroSystem {

    private static final int ENTRADAS_TOTALES = 30; // Variables estáticas dentro de main
    public static final int PRECIO_ENTRADA = 20000;
    public static int CANTIDAD_ENTRADA;

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in); //Inicialización de scanner

        teatroMoro[] asientos = new teatroMoro[ENTRADAS_TOTALES];

        for (int i = 0; i < ENTRADAS_TOTALES; i++ ) {
            asientos[i] = new teatroMoro(i + 1);
        }

        int opcionMenu; //Variables de opciones
        int numeroAsiento = 0;

        do { //Ejecución del menú
            menu();
            opcionMenu = input.nextInt();


            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingrese la cantidad de entradas a reservar");
                    CANTIDAD_ENTRADA = input.nextInt();

                    while (CANTIDAD_ENTRADA > ENTRADAS_TOTALES) {
                        System.out.println("Supera el limite de capacidad del teatro, favor elegir menos entradas");
                        CANTIDAD_ENTRADA = input.nextInt();
                    }

                    for (int i = 1; i <= CANTIDAD_ENTRADA; i++) {
                        System.out.println("Ingrese el número de la entrada " + i + " a reservar (1 - " + ENTRADAS_TOTALES + ")");

                        numeroAsiento = input.nextInt();

                        if(asientos[numeroAsiento - 1].reservar()) {
                            System.out.println("¡Asiento reservado!");
                        } else {
                            while (!asientos[numeroAsiento - 1].reservar()) {
                                System.out.println("Asiento ya reservado u ocupado, por favor elija uno disponible");
                                numeroAsiento = input.nextInt();
                            }
                        }
                    }
                    System.out.println("Recordar que las entradas están reservadas por 3 minutos"); //Cronometro improvisado
                    break;

                case 2:
                    System.out.println("Ingrese el número de asiento que desea modificar (1 - " + ENTRADAS_TOTALES + ")");
                    int modAsiento;

                    modAsiento = input.nextInt();

                    if (asientos[modAsiento - 1].modificarAsiento()){
                        System.out.println("Su reserva ha sido cancelada con éxito");
                    } else {
                        System.out.println("No existe una reserva para ese número");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese la cantidad de entradas a comprar (en caso de emergencia, ingresar el número de asiento 99");
                    CANTIDAD_ENTRADA = input.nextInt();

                    while (CANTIDAD_ENTRADA > ENTRADAS_TOTALES) {
                        System.out.println("Supera el limite de capacidad del teatro, favor elegir menos entradas");
                        CANTIDAD_ENTRADA = input.nextInt();
                    }

                    for (int i = 1; i <= CANTIDAD_ENTRADA; i++) {
                        System.out.println("Ingrese el número de la entrada " + i + " a comprar (1 - " + ENTRADAS_TOTALES + ")");

                        numeroAsiento = input.nextInt();

                        if (asientos[numeroAsiento - 1].ocupar()) {
                            System.out.println("¡Asiento comprado!");
                        } else {
                            while (!asientos[numeroAsiento - 1].ocupar()) {
                                System.out.println("Asiento no está reservado");
                                numeroAsiento = input.nextInt();
                                if (numeroAsiento == 99) {
                                    System.out.println("Ejecutando salida de bucle");
                                    break;
                                }
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Ingrese la cantidad de entradas compradas");
                    CANTIDAD_ENTRADA = input.nextInt();

                    while (CANTIDAD_ENTRADA > ENTRADAS_TOTALES) {
                        System.out.println("Supera el limite de capacidad del teatro, favor elegir menos entradas");
                        CANTIDAD_ENTRADA = input.nextInt();
                    }

                    System.out.println("----BOLETA----");
                    for (int i = 1; i<= CANTIDAD_ENTRADA; i++) {
                        System.out.println("Ingrese los números del asiento " + i);
                        numeroAsiento = input.nextInt();

                        System.out.println("Entrada " + numeroAsiento);

                    }

                    BoletaTeatro.sistemaBoleta(asientos[numeroAsiento - 1]);

                    break;
                    }

        } while (opcionMenu != 5);

        System.out.println("¡Muchas gracias por su compra!");
        input.close();
    }

    private static void menu() {
        System.out.println("----MENU----");
        System.out.println("1. Reservar asiento");
        System.out.println("2. Modificar asiento");
        System.out.println("3. Confirmar compra");
        System.out.println("4. Imprimir boleta");
        System.out.println("5. Salir");
        System.out.println("Favor de seleccionar una opción");
    }

}
