package com.example.ordersrestapi.services;

import com.example.ordersrestapi.exceptions.models.CozinhaException;
import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.repositories.CozinhaRespository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    private final CozinhaRespository cozinhaRespository;

    private final ModelMapper modelMapper;
    public CozinhaService(CozinhaRespository cozinhaRespository, ModelMapper modelMapper) {
        this.cozinhaRespository = cozinhaRespository;
        this.modelMapper = modelMapper;
    }


    public List<Cozinha>findAll(){
        return cozinhaRespository.findAll();
    }

    public Cozinha findById(Long id){
        return cozinhaRespository.findById(id)
                .orElseThrow( ()-> new CozinhaException("Cozinha com o ID:"+ id +" não existe"));
    }

    public void saveCozinha(Cozinha cozinha){
        cozinhaRespository.save(cozinha);
    }

    public void deleteById(Long id) {

        Cozinha cozinha = this.findById(id);

        try {
              if(cozinha.getRestaurantes()!=null) {
                  cozinhaRespository.delete(cozinha);
              }
        }catch (DataIntegrityViolationException e){
            throw new CozinhaException("Esta cozinha esta associada a um restaurante");
         }

    }
}
