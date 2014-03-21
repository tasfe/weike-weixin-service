package com.dick.weixin.base.message.response.impl;

import com.dick.weixin.base.message.bean.response.message.MusicResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.bean.ResponseBean;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.MessageUtil;

public class MusicResponseMessageImpl extends ResponseBean<MusicResMessage>
		implements IResponseMessage<MusicResMessage> {

	public MusicResponseMessageImpl() {
		this.setBean(new MusicResMessage());
		this.setType(Constant.RESP_MESSAGE_TYPE_MUSIC);
	}

	@Override
	public String getResponseXml() {
		MessageUtil.xstream.alias("xml", this.getBean().getClass());
		return MessageUtil.xstream.toXML(this.getBean());
	}

}
