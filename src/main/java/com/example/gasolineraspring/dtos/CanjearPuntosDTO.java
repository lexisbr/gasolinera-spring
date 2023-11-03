package com.example.gasolineraspring.dtos;

public class CanjearPuntosDTO {

    private int idCliente;
    private double puntosCanje;

    public CanjearPuntosDTO(int idCliente, double puntosCanje) {
        this.idCliente = idCliente;
        this.puntosCanje = puntosCanje;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getPuntosCanje() {
        return puntosCanje;
    }

    public void setPuntosCanje(double puntosCanje) {
        this.puntosCanje = puntosCanje;
    }
}
