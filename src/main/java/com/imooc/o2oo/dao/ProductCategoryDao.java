package com.imooc.o2oo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2oo.entity.ProductCategory;

public interface ProductCategoryDao {
	/*
	 * 通过shop id 查询商品类别
	 * @param shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);
	
	/*
	 * 批量新增商品类别
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);
	/*
	 * 删除商品类别
	 */
	int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
