package com.example.ordersrestapi.repositories;

import com.example.ordersrestapi.models.FormasDePagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormasDePagamento,Long> {
}
