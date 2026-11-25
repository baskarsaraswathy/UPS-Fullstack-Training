package com.shop.ecommerce.controller;
import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) { this.categoryService = categoryService; }

    @GetMapping
    public List<Category> getAll() { return categoryService.getAllCategories(); }
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
    }
}