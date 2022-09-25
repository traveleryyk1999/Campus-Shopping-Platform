package com.imooc.o2oo.dao;

import com.imooc.o2oo.entity.PersonInfo;

public interface PersonInfoDao {
	/*
	 * 通过用户Id查询用户
	 */
	PersonInfo queryPersonInfoById(Long userId);
	
	/*
	 * 添加用户信息
	 */
	int insertPersonInfo(PersonInfo personInfo);
}
