package com.example.ordersrestapi.exceptions.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RestauranteException extends RuntimeException {

    public RestauranteException(String msg){
        super(msg);
    }

}
