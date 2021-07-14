package ru.geekbrains.shop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.shop.services.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // GET http://localhost:8189/shop

    @GetMapping
    public String showMainPage(Model model){
        model.addAttribute("products", productService.findAllProducts());
        return "index";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(){
        return "add_product_form";
    }

    @PostMapping("/products/add")
    public String saveNewProduct(@RequestParam String title, @RequestParam int price){
        productService.saveNewProduct(title, price);
        return "redirect:/";
    }

    @GetMapping("/products/{id}")
    public String showProductInfo(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }
}
