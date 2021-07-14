package ru.geekbrains.shop.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.utils.ResourceNotFoundException;

import javax.annotation.PostConstruct;
import java.util.*;


@Component
public class ProductRepository {
    private List<Product> products;


    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Apples", 2),
                new Product(2L, "Cake", 5),
                new Product(3L, "Meat", 8),
                new Product(4L, "Tomatoes", 3),
                new Product(5L, "Coffee", 4)
        ));
    }

    public List<Product> findAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new ResourceNotFoundException();
    }

    public void save(Product product) {
        product.setId(products.stream().mapToLong(Product::getId).max().getAsLong() + 1L);
        products.add(product);
    }

}
