package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.example.VentasTeatro.ingresosTotales;


public class TeatroMoro {

    public static final int entradasTotales = 200; //Cantidad de asientos disponibles
    public static final double[] precioEntradas = {150, 100, 80}; //Precios de entrada según tipo (1. VIP, 2. Platea, 3. Palco)
    public static final double[] descuentoEntradas = {0.15, 0.1, 0};
    public static final String[] categoriaEntradas = {"VIP", "Platea", "Balcon"};

    public static List<ReservaTeatro> reservaciones = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Inicialización de scanner
        //Lista de reservaciones de entradas

        int opcionMenu; //Inicialización de variable de opciones del menu
        int cantidadEntradas = 0;
        int tipoEntrada = 0;
        int tipoDescuento = 0;

        do {
            menu();
            System.out.println("Por favor seleccione el número de su opción");
            opcionMenu = input.nextInt();

            while (opcionMenu > 5 || opcionMenu < 0) {
                System.out.println("Por favor, ingrese una opción valida del menu");
                opcionMenu = input.nextInt();
            }

            switch (opcionMenu) {
                case 1:
                    System.out.println("Ingrese la cantidad de entradas que desea comprar entre 1 - " + entradasTotales);
                    cantidadEntradas = input.nextInt();

                    while (cantidadEntradas > entradasTotales || cantidadEntradas <= 0) {
                        System.out.println("Cantidad invalida, favor elegir una cantidad entre 1  - " + entradasTotales);
                        cantidadEntradas = input.nextInt();
                    }

                    if (cantidadEntradas == 1) {
                        System.out.println();
                        System.out.println("Por favor ingrese el tipo de entrada");
                        System.out.println("1. VIP");
                        System.out.println("2. Platea");
                        System.out.println("3. Balcon");

                        tipoEntrada = input.nextInt(); //Tipo de entrada (ubicacion)

                        while (tipoEntrada >= 4 || tipoEntrada <= 0) {
                            System.out.println("Por favor elija una entrada valida");
                            tipoEntrada = input.nextInt();
                        }

                        System.out.println("¿Es usted estudiante o adulto mayor?");
                        System.out.println("1. Estudiante");
                        System.out.println("2. Adulto Mayor");
                        System.out.println("3. Ninguno");

                        tipoDescuento = input.nextInt();

                        while (tipoDescuento >= 4 || tipoDescuento <= 0) {
                            System.out.println("Por favor elija una descuento valido");
                            tipoDescuento = input.nextInt();
                        }

                        //Nueva reserva añadida a la lista
                        reservaciones.add(new ReservaTeatro(categoriaEntradas[tipoEntrada - 1], precioEntradas[tipoEntrada - 1], descuentoEntradas[tipoDescuento - 1], precioEntradas[tipoEntrada - 1] * (1.0 - descuentoEntradas[tipoDescuento - 1])));
                        VentasTeatro.entradasVendidas++; // Contador de entradas
                    }

                    if (cantidadEntradas > 1) {
                        for (int i = 0; i <= cantidadEntradas - 1; i++) {
                            System.out.println();
                            System.out.println("Por favor ingrese el tipo de entrada n° " + (i + 1));
                            System.out.println("1. VIP");
                            System.out.println("2. Platea");
                            System.out.println("3. Balcon");

                            tipoEntrada = input.nextInt(); //Tipo de entrada (ubicacion)

                            while (tipoEntrada >= 4 || tipoEntrada <= 0) {
                                System.out.println("Por favor elija una entrada valida");
                                tipoEntrada = input.nextInt();
                            }

                            System.out.println("¿Es usted estudiante o adutlo mayor?");
                            System.out.println("1. Estudiante");
                            System.out.println("2. Adulto Mayor");
                            System.out.println("3. Ninguno");

                            tipoDescuento = input.nextInt();

                            while (tipoDescuento >= 4 || tipoDescuento <= 0) {
                                System.out.println("Por favor elija una descuento valido");
                                tipoDescuento = input.nextInt();
                            }

                            //Nueva reserva añadida a la lista
                            reservaciones.add(new ReservaTeatro(categoriaEntradas[tipoEntrada - 1], precioEntradas[tipoEntrada - 1], descuentoEntradas[tipoDescuento - 1], precioEntradas[tipoEntrada - 1] * (1.0 - descuentoEntradas[tipoDescuento - 1])));
                            VentasTeatro.entradasVendidas++; // Contador de entradas
                        }
                    }

                    break;

                case 2:
                    System.out.println(reservaciones.toString());
                    break;

                case 3:
                    BoletaTeatro.bucleBoleta();
                    break;

                case 4:
                    VentasTeatro.bucleVentas();
                    break;

            }


        } while (opcionMenu != 5);

        System.out.println("¡Muchas gracias por su compra!");
    }

    private static void menu() {
        System.out.println("======MENU======");
        System.out.println("1. Venta de entradas");
        System.out.println("2. Resumen de ventas");
        System.out.println("3. Generar boletas");
        System.out.println("4. Ingresos totales");
        System.out.println("5. Salir del programa");
    }
}