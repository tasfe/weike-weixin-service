package com.dick.weixin.base.message.bean.request.message;

/**
 * 文本消息
 */
public class TextMessage extends BasicMessage {
	/**
	 * 消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}