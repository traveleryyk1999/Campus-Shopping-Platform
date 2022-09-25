package com.imooc.o2oo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2oo.BaseTest;
import com.imooc.o2oo.entity.Area;

import com.imooc.o2oo.dao.AreaDao;;

public class AreaDaoTest extends BaseTest{
	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		List<Area> areaList = areaDao.queryArea();
//		System.out.println(areaList);
		assertEquals(2, areaList.size());
	}
}
