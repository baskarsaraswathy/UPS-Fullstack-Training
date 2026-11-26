package com.shop.ecommerce.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.shop.ecommerce.exception.ResourceNotFoundException;
import com.shop.ecommerce.model.*;
import com.shop.ecommerce.repository.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository; this.categoryRepository = categoryRepository;
    }
    public List<Product> getAllProducts() { return productRepository.findAll(); }
    public List<Product> getProductsByCategory(Long categoryId) { return productRepository.findByCategoryId(categoryId); }
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
    }
    public Product createProduct(Product product) {
        attachCategory(product);
        return productRepository.save(product);
    }
    private void attachCategory(Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Long cid = product.getCategory().getId();
            Category cat = categoryRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + cid));
            product.setCategory(cat);
        }
    }
}