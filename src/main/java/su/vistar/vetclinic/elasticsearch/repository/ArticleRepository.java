package su.vistar.vetclinic.elasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import su.vistar.vetclinic.elasticsearch.model.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

//    Page<Article> findByAuthorsName(String name, Pageable pageable);
    List<Article> findAllByAuthorsName(String name);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);
}