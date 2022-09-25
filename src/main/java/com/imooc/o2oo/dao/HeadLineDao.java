package com.imooc.o2oo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2oo.entity.HeadLine;

public interface HeadLineDao {
	/*
	 * 头条名查询头条
	 */
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
}
