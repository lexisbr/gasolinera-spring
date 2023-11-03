package com.example.gasolineraspring.dtos;

public class AcumularPuntosDTO {
    private int idCliente;
    private double galonesComprados;

    public AcumularPuntosDTO(int idCliente, double galonesComprados) {
        this.idCliente = idCliente;
        this.galonesComprados = galonesComprados;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getGalonesComprados() {
        return galonesComprados;
    }

    public void setGalonesComprados(double galonesComprados) {
        this.galonesComprados = galonesComprados;
    }
}
