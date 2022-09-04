package com.example.ordersrestapi.services;

import com.example.ordersrestapi.exceptions.models.RestauranteException;
import com.example.ordersrestapi.models.DTO.RestauranteDTO;
import com.example.ordersrestapi.models.Restaurante;
import com.example.ordersrestapi.repositories.RestauranteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final ModelMapper modelMapper;


    public RestauranteService(RestauranteRepository restauranteRepository, ModelMapper modelMapper) {
        this.restauranteRepository = restauranteRepository;
        this.modelMapper = modelMapper;
    }

    public List<RestauranteDTO>findAll(){

        return restauranteRepository.findAll()
                .stream()
                .map(restaurante -> modelMapper.map(restaurante, RestauranteDTO.class))
                .collect(Collectors.toList());

    }

    public  Restaurante findById(Long id){

        return restauranteRepository.findById(id)
                .orElseThrow(()-> new RestauranteException("Restaurante com esse ID não existe"));

    }

    public void save(Restaurante restaurante){
            restauranteRepository.save(restaurante);
    }

    public void deleteById(Long id){

        Restaurante restaurante = findById(id);

        restauranteRepository.delete(restaurante);
    }
}
