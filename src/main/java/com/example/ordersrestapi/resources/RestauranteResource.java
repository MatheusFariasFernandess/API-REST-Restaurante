package com.example.ordersrestapi.resources;

import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.models.Restaurante;
import com.example.ordersrestapi.services.CozinhaService;
import com.example.ordersrestapi.services.RestauranteService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteResource {

    private final RestauranteService restauranteService;

    private final CozinhaService cozinhaService;

    public RestauranteResource(RestauranteService restauranteService, CozinhaService cozinhaService) {
        this.restauranteService = restauranteService;
        this.cozinhaService = cozinhaService;
    }


    @GetMapping("/buscar/todos")
    public ResponseEntity<List<Restaurante>>listarTodos(){
        return ResponseEntity.ok().body(restauranteService.findAll());
    }

    @GetMapping("/buscar/por-id/{id}")
    public ResponseEntity<Restaurante>findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(restauranteService.findById(id));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<?>cadastrar(@RequestBody Restaurante restaurante){

         restauranteService.save(restaurante);

         return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
    }

    @PutMapping("/atualizar/cozinha/por-id/{id}")
    public ResponseEntity<Restaurante>autalizarCozinha(@PathVariable("id") Long id,
                                                      @RequestBody Cozinha cozinha){

        Restaurante restaurante = restauranteService.findById(id);

        restaurante.setCozinhaIndividual(cozinha);

        return ResponseEntity.status(HttpStatus.OK).body(restauranteService.findById(id));
    }
}
