package com.imooc.o2oo.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2oo.BaseTest;
import com.imooc.o2oo.entity.ProductSellDaily;
import com.imooc.o2oo.entity.Shop;

public class ProductSellDailyDaoTest extends BaseTest{
	@Autowired
	private ProductSellDailyDao productSellDailyDao;

	/**
	 * 测试添加功能
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testAInsertProductSellDaily() throws Exception {
		// 创建商品日销量统计
		int effectedNum = productSellDailyDao.insertProductSellDaily();
		assertEquals(1, effectedNum);
	}
	
	/**
	 * 测试添加功能
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testBInsertDefaultProductSellDaily() throws Exception {
		// 创建商品日销量统计
		int effectedNum = productSellDailyDao.insertDefaultProductSellDaily();
		assertEquals(10, effectedNum);
	}

	/**
	 * 测试查询功能
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCQueryProductSellDaily() throws Exception {
		ProductSellDaily productSellDaily = new ProductSellDaily();
		// 叠加店铺去查询
		Shop shop = new Shop();
		shop.setShopId(37L);
		productSellDaily.setShop(shop);
		List<ProductSellDaily> productSellDailyList = productSellDailyDao.queryProductSellDailyList(productSellDaily,
				null, null);
		System.out.println(productSellDailyList.size());
	}
}
