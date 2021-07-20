package ru.geekbrains.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//1. Сделайте страницу для отображения всех товаров.
//2. Рядом с каждым товаром в таблице попробуйте сделать кнопку “Удалить”, при нажатии на которую товар должен
// быть удален и базы.
//3. * Попробуйте реализовать разбивку всех товаров на страницы, по 10 товаров на каждой.


@SpringBootApplication
public class MyShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyShopApplication.class, args);
    }

}
