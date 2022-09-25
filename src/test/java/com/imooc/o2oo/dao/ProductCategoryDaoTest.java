package com.imooc.o2oo.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2oo.BaseTest;
import com.imooc.o2oo.entity.ProductCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest{
  @Autowired
  private ProductCategoryDao productCategoryDao;
  
  @Test
  public void testBQueryByShopId() throws Exception{
	  long shopId = 1;
	  List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
	  System.out.println("该店铺自定义类别数："+productCategoryList.size());
  }
  
  @Test
  public void testABatchInsertProductCategory() throws Exception {
	  ProductCategory pc = new ProductCategory();
	  pc.setProductCategoryName("商品类别1");
	  pc.setPriority(20);
	  pc.setCreateTime(new Date());
	  pc.setShopId(1L);
	  ProductCategory pc2 = new ProductCategory();
	  pc2.setProductCategoryName("商品类别2");
	  pc2.setPriority(2);
	  pc2.setCreateTime(new Date());
	  pc2.setShopId(1L);
	  List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
	  productCategoryList.add(pc);
	  productCategoryList.add(pc2);
	  int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
	  assertEquals(2, effectedNum);
  }
  @Test
  public void testCDeleteProductCategory() throws Exception {
		long shopId = 1;
		List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		for (ProductCategory pc : productCategoryList) {
			if ("商品类别1".equals(pc.getProductCategoryName()) || "商品类别2".equals(pc.getProductCategoryName())) {
				int effectedNum = productCategoryDao.deleteProductCategory(pc.getProductCategoryId(),
						shopId);
				assertEquals(1, effectedNum);
			}
		}
  }
}
