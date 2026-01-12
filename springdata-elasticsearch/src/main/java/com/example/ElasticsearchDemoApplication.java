package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElasticsearchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ArticleRepository repository, AdvancedArticleSearchService searchService) {
        return args -> {
            System.out.println("1. INITIALIZING DATA");
            repository.deleteAll();
            repository.save(new Article("1", "Spring Data Elasticsearch", "Marcelo", 100));
            repository.save(new Article("2", "Docker Compose for Java Developers", "Marcelo", 200));
            repository.save(new Article("3", "Introduction to Search Engines", "Marcelo", 50));

            System.out.println("Data indexed. Waiting 1s for consistency...");
            Thread.sleep(1000);

            System.out.println("\n2. FUZZY SEARCH");
            System.out.println("Searching for 'Sprng' (Typo)...");
            searchService.fuzzySearchTitle("Sprng")
                    .forEach(a -> System.out.println("Found: " + a.getTitle()));

            System.out.println("\n3. ADVANCED CRITERIA");
            System.out.println("Searching for Author 'Marcelo' AND Title containing 'Docker'...");
            searchService.searchByAuthorAndKeywords("Marcelo", "Docker")
                    .forEach(a -> System.out.println("Found: " + a.getTitle()));

            System.out.println("\nPROCESS COMPLETED");
        };
    }
}
