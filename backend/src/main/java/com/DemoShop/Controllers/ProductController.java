package com.DemoShop.Controllers;

import com.DemoShop.Models.Product;
import com.DemoShop.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<List<?>> getAllProducts() {
        return productService.getAllProducts();
    }
}
