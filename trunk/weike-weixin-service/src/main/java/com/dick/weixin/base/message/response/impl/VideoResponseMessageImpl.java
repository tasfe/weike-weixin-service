package com.dick.weixin.base.message.response.impl;

import com.dick.weixin.base.message.bean.response.message.VideoResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.bean.ResponseBean;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.MessageUtil;

public class VideoResponseMessageImpl extends ResponseBean<VideoResMessage>
		implements IResponseMessage<VideoResMessage> {

	public VideoResponseMessageImpl() {
		this.setBean(new VideoResMessage());
		this.setType(Constant.RESP_MESSAGE_TYPE_VIDEO);
	}

	@Override
	public String getResponseXml() {
		MessageUtil.xstream.alias("xml", this.getBean().getClass());
		return MessageUtil.xstream.toXML(this.getBean());
	}

}
