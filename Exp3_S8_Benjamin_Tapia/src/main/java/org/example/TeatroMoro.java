package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class TeatroMoro {

    public static final int totalTickets = 200;//Cantidad de asientos disponibles
    public static final String[] showCategory = {"Hamilton", "Mamma Mia", "Wicked", "Salir"};
    public static final double[][] ticketPrice = {{200, 150, 100}, {150, 120, 100}, {180, 150, 120}}; //Matriz de combinaciones de precios / 1 Hamilton, 2 Mamma Mia, 3 Wicked
    public static final double[] ticketDiscountAmmount = {0.15, 0.1, 0};
    public static final String[] ticketCategory = {"VIP", "Platea", "Balcon"};
    public static int ticketContador = 0; //Contador de entradas
    public static String[] ticketDiscount = {"Tercera Edad", "Estudiante", "Ninguno"};
    public static String[] mainMenuOptions = {"Comprar entrada", "Ver ventas por evento", "Revisar venta en particular", "Salir"};


    public static List<SalesDatabase> salesList = new ArrayList<>(); //Inicialización de lista de ventas
    public static List<NestedListSales> nestedListSales = new ArrayList<>(); //Inicialización de lista de parametros de venta
    public static List<SalesPerEvent> salesPerEvents = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Inicialización de scanner

        int showOption = 0;
        int ticketQuantity; //Cantidad de entradas del cliente
        int ticketCategoryInt; //Categoría de la entrada del cliente
        boolean showCategoryValidation;
        int discountOption; //Opción de descuento del cliente
        int mainMenuOption; //Opción del menú principal

        do {
            mainMenu();
            System.out.println("Elija la opción de la acción que quiere realizar");
            mainMenuOption = input.nextInt(); //Usuario elije la opción que quiere

            switch (mainMenuOption) {
                case 1:
                    do {
                        System.out.print("Ingrese su primer nombre: ");
                        String clientName = input.next();
                        System.out.println("Ingrese su correo electronico: ");
                        String clientEmail = input.next();

                        System.out.println("Seleccione el evento que desea ver");
                        menuEvents();//Ejecución de menú de obras
                        showCategoryValidation = false; //Para que no se haga un bucle infinito, se vuelve a poner en false

                        while (!showCategoryValidation) { // Bucle de validación de entradas
                            try {
                                showOption = input.nextInt();

                                if (showOption == 4) { //Salir de bucle
                                    break;
                                }

                                while (showOption <= 0 || showOption >= showCategory.length + 1) {
                                    System.out.println("Favor de ingresar un número del 1 al " + (showCategory.length));
                                    showOption = input.nextInt();
                                }

                                showCategoryValidation = true; // Una vez pasada la validación

                                System.out.println("¿Es usted estudiante o tercera edad?");
                                menuDiscounts(); // Ejecución del menú de descuentos

                                discountOption = input.nextInt(); //Opción de descuento


                                System.out.println("¿Cuantas entradas desea comprar?");
                                ticketQuantity = input.nextInt(); //Valor de la cantidad de entradas a comprar

                                while (ticketQuantity >= totalTickets) { //Validación de entradas permitidas
                                    System.out.println("Cantidad supera el máximo permitido, favor ingresar un número de 1 a " + (totalTickets - ticketContador));
                                    ticketQuantity = input.nextInt();
                                }

                                double[] saleTotalIncome = {0, 0}; //Matriz para calcular el ingreso final de la compra

                                for (int i = 0; i <= ticketQuantity - 1; i++) {

                                    System.out.println("Ingrese la categoría de la entrada " + (i + 1));
                                    menuOptions(); //Ejecución del menú de ventas
                                    ticketCategoryInt = input.nextInt(); //Tipo de entrada que compró el cliente

                                    while (ticketCategoryInt >= ticketCategory.length + 1) {
                                        System.out.println("Por favor elija un número entre 1 y " + ticketCategory.length);
                                        ticketCategoryInt = input.nextInt();
                                    }

                                    System.out.println("Su ID de entrada es " + (ticketContador + 1));

                                    saleTotalIncome[1] = saleTotalIncome[0] + (ticketPrice[showOption - 1][ticketCategoryInt - 1] * (1 - ticketDiscountAmmount[discountOption - 1]));
                                    saleTotalIncome[0] = saleTotalIncome[1];

                                    salesList.add(new SalesDatabase(ticketContador + 1,
                                            showCategory[showOption - 1],
                                            ticketCategory[ticketCategoryInt - 1],
                                            ticketDiscountAmmount[discountOption - 1],
                                            (ticketPrice[showOption - 1][ticketCategoryInt - 1] * (1 - ticketDiscountAmmount[discountOption - 1])),
                                            clientName,
                                            clientEmail));

                                    ticketContador++; //Para incrementar el index del ticket
                                }

                                nestedListSales.add(new NestedListSales(ticketQuantity, //Añadir datos a la lista anidada
                                                LocalDate.now(),
                                                saleTotalIncome[1]
                                        )
                                );

                                salesPerEvents.add(new SalesPerEvent(showOption, showCategory[showOption - 1], nestedListSales.getLast()));

                            } catch (InputMismatchException e) {
                                System.out.println("Esto no es un número, por favor solo ingresar variables numericas");
                                input.nextLine();
                            }
                        }
                    } while (showOption != 4);
                    break;

                case 2:
                    int menuEventsOptions;
                    boolean menuEventsOptionsVal = false;

                    while (!menuEventsOptionsVal) {
                        try {
                            System.out.println("Seleccione el evento del cúal desea ver las ventas");
                            menuEvents();

                            menuEventsOptions = input.nextInt();
                            menuEventsOptionsVal = true;

                            while (menuEventsOptions >= showCategory.length || menuEventsOptions <= 0) {
                                System.out.println("Por favor seleecione una opción del 1 al " + showCategory.length);
                                menuEventsOptions = input.nextInt();
                            }

                            for (SalesPerEvent salesPerEvent : salesPerEvents) {//Probando funcionalidad
                                if (salesPerEvent.getEventID() == menuEventsOptions) {
                                    System.out.println(salesPerEvent);
                                }
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Por favor seleccione números enteros");
                            input.nextLine();
                        }

                    }
                    break;
                case 3:
                    System.out.println("Ingrese el ID de la entrada que quiere revisar: ");
                    int idSalesCheck = input.nextInt();

                    boolean idFound = false;

                    for (SalesDatabase salesDatabase: salesList) {
                        if (salesDatabase.getSalesID() == idSalesCheck) {
                            System.out.println(salesDatabase);
                            idFound = true;
                        }

                        if (idFound) {
                            System.out.println("Evento existe");
                            break;
                        } else {
                            System.out.println("Evento no encontrado, favor de ingresar entrada valida");
                        }
                    }

            }
        } while (mainMenuOption != 4);
    }

    private static void mainMenu() {
        System.out.println("¡Bienvenido al Teatro Moro!");
        for (int i = 0; i <= mainMenuOptions.length - 1; i++) {
            System.out.println((i + 1) + ". " + mainMenuOptions[i]);
        }
    }

    private static void menuEvents() {
        for (int i = 0; i <= showCategory.length - 1; i++) {
            System.out.println((i + 1) + ". " + showCategory[i]);
        }
    }

    private static void menuOptions() {
        for (int i = 0; i <= ticketCategory.length - 1; i++) {
            System.out.println((i + 1) + ". " + ticketCategory[i]);
        }
    }

    private static void menuDiscounts(){
        for (int i = 0; i <= ticketDiscount.length - 1; i++) {
            System.out.println((i + 1) + ". " + ticketDiscount[i]);
        }
    }
}

