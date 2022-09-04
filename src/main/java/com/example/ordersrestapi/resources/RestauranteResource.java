package com.example.ordersrestapi.resources;

import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.models.DTO.RestauranteDTO;
import com.example.ordersrestapi.models.Restaurante;
import com.example.ordersrestapi.services.CozinhaService;
import com.example.ordersrestapi.services.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestauranteResource {

    private final RestauranteService restauranteService;

    private final CozinhaService cozinhaService;

    public RestauranteResource(RestauranteService restauranteService, CozinhaService cozinhaService) {
        this.restauranteService = restauranteService;
        this.cozinhaService = cozinhaService;
    }


    @GetMapping("/restaurantes/buscar/todos")
    public ResponseEntity<List<Restaurante>>listarTodos(){
        return ResponseEntity.ok().body(restauranteService.findAll());
    }

    @GetMapping("/restaurantes/buscar/por-id/{id}")
    public ResponseEntity<Restaurante>findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(restauranteService.findById(id));
    }
    @PostMapping("/restaurantes/cadastrar")
    public ResponseEntity<?>cadastrar(@RequestBody Restaurante restaurante){

         restauranteService.save(restaurante);

         return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
    }

    @PutMapping("/restaurantes/atualizar/por-id/{id}")
    public ResponseEntity<Restaurante>atualizarRestaurante(@PathVariable("id")Long id,
                                                           @RequestBody Restaurante restaurante){

        Restaurante restauranteUpdated = restauranteService.findById(id);

        BeanUtils.copyProperties(restaurante,restauranteUpdated,"id");

        restauranteService.save(restauranteUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(restauranteUpdated);
    }

    @DeleteMapping("/restaurantes/deletar/por-id/{id}")
    public ResponseEntity<?>deletePorId(@PathVariable("id") Long id){

        restauranteService.deleteById(id);

        return ResponseEntity.status(HttpStatus.GONE).build();
    }

}
