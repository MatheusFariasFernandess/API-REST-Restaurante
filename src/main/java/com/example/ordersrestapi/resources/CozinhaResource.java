package com.example.ordersrestapi.resources;

import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.models.DTO.CozinhaDTO;
import com.example.ordersrestapi.models.Restaurante;
import com.example.ordersrestapi.services.CozinhaService;
import com.example.ordersrestapi.services.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CozinhaResource {

    private final CozinhaService cozinhaService;

    private final RestauranteService restauranteService;

    public CozinhaResource(CozinhaService cozinhaService, RestauranteService restauranteService) {
        this.cozinhaService = cozinhaService;
        this.restauranteService = restauranteService;
    }

    @GetMapping("cozinhas/buscar/por-id/{id}")
    public ResponseEntity<Cozinha>acharPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(cozinhaService.findById(id));
    }

    @GetMapping("cozinhas/buscar/todos")
    public ResponseEntity<List<CozinhaDTO>>buscarTodos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(cozinhaService.findAll());
    }

    @PostMapping("cozinhas/cadastrar")
    public ResponseEntity<?>cadastrar(@Valid @RequestBody Cozinha cozinha){

        cozinhaService.saveCozinha(cozinha);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("cozinhas/deletar/por-id/{id}")
    public ResponseEntity<HttpStatus>deletar(@PathVariable("id")Long id) {

        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @PutMapping("cozinhas/atualizar/por-id/{id}")
    public ResponseEntity<Cozinha>deletarPorId(@PathVariable("id")Long id,
                                                  @RequestBody Cozinha cozinha){

        Cozinha cozinhaUpdated = cozinhaService.findById(id);

        BeanUtils.copyProperties(cozinha,cozinhaUpdated);

        cozinhaService.saveCozinha(cozinhaUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cozinhaUpdated);
    }

}
