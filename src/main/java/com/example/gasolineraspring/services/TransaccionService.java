package com.example.gasolineraspring.services;

import com.example.gasolineraspring.dtos.*;
import com.example.gasolineraspring.models.Transaccion;
import com.example.gasolineraspring.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;
    @Autowired
    private RestTemplate restTemplate;

    private final String clientesApi = "http://localhost:3000/clientes";
    private final String tanquesApi = "http://localhost:8000/transaccion/";

    private HttpHeaders headers = new HttpHeaders();

    public ResponseEntity<Object> registrarTransaccion(TransaccionDTO transaccion){
        headers.setContentType(MediaType.APPLICATION_JSON);

        String idCliente = restTemplate
                .getForObject(clientesApi+"/"+transaccion.getNitCliente(), String.class);

        int idClienteParsed = Integer.parseInt(idCliente.toString());
        double dineroGastado = transaccion.getGalonesServidos() * transaccion.getPrecioPorGalon();

        if(transaccion.isPagarConPuntos()){
            CanjearPuntosDTO request = new CanjearPuntosDTO(idClienteParsed, dineroGastado);
            HttpEntity<CanjearPuntosDTO> requestEntity = new HttpEntity<>(request, headers);
            ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(
                    clientesApi+"/canjear-puntos",
                    HttpMethod.PUT,
                    requestEntity,
                    ResponseDTO.class
            );

            System.out.println(responseEntity.getBody().getMessage());
            int pagoRestante = Integer.parseInt(responseEntity.getBody().getMessage());
            transaccion.setTotalPagar(pagoRestante);
        }else{
            AcumularPuntosDTO acumularPuntos = new AcumularPuntosDTO(idClienteParsed, transaccion.getGalonesServidos());
            HttpEntity<AcumularPuntosDTO> requestAcumular = new HttpEntity<>(acumularPuntos, headers);
            ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(
                    clientesApi+"/acumular-puntos",
                    HttpMethod.PUT,
                    requestAcumular,
                    ResponseDTO.class
            );

            transaccion.setTotalPagar(dineroGastado);
        }


        transaccion.setIdCliente(idClienteParsed);

        HttpEntity<TransaccionDTO> requestEntity = new HttpEntity<>(transaccion, headers);

        ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(
                tanquesApi,
                HttpMethod.POST,
                requestEntity,
                ResponseDTO.class
        );

        if(responseEntity.getBody().isSuccess()){
            Transaccion transaccionFinal = new Transaccion(transaccion);

            transaccionRepository.save(transaccionFinal);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("success", true);
            responseBody.put("message", "Transaccion registrada exitosamente");

            return ResponseEntity.ok(responseBody);
        }else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseEntity.getBody());
        }
    }

    public ResponseEntity<Object> obtenerPuntosCliente(String nitCliente){
        System.out.println(nitCliente);
        String puntosActuales = restTemplate
                .getForObject(clientesApi+"/consultar-puntos/"+nitCliente, String.class);


        if(!puntosActuales.equals("")){
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("success", true);
            responseBody.put("message", "Puntos que tiene el cliente: "+puntosActuales);

            return ResponseEntity.ok(responseBody);
        } else {

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("success", false);
            responseBody.put("message", "No pudimos encontrar los puntos del cliente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }

    }
}
