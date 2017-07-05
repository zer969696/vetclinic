package su.vistar.vetclinic.elasticsearch.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import su.vistar.vetclinic.elasticsearch.model.Article;

import java.util.List;

public interface ArticleService {
    Article save(Article article);

    Article findOne(String id);

    Iterable<Article> findAll();

    List<Article> findAllByAuthorsName(String name);

    Page<Article> findByAuthorNameUsingCustomQuery(String name, Pageable pageable);

    long count();

    void delete(Article article);
}