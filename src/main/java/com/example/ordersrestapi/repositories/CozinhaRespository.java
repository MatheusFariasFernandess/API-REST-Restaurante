package com.example.ordersrestapi.repositories;

import com.example.ordersrestapi.models.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRespository extends JpaRepository<Cozinha,Long> {

    @Query(value = "select * from  cozinha_tb cozinhas " +
            " order by cozinhas.cozinha_nome",nativeQuery = true)
    List<Cozinha>findAll();



}
