package com.imooc.o2oo.service;

import java.io.File;
import java.io.InputStream;

import com.imooc.o2oo.dto.ImageHolder;
import com.imooc.o2oo.dto.ShopExecution;
import com.imooc.o2oo.entity.Shop;
import com.imooc.o2oo.exceptions.ShopOperationException;

public interface ShopService {
	/*
	 * 根据shopCondition分页返回相应店铺列表
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	/*
	 * 通过店铺id获取店铺信息
	 * 
	 */
	Shop getByShopId(long shopId);
	/*
	 * 更新店铺信息
	 * 
	 * @param Shop
	 * @param shopImg
	 * @return ShopExecution
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	/*
	 * 添加店铺
	 */
	ShopExecution addShop(Shop shop, ImageHolder thumbnail);
}
