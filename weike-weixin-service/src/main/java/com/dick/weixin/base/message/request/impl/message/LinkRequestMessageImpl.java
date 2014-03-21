package com.dick.weixin.base.message.request.impl.message;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.message.LinkMessage;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 链接消息 控制
 * 
 * @author houyankai
 * 
 */
public class LinkRequestMessageImpl extends RequestBean<LinkMessage> implements
		IRequestMessage<LinkMessage> {

	public LinkRequestMessageImpl() {
		this.setBean(new LinkMessage());
		this.setType(Constant.REQ_MESSAGE_TYPE_LINK);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String msgId = requestParamMap.get("MsgId");
		this.getBean().setMsgId(Long.parseLong(msgId));
		this.getBean().setDescription(requestParamMap.get("Description"));
		this.getBean().setUrl(requestParamMap.get("Url"));
		this.getBean().setTitle(requestParamMap.get("Title"));
	}

}
