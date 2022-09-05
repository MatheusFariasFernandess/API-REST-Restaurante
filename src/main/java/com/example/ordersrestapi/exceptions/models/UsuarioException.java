package com.example.ordersrestapi.exceptions.models;


import com.example.ordersrestapi.repositories.UsuarioRepository;

public class UsuarioException extends RuntimeException{

    public UsuarioException(String msg){
        super(msg);
    }

}
