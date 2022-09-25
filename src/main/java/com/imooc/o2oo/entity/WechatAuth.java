package com.imooc.o2oo.entity;

import java.util.Date;

public class WechatAuth {
	private Long wechatAuthId;
	private String openId;
	private Date createTime;
	private PersonInfo personInfo;

	public Long getWecharAuthId() {
		return wechatAuthId;
	}

	public void setWecharAuthId(Long wecharAuthId) {
		this.wechatAuthId = wecharAuthId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

}
