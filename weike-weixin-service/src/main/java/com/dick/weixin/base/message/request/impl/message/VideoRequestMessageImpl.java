package com.dick.weixin.base.message.request.impl.message;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.message.VideoMessage;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 视频消息 控制
 * 
 * @author houyankai
 * 
 */
public class VideoRequestMessageImpl extends RequestBean<VideoMessage>
		implements IRequestMessage<VideoMessage> {

	public VideoRequestMessageImpl() {
		this.setBean(new VideoMessage());
		this.setType(Constant.REQ_MESSAGE_TYPE_VIDEO);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String msgId = requestParamMap.get("MsgId");
		this.getBean().setMsgId(Long.parseLong(msgId));
		this.getBean().setMediaId(requestParamMap.get("MediaId"));
		this.getBean().setThumbMediaId(requestParamMap.get("ThumbMediaId"));
	}

}
