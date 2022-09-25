package com.imooc.o2oo.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin", method= {RequestMethod.GET})
public class ShopAdminController {
	@RequestMapping(value="/shopoperation")
	public String shopOperation() {
		return "shop/shopoperation";
	}
	@RequestMapping(value="/shoplist")
	public String shopList() {
		return "shop/shoplist";
	}
	@RequestMapping(value="/shopmanagement")
	public String shopManagement() {
		return "shop/shopmanagement";
	}
	@RequestMapping(value="/productcategorymanagement", method= {RequestMethod.GET})
	public String productCategoryManage() {
		return "shop/productcategorymanagement";
	}
	@RequestMapping(value="/productoperation")
	public String productOperation() {
		return "shop/productoperation";
	}
	@RequestMapping(value="productmanagement")
	public String productManagement() {
		return "shop/productmanagement";
	}
	@RequestMapping(value = "/shopauthmanagement")
	public String shopAuthManagement() {
		// 转发至店铺授权页面
		return "shop/shopauthmanagement";
	}

	@RequestMapping(value = "/shopauthedit")
	public String shopAuthEdit() {
		// 转发至授权信息修改页面
		return "shop/shopauthedit";
	}
}
