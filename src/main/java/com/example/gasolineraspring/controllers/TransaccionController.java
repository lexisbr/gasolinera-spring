package com.example.gasolineraspring.controllers;

import com.example.gasolineraspring.dtos.TransaccionDTO;
import com.example.gasolineraspring.models.Transaccion;
import com.example.gasolineraspring.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaccion")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping("/")
    public Transaccion registrarTransaccion(@RequestBody TransaccionDTO transaccion){
        return transaccionService.registrarTransaccion(transaccion);
    }
}
