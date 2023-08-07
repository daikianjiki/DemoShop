package com.DemoShop.Services;

import com.DemoShop.Models.Product;
import com.DemoShop.Repos.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public ResponseEntity<List<?>> getAllProducts() {
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getProductById(long id) {
        return new ResponseEntity<>(productRepo.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Product> createProduct(Product product) {
        return new ResponseEntity<>(productRepo.save(product), HttpStatus.CREATED);
    }

    public ResponseEntity<Product> updateProduct(Product product, long id) {
        if (productRepo.existsById(id)) {
            Product updatedProduct = productRepo.findById(id).get();
            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setImage(product.getImage());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setRating(product.getRating());
            updatedProduct.setReview(product.getReview());
            return new ResponseEntity<>(productRepo.save(updatedProduct), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
