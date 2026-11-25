package com.shop.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.ecommerce.model.Category;
public interface CategoryRepository extends JpaRepository<Category, Long> {}