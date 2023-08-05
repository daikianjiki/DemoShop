package com.DemoShop.Controllers;

import com.DemoShop.Models.Product;
import com.DemoShop.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<?>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

}
