package com.example.ordersrestapi.resources;

import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.models.Produtos;
import com.example.ordersrestapi.services.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ProdutosResource {

    private final ProdutoService produtoService;


    public ProdutosResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos/buscar/todos")
    public ResponseEntity<List<Produtos>>buscarTodosProdutos(){
        return ResponseEntity.ok().body(produtoService.findAll());
    }

    @GetMapping("/produtos/buscar/por-id/{id}")
    public ResponseEntity<Produtos>buscarProdutoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @PostMapping("/produtos/cadastrar")
    public ResponseEntity<HttpStatus>cadastrar(@RequestBody @Valid Produtos produtos){

        produtoService.salvarProduto(produtos);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("produtos/atualizar/por-id/{id}")
    public ResponseEntity<HttpStatus>atualizar(@PathVariable("id")Long id,
                                                @RequestBody Produtos produtos){
        Produtos produtosUpdated = produtoService.findById(id);

        BeanUtils.copyProperties(produtos,produtosUpdated,"id");

        produtoService.salvarProduto(produtosUpdated);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
