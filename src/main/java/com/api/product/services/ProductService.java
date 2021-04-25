package com.api.product.services;

import java.util.Optional;

import com.api.product.models.repos.ProductRepo;
import com.api.product.models.utilities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    // findAll
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    // saveData
    public Product save(Product product) {
        return productRepo.save(product);
    }

    // findOne
    public Product findOne(Long id) {
        Optional<Product> product = productRepo.findById(id);

        if (!product.isPresent()) {
            return null;
        }

        return product.get();
    }

    // delete
    public void deleteOne(Long id) {
        productRepo.deleteById(id);
    }
}
