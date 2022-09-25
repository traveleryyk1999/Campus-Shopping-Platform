package com.imooc.o2oo.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2oo.BaseTest;
import com.imooc.o2oo.dto.ImageHolder;
import com.imooc.o2oo.dto.ShopExecution;
import com.imooc.o2oo.entity.Area;
import com.imooc.o2oo.entity.PersonInfo;
import com.imooc.o2oo.entity.Shop;
import com.imooc.o2oo.entity.ShopCategory;
import com.imooc.o2oo.enums.ShopStateEnum;
import com.imooc.o2oo.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	@Test
	@Ignore
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(2L);
		shopCondition.setShopCategory(sc);
		ShopExecution se  = shopService.getShopList(shopCondition, 3, 2);
		System.out.println("店铺列表数量："+se.getShopList().size());
		System.out.println("店铺列表数量："+se.getCount());
	}
	
	@Test
	public void testModifyShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(17L);
		shop.setShopName("修改后的店铺名称");
//		File shopImg = new File("C:/Users/Berry Yu/Pictures/sadas.png");
		File shopImg = new File("D:/pics/zuckerburg.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder("zuckerburg.jpg", is);
		ShopExecution se = shopService.modifyShop(shop, imageHolder);
		System.out.println("新的图片地址为："+se.getShop().getShopImg());
	}
	
	@Test
	@Ignore
	public void testAddShop() throws ShopOperationException, FileNotFoundException {
		try {
			  Shop shop = new Shop();
			  PersonInfo owner = new PersonInfo();
			  Area area = new Area();
			  ShopCategory shopCategory = new ShopCategory();
			  owner.setUserId(1L);
			  area.setAreaId(2);
			  shopCategory.setShopCategoryId(1L);
			  shop.setOwner(owner);
			  shop.setArea(area);
			  shop.setShopCategory(shopCategory);
			  shop.setShopName("测试添加店铺3");
			  shop.setShopDesc("test3");
			  shop.setShopAddr("test3");
			  shop.setPhone("test3");
			  shop.setCreateTime(new Date());
			  shop.setEnableStatus(ShopStateEnum.CHECK.getState());
			  shop.setAdvice("审核中");
	//		  File shopImg = new File("C:/Users/Berry Yu/Pictures/pics/zuckerburg.jpg");
			  File shopImg = new File("D:/pics/zuckerburg.jpg");
			  InputStream is = new FileInputStream(shopImg);
			  ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
			  ShopExecution se = shopService.addShop(shop, imageHolder);
			  assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
