package org.example;
import java.util.*;


import static org.example.MoroVariables.*;

public class TeatroMoro {

    //Variables del usuario
    public static int mainMenuOption;//Elección del usuario sobre el menú principal
    public static int userAge; //Edad del usuario (usado para determinar descuentos)
    public static String userGender; //Género del usuario (usado para determinar descuentos)
    public static int userCategory;
    public static double totalDiscount; //Calculo del descuento total que será enviado a la boleta
    public static int ticketQuantity;

    public static List<SalesMoro> salesList = new ArrayList<>(); //Inicialización de lista de ventas


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Inicialización de Scanner

        System.out.println("!Bienvenido al Teatro Moro!");//Mensaje de bienvenida
        System.out.println("""
                Tenemos los siguientes descuentos:\s
                Gente de tercera edad tiene un 30% de descuento!
                Niños tienen un 5% de descuento!
                Mujeres tienen un 7% de descuento!""");



        do {
            System.out.println();//Bucle de menú hasta que elijan salir
            mainMenu();
            System.out.println(); //Ejecución del menú principal

            try { //Validar input de opción de menú
                System.out.print("Seleccione la opción que desea: ");

                mainMenuOption = input.nextInt(); //Asignación de la elección del usuario

                while (mainMenuOption >= MoroVariables.MAIN_MENU.length + 1 || mainMenuOption <= 0) {
                    System.out.println("Por favor elija un número valido");
                    mainMenuOption = input.nextInt();
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor elija un número entero como opción");
                input.nextLine(); //Remover la opción para no generar bucles infinitos
            }

            switch (mainMenuOption) {
                case 1:
                    boolean userAgeValidation = false; //Variables booleanas para validar si la información ingresada es correcta
                    boolean userGenderValidation = false;
                    boolean userQuantityValidation = false;

                    while (!userAgeValidation) {
                        try {
                            System.out.print("Por favor ingrese su edad: ");
                            userAge = input.nextInt();//Ingreso de la edad del usuario

                            while (userAge <= 0 || userAge >= 125) {
                                System.out.println("Ingrese una edad valida");
                                userAge = input.nextInt();
                            }

                            userAgeValidation = true; //Valida si la entrada pasó las pruebas de calidad


                        } catch (InputMismatchException e) {
                            System.out.println("Por favor ingrese su edad en números");
                            input.nextLine();
                        }
                    }

                    while (!userGenderValidation) {
                        try {
                            System.out.print("Por favor ingrese su género (F o M): ");
                            userGender = input.next().toUpperCase(); //Ingreso del género del usuario

                            while (!Objects.equals(userGender, "F") && !Objects.equals(userGender, "M")) {
                                System.out.println("Ingrese un género valido");
                                userGender = input.next().toUpperCase();

                            }

                            userGenderValidation = true; //Valida si la entrada de género pasó las pruebas de calidad

                        } catch (InputMismatchException e) {
                            System.out.println("Por favor ingrese una de las variables mencionadas");
                            input.nextLine();
                        }
                    }

                    calculateDiscount(); //Función que calcula el descuento total
                    System.out.print("Ingrese la cantidad de entradas a comprar: ");

                    while (!userQuantityValidation) {
                        try {
                            ticketQuantity = input.nextInt(); //Cantidad de entradas a comprar

                            while (ticketQuantity > (TOTAL_TICKETS - ticketAmmount) || ticketQuantity <= 0) {
                                System.out.println("Por favor elegir una cantidad entre 1 - " + (TOTAL_TICKETS - ticketAmmount));
                                ticketQuantity = input.nextInt(); //Verificación de cantidad
                            }
                            userQuantityValidation = true;

                        } catch (InputMismatchException e) {
                            System.out.println("Elija una cantidad en números enteros por favor");
                            input.nextLine();
                        }
                        catch (IndexOutOfBoundsException e) {
                            System.out.println("Elija una cantidad disponible");
                            input.nextLine();

                        }
                    }

                    System.out.println();
                    System.out.println("Categorías de entradas: "); //Menu de categorias de entrada
                    for (int i = 0; i <= TICKET_CATEGORY.length - 1; i++) {
                        System.out.println((i + 1) + ". " + TICKET_CATEGORY[i]);
                    }
                    System.out.println();

                    //Inicialización de bucle de ventas
                    for (int i = 0; i <= ticketQuantity - 1; i++) {
                        boolean userCategoryValidation = false; //Para volver a iniciar el bucle

                        while (!userCategoryValidation) { //Validación de categoria
                            try {
                                System.out.print("Ingrese la categoría de la entrada " + (i + 1) + " ");
                                userCategory = input.nextInt();

                                while (userCategory > 5 || userCategory <= 0) {
                                    System.out.println("Por favor elegir un número del 1 al " + (TICKET_CATEGORY.length));
                                    userCategory = input.nextInt();
                                }

                                userCategoryValidation = true;

                            } catch (InputMismatchException e) {
                                System.out.println("Por favor seleccione un número entero ");
                                input.nextLine();
                            }
                        }

                        ticketAmmount++; //Se suma la entrada vendida
                        ticketID++; //Incrementa en 1 la ID de la entrada

                        salesList.add(new SalesMoro(ticketID - 1, //Agregar a la lista de ventas
                                TICKET_CATEGORY[userCategory - 1],
                                totalDiscount,
                                TICKET_PRICE[userCategory - 1] * (1 - totalDiscount))); //Calculo del precio final

                        System.out.println("Entrada exitosa, asignado el ID " + ticketID);
                    }

                    totalDiscount = 0; //Reiniciar el cálculo de descuento

                    break;

                case 2:
                    boolean userModifyValidation = false;

                    while (!userModifyValidation) {
                        try {
                            System.out.print("Elige el ID de la reserva que quiere eliminar: ");
                            int userModify = input.nextInt(); //Variable del usuario de la ID a modificar

                            while (userModify <= 0) {
                                System.out.println("Por favor elija una ID válida");
                                userModify = input.nextInt();
                            }

                            int removeID = userModify -1; //Para encontrar la ID correcta

                            boolean ifRemoved = salesList.removeIf(salesMoro1 -> salesMoro1.getIdTicket() == removeID);//Remover el ID de la entrada, el ID queda inutilizable

                            if (ifRemoved) {
                                System.out.println("Entrada eliminada con éxito");
                                ticketAmmount--; //Eliminar del contador
                            } else
                                System.out.println("No se ha encontrado una entrada con el ID proporcionado");

                            userModifyValidation = true;

                        } catch (InputMismatchException e) {
                            System.out.println("Por favor seleccionar un número entero");
                        }
                    }
                    break;

                case 3:
                    double grossIncome = 0; //Inicialización de las ventas

                    System.out.println("Entradas vendidas: " + ticketAmmount);
                    System.out.print("El teatro tiene ventas totales de: ");
                    for (SalesMoro salesMoro: salesList) {
                        grossIncome += salesMoro.getFinalPriceTicket();
                    }

                    System.out.println(grossIncome);
                    break;

                case 4:
                    System.out.println("Elija la ID de la boleta que desea emitir");
                    boolean userReceiptValidation = false;
                    int userReceipt; //Variable del número de la boleta

                    boolean ifReceipt = false;

                    while (!userReceiptValidation) {
                        try {
                            userReceipt = input.nextInt();
                            userReceipt = userReceipt - 1;

                            userReceiptValidation = true;

                            for (SalesMoro salesMoro: salesList) {
                                if (salesMoro.getIdTicket() == userReceipt) {
                                    System.out.println(salesList.get(userReceipt));
                                    ifReceipt = true;
                                }
                            }

                        } catch (InputMismatchException e) {
                            System.out.println("Por favor seleccionar un número entero");
                        }

                        if (ifReceipt) {
                            System.out.println();
                            System.out.println("Boleta emitida con éxito");
                        } else
                            System.out.println("Boleta no pudo ser emitida");
                    }
                    break;

            }

        } while (mainMenuOption != 5);

        System.out.println("¡Muchas gracias por su preferencia!"); //Mensaje de finalización

    }

    private static void mainMenu() {
        System.out.println("=======MENU=======");
        for (int i = 0; i <= MoroVariables.MAIN_MENU.length - 1; i++) {
            System.out.println((i + 1) + ". " + MoroVariables.MAIN_MENU[i]);
        }
    }

    private static void calculateDiscount() {
        if (userAge >= 65) {
            totalDiscount = totalDiscount + TICKET_DISCOUNTS_AGE[0];
        }

        if (userAge <= 12) {
            totalDiscount = totalDiscount + TICKET_DISCOUNTS_AGE[1];
        }

        if (Objects.equals(userGender, "F")) {
            totalDiscount = totalDiscount + TICKET_DISCOUNTS_GENDER[0];
        }

        System.out.println("Su descuento total es: %" + (totalDiscount * 100));
    }
}

