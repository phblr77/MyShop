package ru.geekbrains.shop.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAllProducts() {
        return repository.findAllProducts();
    }

    public Product findById(long id) {
        return repository.findById(id);
    }

    public void saveNewProduct(String title, int price) {

        Product product = new Product(null, title, price);
        if (product.getPrice() <= 0) {
            return;
        }
        repository.save(product);
    }
}
