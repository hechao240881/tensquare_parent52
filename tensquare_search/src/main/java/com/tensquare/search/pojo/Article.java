package com.tensquare.search.pojo;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author shkstart
 * @create 2019-11-02 17:46
 */

/**
 * 下表是Elasticsearch与MySQL数据库逻辑结构概念的对比
 * Elasticsearch             关系型数据库Mysql
 * 索引(index)               数据库(databases)
 * 类型(type)                表(table)
 * 文档(document)            行(row)
 */
/*
 * 索引名称（数据库名称）indexName
 * 类型（表名）   type
 */
@Document(indexName = "tensquare_article",type = "article")
public class Article implements Serializable {
    @Id
    private String id;

    /*
    * 是否索引，就是看该域是否能被搜索
    * 是否分词，就表示搜索的时候是整体匹配还是单词匹配
    * 是否存储，就是是否在页面上显示
    * index表示这一列（title）的值是索引
    * */
    //index(索引),analyzer(分词),搜索(searchAnalyzer)
    @Field(index= true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String title;//标题

    @Field(index= true,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;//文章正文

    private String state;//审核状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
