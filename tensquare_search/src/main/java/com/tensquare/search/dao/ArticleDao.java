package com.tensquare.search.dao;
import com.tensquare.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author shkstart
 * @create 2019-11-02 18:14
 */
public interface ArticleDao extends ElasticsearchRepository<Article,String> {

    public Page<Article> findByTitleOOrContentLike(String title, String content, Pageable pageable);
}
