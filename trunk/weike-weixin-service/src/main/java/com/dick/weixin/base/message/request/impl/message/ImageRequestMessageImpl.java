package com.dick.weixin.base.message.request.impl.message;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.message.ImageMessage;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 图片消息 控制
 * 
 * @author houyankai
 * 
 */
public class ImageRequestMessageImpl extends RequestBean<ImageMessage>
		implements IRequestMessage<ImageMessage> {

	public ImageRequestMessageImpl() {
		this.setBean(new ImageMessage());
		this.setType(Constant.REQ_MESSAGE_TYPE_IMAGE);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String msgId = requestParamMap.get("MsgId");
		this.getBean().setMsgId(Long.parseLong(msgId));
		this.getBean().setMediaId(requestParamMap.get("MediaId"));
		this.getBean().setPicUrl(requestParamMap.get("PicUrl"));
	}

}
