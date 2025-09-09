package org.example;
import java.util.Scanner;

public class programaTeatroMoroS4 {
    public static void main(String[] args) {
        String[] menuOptions = {"1. Comprar entrada", "2. Salir"};

        String[][] asientosZona1 = {{"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}};
        String[][] asientosZona2 = {{"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}};
        String[][] asientosZona3 = {{"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}, {"0", "0", "0", "0", "0"}}; //Variables de asientos disponibles (0 = disponible, X = reservado)

        int filaAsiento; // variable de las filas
        int columnaAsiento; // variable de las columnas

        int edadUsuario; //Edad del usuario

        double descuentoTerceraEdad = 0.85; //Descuentos
        double descuentoEstudiante = 0.9;

        int statusUsuario = 0;
        int tipoEntrada;

        double precioVIP = 35000; //Precios regulares, si fila = 1 es VIP
        double precioPlateaBaja = 25000; // si fila = 2 es platea baja
        double precioPlateaAlta = 15000; // si fila = 3 es platea alta
        double precioPalco = 11000; // si fila = 4 o 5 es palco

        double precioVIP_1 = precioVIP * descuentoTerceraEdad; // Precios finales a pagar para 3ra edad
        double precioPlateaBaja_1 = precioPlateaBaja * descuentoTerceraEdad;
        double precioPlateaAlta_1 = precioPlateaAlta * descuentoTerceraEdad;
        double precioPalco_1 = precioPalco * descuentoTerceraEdad;

        double precioVIP_2 = precioVIP * descuentoEstudiante; //Precios finales a pagar por estudiantes
        double precioPlateaBaja_2 = precioPlateaBaja * descuentoEstudiante;
        double precioPlateaAlta_2 = precioPlateaAlta * descuentoEstudiante;
        double precioPalco_2 = precioPalco * descuentoEstudiante;


        Scanner scanner = new Scanner(System.in); //Inicialización de scanner

        System.out.println("Por favor, escriba el número de su opción");
        for (int i = 0; i <= 1; i++) { //Menú con ciclo for
            System.out.println(menuOptions[i]);
        }

        int opcionMenu = scanner.nextInt(); // Opción de usuario

        while (opcionMenu < 1 || opcionMenu >= 3) { // Validación de la opción del usuario
            System.out.println("Por favor, seleccione una opción valida");
            opcionMenu = scanner.nextInt();
        }

        while (opcionMenu == 1) { // Bucle del menú, cuando sea 2 se acaba la compra
            System.out.println("0 = Disponible // X = Reservado"); // Interfaz del plano del teatro
            System.out.println("------------Escenario-------------");
            System.out.println("Zona 1        Zona 2        Zona 3");

            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    System.out.print(asientosZona1[j][i]);
                }
                System.out.print("         ");
                for (int j = 0; j <= 4; j++) {
                    System.out.print(asientosZona2[j][i]);
                }
                System.out.print("         ");
                for (int j = 0; j <= 4; j++) {
                    System.out.print(asientosZona3[j][i]);
                }
                System.out.println(); //Mapa de asientos del teatro (me tomó 5 horas)
            }
            System.out.println();
            System.out.println("Por favor, seleccione el número de la zona donde desea comprar:");
            System.out.println("Zona 1"); //Separación por zonas
            System.out.println("Zona 2");
            System.out.println("Zona 3");

            int opcionZona = scanner.nextInt(); //Opción del usuario para las zonas

            while (opcionZona >= 4 || opcionZona < 0) { // Validación de las zonas
                System.out.println("Por favor, selecciona una zona valida");
                opcionZona = scanner.nextInt();
            }

            System.out.println("Ahora, seleccione la fila y la columna donde desea su asiento, recuerde que hay 5 filas y 5 columnas:");

            System.out.println("Fila: "); //Selección de fila por el usuario
            filaAsiento = scanner.nextInt();
            tipoEntrada = filaAsiento;
            filaAsiento = filaAsiento - 1;

            while (filaAsiento - 1 >= 5 || filaAsiento <= 0){
                System.out.println("Fila no existente, favor de elegir del 1 al 5");
                filaAsiento = scanner.nextInt();
                filaAsiento = filaAsiento - 1;
            }

            System.out.println("Columna: "); //Selección de columna por el usuario
            columnaAsiento = scanner.nextInt();
            columnaAsiento = columnaAsiento - 1;

            while (columnaAsiento - 1 >= 5 || columnaAsiento <= 0){
                System.out.println("Columna no existente, favor de elegir del 1 al 5");
                columnaAsiento = scanner.nextInt();
                columnaAsiento = columnaAsiento - 1;
            }

            switch (opcionZona) {
                case 1:
                    if (asientosZona1[columnaAsiento][filaAsiento] == "0") { //Bucle que revisa si el asiento está ocupado
                        asientosZona1[columnaAsiento][filaAsiento] = "X";
                        break;
                    } else
                        while (asientosZona1[columnaAsiento][filaAsiento] == "X") {
                            System.out.println("El asiento ya está disponible, por favor seleccione otro");
                            System.out.println("Fila :");
                            filaAsiento = scanner.nextInt();
                            filaAsiento = filaAsiento - 1;

                            System.out.println("Columna: ");
                            columnaAsiento = scanner.nextInt();
                            columnaAsiento = columnaAsiento - 1;
                        }
                    asientosZona1[columnaAsiento][filaAsiento] = "X";
                    break;
                case 2:
                    if (asientosZona2[columnaAsiento][filaAsiento] == "0") {
                        asientosZona2[columnaAsiento][filaAsiento] = "X";
                        break;
                    } else
                        while (asientosZona2[columnaAsiento][filaAsiento] == "X") {
                            System.out.println("El asiento ya está disponible, por favor seleccione otro");
                            System.out.println("Fila :");
                            filaAsiento = scanner.nextInt();
                            filaAsiento = filaAsiento - 1;

                            System.out.println("Columna: ");
                            columnaAsiento = scanner.nextInt();
                            columnaAsiento = columnaAsiento - 1;
                        }
                    asientosZona2[columnaAsiento][filaAsiento] = "X";
                    break;
                case 3:
                    if (asientosZona3[columnaAsiento][filaAsiento] == "0") {
                        asientosZona3[columnaAsiento][filaAsiento] = "X";
                        break;
                    } else
                        while (asientosZona3[columnaAsiento][filaAsiento] == "X") {
                            System.out.println("El asiento ya está disponible, por favor seleccione otro");
                            System.out.println("Fila :");
                            filaAsiento = scanner.nextInt();
                            filaAsiento = filaAsiento - 1;

                            System.out.println("Columna: ");
                            columnaAsiento = scanner.nextInt();
                            columnaAsiento = columnaAsiento - 1;
                        }
                    asientosZona3[columnaAsiento][filaAsiento] = "X";
                    break;
            }

            System.out.println("0 = Disponible // X = Reservado"); //Plano de asientos luego de la elección del usuario
            System.out.println("------------Escenario-------------");
            System.out.println("Zona 1        Zona 2        Zona 3");

            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    System.out.print(asientosZona1[j][i]);
                }
                System.out.print("         ");
                for (int j = 0; j <= 4; j++) {
                    System.out.print(asientosZona2[j][i]);
                }
                System.out.print("         ");
                for (int j = 0; j <= 4; j++) {
                    System.out.print(asientosZona3[j][i]);
                }
                System.out.println();
            }
            System.out.println("Favor de ingresar su edad por favor"); //Ingreso de la edad para descuentos
            edadUsuario = scanner.nextInt();

            while (edadUsuario < 10) { //Validación si es demasiado pequeño para comprar por su cuenta
                System.out.println("Favor de traer a un adulto responsable que pueda comprar la entrada");
                edadUsuario = scanner.nextInt(); //Verificación de edad
            }

            while (edadUsuario >= 110) { //Validación si es demasiado viejo
                System.out.println("Edad invalida");
                edadUsuario = scanner.nextInt();
            }

            if (edadUsuario >= 65) { //Validación si es tercera edad
                System.out.println("Felicidades, usted tiene descuento por tercera edad");
                statusUsuario = 1;
            }

            if (edadUsuario <= 18) { //Validación del supuesto de estudiante
                System.out.println("Felicidades, usted tiene descuento de estudiante");
                statusUsuario = 2;
            }

            System.out.println("-------------------------"); //Resumen de la transacción
            System.out.println("Resumen de la transacción:");
            System.out.println("Ubicación del asiento: Fila " + (filaAsiento + 1) + " Columna " + (columnaAsiento + 1) + " Zona " + opcionZona);

            if (filaAsiento == 0) { //Precio base
                System.out.println("Precio Base de la entrada: " + precioVIP);
            } else if (filaAsiento == 1) {
                System.out.println("Precio Base de la entrada: " + precioPlateaBaja);
            } else if (filaAsiento == 2) {
                System.out.println("Precio Base de la entrada: " + precioPlateaAlta);
            } else
                System.out.println("Precio Base de la entrada: " + precioPalco);

            System.out.print("Descuento aplicado: "); // Valor del descuento aplicado

            if (statusUsuario == 0) { //En caso que no tenga descuento
                if (tipoEntrada == 1) {
                    System.out.println("NA");
                    System.out.println("Precio a pagar: " + precioVIP);
                }
                if (tipoEntrada == 2) {
                    System.out.println("NA");
                    System.out.println("Precio a pagar: " + precioPlateaBaja);
                }
                if (tipoEntrada == 3) {
                    System.out.println("NA");
                    System.out.println("Precio a pagar: " + precioPlateaAlta);
                }
                if (tipoEntrada == 4 || tipoEntrada == 5) {
                    System.out.println("NA");
                    System.out.println("Precio a pagar: " + precioPalco);
                }
            }
            if (statusUsuario == 1) { //En caso que sea tercera edad (status = 1)
                if (tipoEntrada == 1) {
                    System.out.println(precioVIP - (precioVIP * descuentoTerceraEdad));
                    System.out.println("Precio a pagar: " + precioVIP_1);
                }
                if (tipoEntrada == 2) {
                    System.out.println(precioPlateaBaja - precioPlateaBaja * descuentoTerceraEdad);
                    System.out.println("Precio a pagar: " + precioPlateaBaja_1);
                }
                if (tipoEntrada == 3) {
                    System.out.println(precioPlateaAlta - precioPlateaAlta * descuentoTerceraEdad);
                    System.out.println("Precio a pagar: " + precioPlateaAlta_1);
                }
                if (tipoEntrada == 4 || tipoEntrada == 5) {
                    System.out.println(precioPalco - precioPalco * descuentoTerceraEdad);
                    System.out.println("Precio a pagar: " + precioPalco_1);
                }
            }
            if (statusUsuario == 2) { //En caso que sea estudiante (status = 2)
                if (tipoEntrada == 1) {
                    System.out.println(precioVIP - precioVIP * descuentoEstudiante);
                    System.out.println("Precio a pagar: " + precioVIP_2);
                }
                if (tipoEntrada == 2) {
                    System.out.println(precioPlateaBaja - precioPlateaBaja * descuentoEstudiante);
                    System.out.println("Precio a pagar: " + precioPlateaBaja_2);
                }
                if (tipoEntrada == 3) {
                    System.out.println(precioPlateaAlta - precioPlateaAlta * descuentoEstudiante);
                    System.out.println("Precio a pagar: " + precioPlateaAlta_2);
                }
                if (tipoEntrada == 4 || tipoEntrada == 5) {
                    System.out.println(precioPalco - precioPalco * descuentoEstudiante);
                    System.out.println("Precio a pagar: " + precioPalco_2);
                }
            }

            System.out.println("Desea comprar otra entrada?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcionMenu = scanner.nextInt();

        }
        System.out.println("Gracias por su compra!"); //Finalización del programa
    }
}




