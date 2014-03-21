package com.dick.weixin.base.message.request.impl.message;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.message.VoiceExtendMessage;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 语音扩展 控制
 * 
 * @author houyankai
 * 
 */
public class VoiceExtendRequestMessageImpl extends
		RequestBean<VoiceExtendMessage> implements
		IRequestMessage<VoiceExtendMessage> {

	public VoiceExtendRequestMessageImpl() {
		this.setBean(new VoiceExtendMessage());
		this.setType(Constant.REQ_MESSAGE_TYPE_VOICE);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String msgId = requestParamMap.get("MsgId");
		this.getBean().setMsgId(Long.parseLong(msgId));
		this.getBean().setFormat(requestParamMap.get("Format"));
		this.getBean().setRecognition(requestParamMap.get("Recognition"));
	}

}
