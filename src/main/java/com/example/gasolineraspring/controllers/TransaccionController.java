package com.example.gasolineraspring.controllers;

import com.example.gasolineraspring.dtos.TransaccionDTO;
import com.example.gasolineraspring.models.Transaccion;
import com.example.gasolineraspring.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping("/")
    public ResponseEntity<Object> registrarTransaccion(@RequestBody TransaccionDTO transaccion){
        return transaccionService.registrarTransaccion(transaccion);
    }

    @GetMapping("/{nitCliente}")
    public ResponseEntity<Object> obtenerPuntosCliente(@PathVariable String nitCliente){
        return transaccionService.obtenerPuntosCliente(nitCliente);
    }
}
