package org.example;

public class teatroMoro {

    //Variables estaticas
    private static int entradasReservadas = 0;
    private static int entradasOcupadas = 0;

    //Variables de instancia
    private int numeroAsiento;
    private boolean asientoReservado;
    private boolean asientoOcupado;

    public teatroMoro(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
        this.asientoReservado = false;
        this.asientoOcupado = false;
    }

    public boolean reservar() {
        if(!asientoReservado && !asientoOcupado) {
            asientoReservado = true;
            entradasReservadas++;
            return true;
        }
        return false;
    }

    public boolean modificarAsiento() {
        if (asientoReservado && !asientoOcupado) {
            asientoReservado = false;
            entradasReservadas--;
            return true;
        }
        return false;
    }

    public boolean ocupar() {
        if (asientoReservado && !asientoOcupado) {
            asientoReservado = false;
            asientoOcupado = true;
            entradasOcupadas++;
            return true;
        }
        return false;
    }

    //Getter Setters
    public int getNumeroAsiento() {
        return numeroAsiento;
    }




}