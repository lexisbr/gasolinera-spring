package com.example.gasolineraspring.dtos;

public class TransaccionDTO {
    private int idTanque;
    private String nitCliente;
    private double galonesServidos;
    private String tipoPago;
    private double precioPorGalon;
    private int idEmpleado;
    private int idCliente;
    private boolean pagarConPuntos;

    private double totalPagar;

    public int getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(int idTanque) {
        this.idTanque = idTanque;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public double getGalonesServidos() {
        return galonesServidos;
    }

    public void setGalonesServidos(double galonesServidos) {
        this.galonesServidos = galonesServidos;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getPrecioPorGalon() {
        return precioPorGalon;
    }

    public void setPrecioPorGalon(double precioPorGalon) {
        this.precioPorGalon = precioPorGalon;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isPagarConPuntos() {
        return pagarConPuntos;
    }

    public void setPagarConPuntos(boolean pagarConPuntos) {
        this.pagarConPuntos = pagarConPuntos;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
