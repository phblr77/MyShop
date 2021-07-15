package ru.geekbrains.shop.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.services.ProductService;
import ru.geekbrains.shop.utils.ProductNotFoundException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop/")
public class RestProductController {

    private final ProductService productService;


    //получение всех товаров [ GET .../app/products ]
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }


    //создание нового товара [ POST .../app/products ]
    @PostMapping("/products/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            product.setId(null);
        }
        return productService.saveNewProduct(product);
    }


    //получение товара по id [ GET .../app/products/{id} ]
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable Long id) {
        if (!productService.existsById(id)) {
            throw new ProductNotFoundException("Product not found, id: " + id);
        }
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }


//удаление товара по id.[ GET .../app/products/delete/{id} ]

    @DeleteMapping("/products/{id}")
    public String deleteOneProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "OK";
    }


}
