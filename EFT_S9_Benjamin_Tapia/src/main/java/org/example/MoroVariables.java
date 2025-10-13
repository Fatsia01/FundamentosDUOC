package org.example;

public class MoroVariables {

    public static int ticketAmmount = 0; //Contador de entradas vendidas
    public static int ticketID = 0; //ID del ticket, similar a un número de factura

    public static final int TOTAL_TICKETS = 200; //Cantidad total de entradas

    //VARIABLES DE TICKETS
    public static final String[] TICKET_CATEGORY = {"VIP", "Platea Baja", "Platea Alta", "Palco", "Galeria"}; //Tipos de entradas del teatro
    public static final double[] TICKET_PRICE = {1000, 800, 600, 500, 450}; //Precios de las entradas por orden según categoría
    public static final double[] TICKET_DISCOUNTS_AGE = {0.3, 0.05, 0}; // 1. Tercera Edad / 2. Niños / 3. Ninguno
    public static final double[] TICKET_DISCOUNTS_GENDER = {0.07, 0};// 1. Mujer / 2. Hombre

    //MENUS
    public static final String[] MAIN_MENU = {"Comprar entrada", "Modificar reserva", "Ver ventas totales", "Imprimir boleta", "Salir"};







}
