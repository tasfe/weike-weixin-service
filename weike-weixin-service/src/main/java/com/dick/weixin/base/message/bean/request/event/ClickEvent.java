package com.dick.weixin.base.message.bean.request.event;

/**
 * 自定义菜单时间 点击/链接
 */
public class ClickEvent extends BasicEvent {

	/**
	 * 
	 */
	private String eventKey;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

}
