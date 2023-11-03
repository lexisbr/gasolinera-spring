package com.example.gasolineraspring.services;

import com.example.gasolineraspring.dtos.TransaccionDTO;
import com.example.gasolineraspring.models.Transaccion;
import com.example.gasolineraspring.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;
    @Autowired
    private RestTemplate restTemplate;

    private final String clientesApi = "http://localhost:3000/clientes";

    public Transaccion registrarTransaccion(TransaccionDTO transaccion){
        // TODO Verificar que el tanque tenga la gasolina suficiente

        System.out.println("Entra");
        String idCliente = restTemplate
                .getForObject(clientesApi+"/"+transaccion.getNitCliente(), String.class);
        System.out.println(idCliente);
        transaccion.setIdCliente(Integer.parseInt(idCliente.toString()));

        Transaccion transaccionFinal = new Transaccion(transaccion);

        return transaccionRepository.save(transaccionFinal);
    }
}
