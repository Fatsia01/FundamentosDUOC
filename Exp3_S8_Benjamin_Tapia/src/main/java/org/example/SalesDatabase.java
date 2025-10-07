package org.example;

public class SalesDatabase {

    private int salesID; // ID de la entrada
    private String salesEvent; // Tipo de obra que vió el cliente
    private String salesCategory; //Tipo de entrada que compró el cliente
    private double salesDiscountType; // Tipo de descuento del cliente
    private double salesFinalPrice; //Precio final de la entrada
    private String clientName;
    private String clientEmail;

    public SalesDatabase(int salesID, String salesEvent, String salesCategory, double salesDiscountType, double salesFinalPrice, String clientName, String clientEmail) {
        this.salesID = salesID;
        this.salesEvent = salesEvent;
        this.salesCategory = salesCategory;
        this.salesDiscountType = salesDiscountType;
        this.salesFinalPrice = salesFinalPrice;
        this.clientName = clientName;
        this.clientEmail = clientEmail;

    }

    public SalesDatabase() {

    }

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public String getSalesEvent() {
        return salesEvent;
    }

    public void setSalesEvent(String salesEvent) {
        this.salesEvent = salesEvent;
    }

    public String getSalesCategory() {
        return salesCategory;
    }

    public void setSalesCategory(String salesCategory) {
        this.salesCategory = salesCategory;
    }

    public double getSalesDiscountType() {
        return salesDiscountType;
    }

    public void setSalesDiscountType(double salesDiscountType) {
        this.salesDiscountType = salesDiscountType;
    }

    public double getSalesFinalPrice() {
        return salesFinalPrice;
    }

    public void setSalesFinalPrice(double salesFinalPrice) {
        this.salesFinalPrice = salesFinalPrice;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return  "ID de la venta = " + salesID + "\n" +
                "Nombre del evento = " + salesEvent + "\n" +
                "Categoria de la entrada = " + salesCategory + "\n" +
                "Tipo de descuento = " + salesDiscountType + "\n" +
                "Precio final de la entrada =  " + salesFinalPrice + "\n" +
                "Nombre del cliente = " + clientName + "\n" +
                "Correo del cliente = " + clientEmail +  "\n";
    }
}
