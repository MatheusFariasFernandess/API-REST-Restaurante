package com.example.ordersrestapi.services;

import com.example.ordersrestapi.exceptions.models.CozinhaException;
import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.repositories.CozinhaRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    private final CozinhaRespository cozinhaRespository;


    public CozinhaService(CozinhaRespository cozinhaRespository) {
        this.cozinhaRespository = cozinhaRespository;
    }


    public List<Cozinha>findAll(){
        return cozinhaRespository.findAll();
    }


    public Cozinha findById(Long id){
        return cozinhaRespository.findById(id)
                .orElseThrow( ()-> new CozinhaException("Cozinha com este ID não existe"));
    }

    public void saveCozinha(Cozinha cozinha){
        cozinhaRespository.save(cozinha);
    }

    public void deleteById(Long id) {

        Cozinha cozinha = findById(id);

        cozinhaRespository.delete(cozinha);
    }
}
