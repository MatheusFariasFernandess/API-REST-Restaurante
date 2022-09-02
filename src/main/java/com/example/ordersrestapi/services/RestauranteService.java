package com.example.ordersrestapi.services;

import com.example.ordersrestapi.exceptions.models.RestauranteException;
import com.example.ordersrestapi.models.Restaurante;
import com.example.ordersrestapi.repositories.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;


    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante>findAll(){
        return restauranteRepository.findAll();
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
