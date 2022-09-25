package com.imooc.o2oo.service;

import java.util.List;

import com.imooc.o2oo.dto.ProductCategoryExecution;
import com.imooc.o2oo.entity.ProductCategory;
import com.imooc.o2oo.exceptions.ProductCategoryOperationException;

public interface ProductCategoryService {
  List<ProductCategory> getProductCategoryList(long shopId);
  
  ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
  	throws ProductCategoryOperationException;
  ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
  	throws ProductCategoryOperationException;
}
