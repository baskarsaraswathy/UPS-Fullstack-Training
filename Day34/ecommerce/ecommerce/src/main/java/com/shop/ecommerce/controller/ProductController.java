package com.shop.ecommerce.controller;
import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.shop.ecommerce.model.Product;
import com.shop.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping
    public List<Product> getAll(@RequestParam(value = "categoryId", required = false) Long categoryId) {
        return categoryId != null ? productService.getProductsByCategory(categoryId) : productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getOne(@PathVariable("id") Long id) { return productService.getProduct(id); }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }
}