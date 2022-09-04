package com.example.ordersrestapi.services;

import com.example.ordersrestapi.exceptions.models.ProdutosException;
import com.example.ordersrestapi.models.Produtos;
import com.example.ordersrestapi.repositories.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutosRepository produtosRepository;

    public ProdutoService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public List<Produtos>findAll(){
        return produtosRepository.findAll();
    }

    public Produtos findById(Long id){
       return   produtosRepository.findById(id)
                .orElseThrow( ()-> new ProdutosException("Produto com o id:"+ id+" não existe") );
    }

    public void salvarProduto(Produtos produtos){
        produtosRepository.save(produtos);
    }

    public void deletarProdutoPorId(Long id){

        Produtos produtos = findById(id);

        produtosRepository.delete(produtos);

    }
}
