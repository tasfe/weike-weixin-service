package com.dick.weixin.base.message.request.impl.message;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.message.VoiceMessage;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 语音消息 控制
 * 
 * @author houyankai
 * 
 */
public class VoiceRequestMessageImpl extends RequestBean<VoiceMessage>
		implements IRequestMessage<VoiceMessage> {

	public VoiceRequestMessageImpl() {
		this.setBean(new VoiceMessage());
		this.setType(Constant.REQ_MESSAGE_TYPE_VOICE);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String msgId = requestParamMap.get("MsgId");
		this.getBean().setMsgId(Long.parseLong(msgId));
		this.getBean().setFormat(requestParamMap.get("Format"));
		this.getBean().setMediaId(requestParamMap.get("MediaId"));
	}

}
