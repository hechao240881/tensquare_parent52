package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.NoFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Miss`超
 * @create 2019-11-16 17:05
 */
public interface NoFriendDao extends JpaRepository<NoFriend,String> {
    public NoFriend findByUseridAndFriendid(String userid, String friend);

    @Modifying
    @Query(value = "update tb_friend set islike = ? where userid = ? and friendid = ?",nativeQuery = true)
    public void updateIslike(String islike, String userid, String friend);
}
