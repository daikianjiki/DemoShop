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
@CrossOrigin(origins = {"*"})
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

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable long id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }

}
