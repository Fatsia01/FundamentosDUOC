package org.example;

public class SalesMoro {

    //Variables de la boleta
    private int idTicket; //ID del ticket
    private String categoryTicket; // Tipo de entrada (VIP, Platea, etc)
    private double totalDiscountTicket; //Descuento total del ticket
    private double finalPriceTicket; //Costo final del ticket

    public SalesMoro (int idTicket, String categoryTicket, double totalDiscountTicket, double finalPriceTicket) {
        this.idTicket = idTicket;
        this.categoryTicket = categoryTicket;
        this.totalDiscountTicket = totalDiscountTicket;
        this.finalPriceTicket = finalPriceTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getCategoryTicket() {
        return categoryTicket;
    }

    public void setCategoryTicket(String categoryTicket) {
        this.categoryTicket = categoryTicket;
    }

    public double getTotalDiscountTicket() {
        return totalDiscountTicket;
    }

    public void setTotalDiscountTicket(double totalDiscountTicket) {
        this.totalDiscountTicket = totalDiscountTicket;
    }

    public double getFinalPriceTicket() {
        return finalPriceTicket;
    }

    public void setFinalPriceTicket(double finalPriceTicket) {
        this.finalPriceTicket = finalPriceTicket;
    }

    @Override
    public String toString() {
        return "Venta de ID :" + (idTicket + 1) + "\n" +
                " Categoría del ticket :" + categoryTicket + "\n" +
                " Descuento del ticket : %" + (totalDiscountTicket * 100) + "\n" +
                " Precio final del ticket: " + finalPriceTicket;
    }
}
