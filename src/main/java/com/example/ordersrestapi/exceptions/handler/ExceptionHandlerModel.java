package com.example.ordersrestapi.exceptions.handler;

import com.example.ordersrestapi.exceptions.models.CozinhaException;
import com.example.ordersrestapi.exceptions.models.ErroModel;
import com.example.ordersrestapi.exceptions.models.RestauranteException;
import com.example.ordersrestapi.exceptions.models.UsuarioException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.websocket.OnClose;

@ControllerAdvice
public class ExceptionHandlerModel extends ResponseEntityExceptionHandler {

    public ResponseEntity<Object>invalidFormatDataException(InvalidFormatException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErroModel.builder.anErroModel()
                        .tittle("Formato invalido exception")
                        .message(e.getLocalizedMessage())
                        .detail("Algum campo está com o formato do dado incompativel")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .build());

    }

    @Override
    protected ResponseEntity<Object>handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                 HttpHeaders headers, HttpStatus status, WebRequest request){
        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        if(rootCause instanceof InvalidFormatException ){
            return invalidFormatDataException((InvalidFormatException) rootCause );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErroModel.builder.anErroModel()
                .tittle("Mensagem não compreendida")
                .message(rootCause.getMessage())
                .detail("corpo da requisição está com algum campo invalido ou erro de sintaxe")
                .status(HttpStatus.BAD_REQUEST.value())
                .build());


    }

    @ExceptionHandler(CozinhaException.class)
    public ResponseEntity<ErroModel>cozinhaNaoEncontrada(CozinhaException cozinha){

        Throwable rootCause = ExceptionUtils.getRootCause(cozinha);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                     ErroModel.builder.anErroModel()
                        .tittle("Cozinha não encontrada")
                        .message(cozinha.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .detail("Insira uma cozinha com id existente")
                        .build()
        );
    }

    @ExceptionHandler(RestauranteException.class)
    public ResponseEntity<ErroModel>restauranteNaoEncontrado(RestauranteException restaurante) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErroModel.builder.anErroModel()
                .tittle("Restaurante não encontrad0")
                .message(restaurante.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .detail("Insira um restaurante com id existente")
                .build()
        );
    }

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<ErroModel>usuarioNaoEncontraro(UsuarioException usuario){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErroModel.builder.anErroModel()
                .tittle("Usuario não encontrado")
                .message(usuario.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .detail("insiar um ID valido de usuario")
                .build()
        );


    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroModel>dataIntegrity(DataIntegrityViolationException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErroModel.builder.anErroModel()
                .tittle("Data Integrity Violation ")
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .detail("Alguma informação invalida")
                .build()
        );
    }
}
