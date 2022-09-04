package com.example.ordersrestapi.resources;

import com.example.ordersrestapi.models.FormasDePagamento;
import com.example.ordersrestapi.services.FormaDePagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FormaDePagamantoResource {

    private final FormaDePagamentoService formaDePagamentoService;

    public FormaDePagamantoResource(FormaDePagamentoService formaDePagamentoService) {
        this.formaDePagamentoService = formaDePagamentoService;
    }

    @GetMapping("/formasDePagamento/buscar/todos")
    public ResponseEntity<List<FormasDePagamento>>buscarFormasDePagamento(){
        return ResponseEntity.status(HttpStatus.FOUND).body(formaDePagamentoService.findAll());
    }

    @PostMapping("/formasDePagamento/cadastrar")
    public ResponseEntity<HttpStatus>cadastrarFormaPagamento(@RequestBody FormasDePagamento formasDePagamento){
        formaDePagamentoService.cadastrarFormaPagamento(formasDePagamento);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/formasDePagamento/excluir/por-id/{id}")
    public ResponseEntity<HttpStatus>excluirPorId(@PathVariable("id")Long id){

        formaDePagamentoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.GONE).build();
    }
}
