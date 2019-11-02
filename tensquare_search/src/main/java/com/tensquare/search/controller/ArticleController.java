package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.services.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-11-02 18:23
 */
@RestController
@RequestMapping("article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleService.save(article);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    @RequestMapping(value = "/{key}/{page}/{size}",method = RequestMethod.GET)
    public Result findByKey(@PathVariable String Key,@PathVariable int page,@PathVariable int size){
        Page<Article> pageData = articleService.findByKey(Key,page,size);
        long totalElements = pageData.getTotalElements();
        List<Article> content = pageData.getContent();
        return new Result(true,StatusCode.OK,"查询成功",
                new PageResult<Article>(totalElements,content));
    }
}
