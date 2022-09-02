package com.example.ordersrestapi.exceptions.handler;

import com.example.ordersrestapi.exceptions.models.CozinhaException;
import com.example.ordersrestapi.exceptions.models.ErroModel;
import com.example.ordersrestapi.exceptions.models.RestauranteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerModel {

    @ExceptionHandler(CozinhaException.class)
    public ResponseEntity<ErroModel>cozinhaNaoEncontrada(CozinhaException cozinha){
            ErroModel erroModel = ErroModel.builder.anErroModel()
                    .tittle("Cozinha não encontrada")
                    .message(cozinha.getMessage())
                    .status(HttpStatus.NOT_FOUND.value())
                    .detail("Insira uma cozinha com id existente")
//                    .intance(cozinha.getCause().getMessage())
                    .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroModel);
    }

    @ExceptionHandler(RestauranteException.class)
    public ResponseEntity<ErroModel>restauranteNaoEncontrado(RestauranteException restaurante) {
        ErroModel erroModel = ErroModel.builder.anErroModel()
                .tittle("Restaurante não encontrad0")
                .message(restaurante.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .detail("Insira um restaurante com id existente")
//                .intance(restaurante.getCause().getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroModel);
    }
}
