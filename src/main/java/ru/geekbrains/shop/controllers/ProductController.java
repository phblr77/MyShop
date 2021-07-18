package ru.geekbrains.shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.services.ProductService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return productService.findAll();
    }

    // http://localhost:8189/shop/products/page?p=1
    @GetMapping("/products_page")
    public Page<Product> findPage(@RequestParam(name = "p") int pageIndex) {
        return productService.findPage(pageIndex - 1, 10);
    }


    @DeleteMapping("/products/{id}")
    public String deleteOneProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "OK";
    }
}