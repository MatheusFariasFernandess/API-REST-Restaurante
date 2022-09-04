package com.example.ordersrestapi.repositories;

import com.example.ordersrestapi.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos,Long> {

//
//    @Query(value = "select * from produtos_tb produtos " +
//            "order by produtos_tb.produto_nome",nativeQuery = true)
    List<Produtos>findAll();

}
