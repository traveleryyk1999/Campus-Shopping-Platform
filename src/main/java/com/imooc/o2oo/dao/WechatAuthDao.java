package com.imooc.o2oo.dao;

import com.imooc.o2oo.entity.WechatAuth;

public interface WechatAuthDao {
	/*
	 * 通过openId查询对应的微信账号
	 * @param openId
	 * @return
	 */
	WechatAuth queryWechatInfoByOpenId(String openId);
	/*
	 * 添加对应本平台的微信账号
	 * 
	 * @param weChatAuth
	 * @return
	 */
	int insertWechatAuth(WechatAuth wechatAuth);
}
