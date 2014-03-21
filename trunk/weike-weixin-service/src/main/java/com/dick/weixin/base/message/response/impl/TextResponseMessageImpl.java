package com.dick.weixin.base.message.response.impl;

import com.dick.weixin.base.message.bean.response.message.TextResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.bean.ResponseBean;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.MessageUtil;

public class TextResponseMessageImpl extends ResponseBean<TextResMessage>
		implements IResponseMessage<TextResMessage> {

	public TextResponseMessageImpl() {
		this.setBean(new TextResMessage());
		this.setType(Constant.RESP_MESSAGE_TYPE_TEXT);
	}

	@Override
	public String getResponseXml() {
		MessageUtil.xstream.alias("xml", this.getBean().getClass());
		return MessageUtil.xstream.toXML(this.getBean());
	}

}
