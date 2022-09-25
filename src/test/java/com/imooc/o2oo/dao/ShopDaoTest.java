package com.imooc.o2oo.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2oo.BaseTest;
import com.imooc.o2oo.entity.Area;
import com.imooc.o2oo.entity.PersonInfo;
import com.imooc.o2oo.entity.Shop;
import com.imooc.o2oo.entity.ShopCategory;

public class ShopDaoTest extends BaseTest{
  @Autowired
  private ShopDao shopDao;
  
  @Test
//  @Ignore
  public void testQueryShopListAndCount() {
	  Shop shopCondition = new Shop();
	  ShopCategory childCategory = new ShopCategory();
	  ShopCategory parentCategory = new ShopCategory();
	  parentCategory.setShopCategoryId(1L);
	  childCategory.setParent(parentCategory);
	  shopCondition.setShopCategory(childCategory);
	  int count = shopDao.queryShopCount(shopCondition);
	  List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
	  System.out.println("店铺列表的大小：" + shopList.size());
	  System.out.println("店铺总数：" + count);
//	  PersonInfo owner = new PersonInfo();
//	  owner.setUserId(1L);
//	  shopCondition.setOwner(owner);
//	  List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
//	  int count = shopDao.queryShopCount(shopCondition);
//	  ShopCategory sc = new ShopCategory();
//	  sc.setShopCategoryId(2L);
//	  System.out.println("店铺列表的大小："+shopList.size());
//	  System.out.println("店铺总数："+count);
//	  shopCondition.setShopCategory(sc);
//	  int count1 = shopDao.queryShopCount(shopCondition);
//	  System.out.println("店铺总数："+count1);
  }
  
  @Test
  @Ignore
  public void testQueryByShopId() {
	  long shopId = 1;
	  Shop shop = shopDao.queryByShopId(shopId);
	  System.out.println("area_id: " + shop.getArea().getAreaId());
	  System.out.println("area_name " + shop.getArea().getAreaName());
  }
  @Test
  @Ignore
  public void testInsertShop() {
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
	  shop.setShopName("测试的店铺");
	  shop.setShopDesc("test");
	  shop.setShopAddr("test");
	  shop.setPhone("test");
	  shop.setShopImg("test");
	  shop.setCreateTime(new Date());
	  shop.setEnableStatus(1);
	  shop.setAdvice("审核中");
	  int effectedNum = shopDao.insertShop(shop);
	  assertEquals(1, effectedNum);
  }
  
  @Test
  @Ignore
  public void testUpdateShop() {
	  Shop shop = new Shop();
	  shop.setShopId(1L);
	  PersonInfo owner = new PersonInfo();
	  Area area = new Area();
	  ShopCategory shopCategory = new ShopCategory();
	  owner.setUserId(1L);
	  shop.setShopDesc("update");
	  shop.setShopAddr("update");
	  shop.setLastEditTime(new Date());
	  int effectedNum = shopDao.updateShop(shop);
	  assertEquals(1, effectedNum);
  }
}
