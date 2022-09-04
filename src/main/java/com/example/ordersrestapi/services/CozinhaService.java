package com.example.ordersrestapi.services;

import com.example.ordersrestapi.exceptions.models.CozinhaException;
import com.example.ordersrestapi.models.Cozinha;
import com.example.ordersrestapi.models.DTO.CozinhaDTO;
import com.example.ordersrestapi.repositories.CozinhaRespository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CozinhaService {

    private final CozinhaRespository cozinhaRespository;

    private final ModelMapper modelMapper;
    public CozinhaService(CozinhaRespository cozinhaRespository, ModelMapper modelMapper) {
        this.cozinhaRespository = cozinhaRespository;
        this.modelMapper = modelMapper;
    }

//
//    public List<CozinhaDTO>findAll(){
//        return cozinhaRespository.findAll()
//                .stream()
//                .map(cozinha -> modelMapper.map(cozinha, CozinhaDTO.class))
//                .collect(Collectors.toList());
//
//    }


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

        try {
            Cozinha cozinha = findById(id);

            cozinhaRespository.delete(cozinha);

        }catch (DataIntegrityViolationException e){
            throw new CozinhaException("Cozinha com o ID " + id +" já está em uso por algum ou alguns restaurantes");
        }

    }
}
