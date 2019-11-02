package com.tensquare.search.services;

import com.tensquare.search.dao.ArticleDao;
import com.tensquare.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

/**
 * @author shkstart
 * @create 2019-11-02 18:19
 */

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;
    public void save(Article article){
        article.setId(idWorker.nextId()+"");//也可以是使用默认id
        articleDao.save(article);
    }


    public Page<Article> findByKey(String key, int page, int size) {
        Pageable pageable = PageRequest.of(page-1,size);
        articleDao.findByTitleOOrContentLike(key,key,pageable);
        return null;
    }
}
