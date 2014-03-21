package com.dick.weixin.base.message.response.impl;

import com.dick.weixin.base.message.bean.response.message.ImageResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.bean.ResponseBean;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.MessageUtil;

public class ImageResponseMessageImpl extends ResponseBean<ImageResMessage>
		implements IResponseMessage<ImageResMessage> {

	public ImageResponseMessageImpl() {
		this.setBean(new ImageResMessage());
		this.setType(Constant.RESP_MESSAGE_TYPE_IMAGE);
	}

	@Override
	public String getResponseXml() {
		MessageUtil.xstream.alias("xml", this.getBean().getClass());
		return MessageUtil.xstream.toXML(this.getBean());
	}

}
