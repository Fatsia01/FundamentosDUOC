package org.example;

public class SalesPerEvent {

    private int eventID;
    private String eventName;
    private NestedListSales nestedListSales;

    public SalesPerEvent(int eventID, String eventName, NestedListSales nestedListSales) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.nestedListSales = nestedListSales;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public NestedListSales getNestedListSales() {
        return nestedListSales;
    }

    public void setNestedListSales(NestedListSales nestedListSales) {
        this.nestedListSales = nestedListSales;
    }

    @Override
    public String toString() {
        return "Ventas por evento: " + "\n" +
                "ID del evento = " + eventID + "\n" +
                "Nombre del evento = " + eventName + "\n" +
                "Lista de ventas = " + nestedListSales + "\n";
    }
}


