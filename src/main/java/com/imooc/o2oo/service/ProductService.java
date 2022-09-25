package com.imooc.o2oo.service;

import java.io.InputStream;
import java.util.List;

import com.imooc.o2oo.dto.ImageHolder;
import com.imooc.o2oo.dto.ProductExecution;
import com.imooc.o2oo.entity.Product;
import com.imooc.o2oo.exceptions.ProductOperationException;

public interface ProductService {
  /*
   * 添加商品信息以及处理图片
   * 
   * @param product
   * @param thumbnail
   * @param productImgs
   * return
   * 
   */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, 
			List<ImageHolder> productImgNameList) throws ProductOperationException;
	
	/**
	 * 通过商品Id查询唯一的商品信息
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);
	
	/**
	 * 修改商品信息以及图片处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;
	
	/*
	 * 查询商品列表并分页，查询条件：模糊商品名，商品状态，店铺Id,商品类别
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}
