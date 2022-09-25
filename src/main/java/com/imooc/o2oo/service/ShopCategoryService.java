package com.imooc.o2oo.service;

import java.util.List;

import com.imooc.o2oo.entity.ShopCategory;

public interface ShopCategoryService {
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
