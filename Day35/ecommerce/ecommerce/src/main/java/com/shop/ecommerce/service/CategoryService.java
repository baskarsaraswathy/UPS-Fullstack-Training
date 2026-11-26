package com.shop.ecommerce.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) { this.categoryRepository = categoryRepository; }
    public List<Category> getAllCategories() { return categoryRepository.findAll(); }
    public Category createCategory(Category category) { return categoryRepository.save(category); }
}