package com.alpha.exam.exam.controllers;

import com.alpha.exam.exam.DTO.InsertProductDTO;
import com.alpha.exam.exam.entities.Product;
import com.alpha.exam.exam.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getProduct(@RequestParam String continent) {
        return productService.getProductList(continent);
    }

    @PostMapping
    public void insertProduct(@RequestBody InsertProductDTO insertProductDTO) {

        productService.insertProduct(insertProductDTO)
    }
}
