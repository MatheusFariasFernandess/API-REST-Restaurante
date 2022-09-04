package com.example.ordersrestapi.services;

import com.example.ordersrestapi.models.FormasDePagamento;
import com.example.ordersrestapi.repositories.FormaDePagamentoRepository;
import com.example.ordersrestapi.resources.FormaDePagamantoResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FormaDePagamentoService {

    private final FormaDePagamentoRepository formaDePagamentoRepository;


    public FormaDePagamentoService(FormaDePagamentoRepository formaDePagamentoRepository) {
        this.formaDePagamentoRepository = formaDePagamentoRepository;
    }

    public FormasDePagamento findById(Long id){

        return formaDePagamentoRepository.findById(id)
                .orElseThrow( ()-> new NoSuchElementException("Forma de pagamento inexistente"));

    }

    public List<FormasDePagamento> findAll(){
        return formaDePagamentoRepository.findAll();
    }

    public void deleteById(Long id){
        FormasDePagamento formasDePagamento = findById(id);

        formaDePagamentoRepository.delete(formasDePagamento);
    }

    public void cadastrarFormaPagamento(FormasDePagamento formasDePagamento){

        formaDePagamentoRepository.save(formasDePagamento);

    }

}
