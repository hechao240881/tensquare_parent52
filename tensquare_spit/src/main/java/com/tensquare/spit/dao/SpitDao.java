package com.tensquare.spit.dao;

import com.tensquare.spit.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author shkstart
 * @create 2019-10-27 20:55
 */
public interface SpitDao extends MongoRepository<Spit,String> {
}
