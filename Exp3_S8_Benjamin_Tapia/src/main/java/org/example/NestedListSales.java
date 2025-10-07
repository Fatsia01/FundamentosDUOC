package org.example;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class NestedListSales {

    private int listSalesQuantity;
    private LocalDate listSalesDate;
    private double listSalesIncome;

    public NestedListSales(int listSalesQuantity, LocalDate listSalesDate, double listSalesIncome) {
        this.listSalesQuantity = listSalesQuantity;
        this.listSalesDate = listSalesDate;
        this.listSalesIncome = listSalesIncome;
    }

    public int getListSalesQuantity() {
        return listSalesQuantity;
    }

    public void setListSalesQuantity(int listSalesQuantity) {
        this.listSalesQuantity = listSalesQuantity;
    }

    public LocalDate getListSalesDate() {
        return listSalesDate;
    }

    public void setListSalesDate(LocalDate listSalesDate) {
        this.listSalesDate = listSalesDate;
    }

    public double getListSalesIncome() {
        return listSalesIncome;
    }

    public void setListSalesIncome(double listSalesIncome) {
        this.listSalesIncome = listSalesIncome;
    }

    @Override
    public String toString() {
        return
                "Cantidad de entradas = " + listSalesQuantity +
                " / Fecha de la compra = " + listSalesDate +
                " / Precio total de la compra = " + listSalesIncome;
    }
}

