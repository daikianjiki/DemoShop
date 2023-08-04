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
}
