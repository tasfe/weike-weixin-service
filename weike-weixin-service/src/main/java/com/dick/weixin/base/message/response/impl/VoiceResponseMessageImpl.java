package com.dick.weixin.base.message.response.impl;

import com.dick.weixin.base.message.bean.response.message.VoiceResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.bean.ResponseBean;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.MessageUtil;

public class VoiceResponseMessageImpl extends ResponseBean<VoiceResMessage>
		implements IResponseMessage<VoiceResMessage> {

	public VoiceResponseMessageImpl() {
		this.setBean(new VoiceResMessage());
		this.setType(Constant.RESP_MESSAGE_TYPE_VOICE);
	}

	@Override
	public String getResponseXml() {
		MessageUtil.xstream.alias("xml", this.getBean().getClass());
		return MessageUtil.xstream.toXML(this.getBean());
	}

}
