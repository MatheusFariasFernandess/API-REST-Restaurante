package com.example.ordersrestapi.exceptions.models;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CozinhaException extends RuntimeException {

    public CozinhaException(String msg){
        super(msg);
    }

}
