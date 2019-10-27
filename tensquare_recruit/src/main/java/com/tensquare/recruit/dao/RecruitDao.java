package com.tensquare.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.recruit.pojo.Recruit;

import java.util.List;

/**
 * 招募数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{
    /**
     *  推荐职位
     * @param state 状态
     * @return 查询推荐状态为2的前6个招募信息并且降序排列
     */
	public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);//where state = ? order by createtime

    /**
     * 最新职位查询方法
     * @param state 状态
     * @return 查询状态不为0的前6个招募信息并且降序排列
     */
    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);//where state!=? order by createtime
}
