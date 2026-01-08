package com.example;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findByNameContaining(String name);

    List<Product> findByCategoryAndPriceLessThan(String category, double price);
}