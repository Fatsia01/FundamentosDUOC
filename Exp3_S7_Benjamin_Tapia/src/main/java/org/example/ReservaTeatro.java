package org.example;

import static org.example.VentasTeatro.entradasVendidas;

public class ReservaTeatro {

    private String ubicacion; //Parametros de las reservas (también usados para las boletas)
    private double costoBase;
    private double descuentoAplicado;
    private double costoFinal;

    public ReservaTeatro(String ubicacion, double costoBase, double descuentoAplicado, double costoFinal) {
        this.ubicacion = ubicacion;
        this.costoBase = costoBase;
        this.descuentoAplicado = descuentoAplicado;
        this.costoFinal = costoFinal;
    }

    public ReservaTeatro() { // Clase vacía para el arraylist de reservas

    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    @Override //Utilizado para imprimir la/s boleta/s
    public String toString() {
        return "ReservaTeatro: "  +
                " / Ubicacion = " + ubicacion +
                " / Costo Base = " + costoBase +
                " / Descuento Aplicado = " + descuentoAplicado +
                " / Costo Final = " + costoFinal + "\n";
    }
}
