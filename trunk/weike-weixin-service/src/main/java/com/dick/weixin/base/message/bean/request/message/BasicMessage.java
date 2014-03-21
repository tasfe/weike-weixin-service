package com.dick.weixin.base.message.bean.request.message;

import com.dick.weixin.base.message.bean.request.RequestBasicBean;

/**
 * 消息基类（普通用户 -> 公众帐号）
 */
public class BasicMessage extends RequestBasicBean {
	/**
	 * 消息id，64位整型
	 */
	private long MsgId;

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}
}