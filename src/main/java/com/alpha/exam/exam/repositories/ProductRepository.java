package com.alpha.exam.exam.repositories;

import com.alpha.exam.exam.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByContinent(String continent);

}
