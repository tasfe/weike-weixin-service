package com.dick.weixin.base.message.bean.request.event;

import com.dick.weixin.base.message.bean.request.RequestBasicBean;

/**
 * 消息基类（普通用户 -> 公众帐号） 订阅/取消订阅
 */
public class BasicEvent extends RequestBasicBean {
	/**
	 * 时间类型
	 */
	private String event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
}
