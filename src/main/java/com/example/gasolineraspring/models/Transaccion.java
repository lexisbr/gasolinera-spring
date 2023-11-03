package com.example.gasolineraspring.models;

import com.example.gasolineraspring.dtos.TransaccionDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private int idTransaccion;

    @Column(name = "id_tanque")
    private int idTanque;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "galones_servidos")
    private double galonesServidos;

    @Column(name = "tipo_pago")
    private String tipoPago;

    @Column(name = "precio_por_galon")
    private double precioPorGalon;

    @Column(name = "fecha_transaccion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTransaccion;

    @Column(name = "id_empleado")
    private int idEmpleado;

    @Column(name = "total_pagar")
    private double totalPagar;

    public Transaccion(TransaccionDTO transaccionDTO) {
        this.idTanque = transaccionDTO.getIdTanque();
        this.idCliente = transaccionDTO.getIdCliente();
        this.galonesServidos = transaccionDTO.getGalonesServidos();
        this.tipoPago = transaccionDTO.getTipoPago();
        this.precioPorGalon = transaccionDTO.getPrecioPorGalon();
        this.fechaTransaccion = new Date();
        this.idEmpleado = transaccionDTO.getIdEmpleado();
        this.totalPagar = transaccionDTO.getTotalPagar();
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdTanque() {
        return idTanque;
    }

    public void setIdTanque(int idTanque) {
        this.idTanque = idTanque;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
