package com.dick.weixin.base.message.request.impl.message;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.message.TextMessage;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 文本消息控制
 * 
 * @author houyankai
 * 
 */
public class TextRequestMessageImpl extends RequestBean<TextMessage> implements
		IRequestMessage<TextMessage> {

	public TextRequestMessageImpl() {
		this.setBean(new TextMessage());
		this.setType(Constant.REQ_MESSAGE_TYPE_TEXT);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String msgId = requestParamMap.get("MsgId");
		this.getBean().setMsgId(Long.parseLong(msgId));
		this.getBean().setContent(requestParamMap.get("Content"));
	}

}
