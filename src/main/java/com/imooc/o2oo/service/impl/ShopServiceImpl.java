package com.imooc.o2oo.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.o2oo.dao.ShopDao;
import com.imooc.o2oo.dto.ImageHolder;
import com.imooc.o2oo.dto.ShopExecution;
import com.imooc.o2oo.entity.Shop;
import com.imooc.o2oo.enums.ShopStateEnum;
import com.imooc.o2oo.exceptions.ShopOperationException;
import com.imooc.o2oo.service.ShopService;
import com.imooc.o2oo.util.ImageUtil;
import com.imooc.o2oo.util.PageCalculator;
import com.imooc.o2oo.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, ImageHolder thumbnail) {
		if (shop == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			// 给店铺信息赋初始值
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			// 添加店铺信息
			int effectedNum = shopDao.insertShop(shop);
			if (effectedNum <= 0) {
				throw new RuntimeException("店鋪创建失败");
			} else {
				if (thumbnail.getImage() != null) {
					// 存储图片
					try {
						addShopImg(shop, thumbnail);
					} 
					catch (Exception e) {
						throw new RuntimeException("addShopImg error:" + e.getMessage());
					}
					// 更新店铺的图片地址
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new RuntimeException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("addShop error:" + e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}
	/*
	 * 
	 * 
	 * 删除了函数throws IOException
	 */
	private void addShopImg(Shop shop, ImageHolder thumbnail) {
		// 获取shop图片目录的相对值路径
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}
	
	@Override
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}
	
	@Override
	public ShopExecution modifyShop(Shop shop, ImageHolder thumbnail)
			throws ShopOperationException {
		// 1.判断是否需要处理图片
		// 2.更新店铺信息
		if(shop == null || shop.getShopId() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		} else {
			try {
			// 处理图片
			if(thumbnail != null && thumbnail.getImage() != null && thumbnail.getImageName() != null && !"".equals(thumbnail.getImageName())) {
				Shop tempShop = shopDao.queryByShopId(shop.getShopId());
				System.out.println(tempShop.getShopImg());
				if(tempShop.getShopImg() != null) {
					ImageUtil.deleteFileOrPath(tempShop.getShopImg());
				}
				addShopImg(shop, thumbnail);
			}
		// 更新店铺信息
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		if(effectedNum <= 0) {
			return new ShopExecution(ShopStateEnum.INNER_ERROR);
		} else {
			shop = shopDao.queryByShopId(shop.getShopId());
			return new ShopExecution(ShopStateEnum.SUCCESS, shop);
		   }} catch(Exception e) {
			   throw new ShopOperationException("modifyShop error:" + e.getMessage());
		   }
		} 
	}
	
	@Override
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, rowIndex, pageSize);
		int count = shopDao.queryShopCount(shopCondition);
		ShopExecution se = new ShopExecution();
		if(shopList != null) {
			se.setShopList(shopList);
			se.setCount(count);
		} else {
			se.setState(ShopStateEnum.INNER_ERROR.getState());
		}
		return se;
	}
}
