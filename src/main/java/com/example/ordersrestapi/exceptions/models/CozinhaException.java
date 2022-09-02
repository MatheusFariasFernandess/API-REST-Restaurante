package com.example.ordersrestapi.exceptions.models;



public class CozinhaException extends RuntimeException {

    public CozinhaException(String msg){
        super(msg);
    }

    public CozinhaException(){}
}
