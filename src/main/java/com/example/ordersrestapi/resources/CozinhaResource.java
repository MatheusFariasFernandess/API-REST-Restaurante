package com.example.ordersrestapi.resources;

import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.services.CozinhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cozinhas")
public class CozinhaResource {

    private final CozinhaService cozinhaService;


    public CozinhaResource(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }

    @GetMapping("/buscar/por-id/{id}")
    public ResponseEntity<Cozinha>acharPorId(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(cozinhaService.findById(id));
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<Cozinha>>buscarTodos(){
        return ResponseEntity.status(HttpStatus.FOUND).body(cozinhaService.findAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?>cadastrar(@Valid @RequestBody Cozinha cozinha){

        cozinhaService.saveCozinha(cozinha);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/deletar/por-id/{id}")
    public ResponseEntity<HttpStatus>deletar(@PathVariable("id")Long id) {
        Cozinha cozinha = cozinhaService.findById(id);

        cozinhaService.deleteById(id);

        return ResponseEntity.status(HttpStatus.GONE).build();
    }

    @PutMapping("/atualizar/por-id/{id}")
    public ResponseEntity<HttpStatus>deletarPorId(@PathVariable("id")Long id){

        cozinhaService.deleteById(id);

        return ResponseEntity.status(HttpStatus.GONE).build();
    }

}
