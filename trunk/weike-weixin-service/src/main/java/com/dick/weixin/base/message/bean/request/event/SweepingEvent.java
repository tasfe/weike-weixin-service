package com.dick.weixin.base.message.bean.request.event;

/**
 * 扫描带参数二维码事件 已关注/未关注
 */
public class SweepingEvent extends ClickEvent {

	/**
	 * 二维码的ticket
	 */
	private String ticket;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

}
