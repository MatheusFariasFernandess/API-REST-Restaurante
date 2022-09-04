package com.example.ordersrestapi.repositories;

import com.example.ordersrestapi.models.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {

//    @Query(value = "select * from restaurante_tb rest " +
//            " inner join cozinha_tb cozinha " +
//            " where rest.cozinha_id = cozinha.id  "+
//            " order by rest.restaurante_nome ",nativeQuery = true)
    List<Restaurante>findAll();

}
