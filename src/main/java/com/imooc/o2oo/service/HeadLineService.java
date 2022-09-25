package com.imooc.o2oo.service;

import java.io.IOException;
import java.util.List;

import com.imooc.o2oo.entity.HeadLine;

public interface HeadLineService {
	/*
	 * 返回指定头条列表
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;
}
