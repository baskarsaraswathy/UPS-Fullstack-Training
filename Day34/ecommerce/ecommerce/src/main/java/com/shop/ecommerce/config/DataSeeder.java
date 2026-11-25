package com.shop.ecommerce.config;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.shop.ecommerce.model.*;
import com.shop.ecommerce.repository.*;

@Component
public class DataSeeder implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public DataSeeder(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public void run(String... args) {
        if (categoryRepository.count() > 0) return;
        Category electronics = categoryRepository.save(new Category("Electronics", "Phones and gadgets"));
        productRepository.save(newProduct("Laptop 14 inch", "Lightweight laptop", "899.99", 10, "laptop", electronics));
    }
    private Product newProduct(String name, String desc, String price, int stock, String key, Category cat) {
        Product p = new Product();
        p.setName(name); p.setDescription(desc); p.setPrice(new BigDecimal(price));
        p.setStock(stock); p.setImageUrl("https://picsum.photos/seed/" + key + "/400/300"); p.setCategory(cat);
        return p;
    }
}