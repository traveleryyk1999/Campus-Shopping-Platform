package com.imooc.o2oo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2oo.entity.ShopCategory;

public interface ShopCategoryDao {
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
	
}
