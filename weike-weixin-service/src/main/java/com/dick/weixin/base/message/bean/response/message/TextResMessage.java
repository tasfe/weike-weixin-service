package com.dick.weixin.base.message.bean.response.message;

import com.dick.weixin.base.message.bean.response.ResponseBasicBean;

/**
 * 文本消息
 */
public class TextResMessage extends ResponseBasicBean {
	/**
	 * 回复的消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}