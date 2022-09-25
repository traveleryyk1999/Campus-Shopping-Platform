package com.imooc.o2oo.dao;

import java.util.List;

import com.imooc.o2oo.entity.Area;

public interface AreaDao {
	/*
	 * 列出区域列表
	 * @return areaList
	 */
	List<Area> queryArea();
}
