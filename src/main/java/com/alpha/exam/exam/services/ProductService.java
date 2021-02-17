package com.alpha.exam.exam.services;

import com.alpha.exam.exam.DTO.InsertProductDTO;
import com.alpha.exam.exam.entities.Product;
import com.alpha.exam.exam.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    final
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(String continent) {
        return productRepository.findAllByContinent(continent);
    }

    public void insertProduct(InsertProductDTO insertProductDTO) {

//        return productRepository.save();
    }
}
