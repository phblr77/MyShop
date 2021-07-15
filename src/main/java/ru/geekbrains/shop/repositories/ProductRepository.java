package ru.geekbrains.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.shop.model.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
