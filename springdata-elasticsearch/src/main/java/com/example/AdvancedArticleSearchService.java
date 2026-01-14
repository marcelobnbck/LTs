package com.example;

import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvancedArticleSearchService {

    private final ElasticsearchOperations elasticsearchOperations;

    public List<Article> fuzzySearchTitle(String typoTitle) {
        Criteria criteria = new Criteria("title").fuzzy(typoTitle);
        Query query = new CriteriaQuery(criteria);

        return elasticsearchOperations.search(query, Article.class)
                .map(SearchHit::getContent)
                .toList();
    }

    public List<Article> searchByAuthorAndKeywords(String author, String keyword) {
        Criteria criteria = new Criteria("author").is(author)
                .and("title").contains(keyword);

        Query query = new CriteriaQuery(criteria);

        return elasticsearchOperations.search(query, Article.class)
                .map(SearchHit::getContent)
                .toList();
    }
}
