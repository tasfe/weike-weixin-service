package com.dick.weixin.base.message.request.impl.message;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.message.LocationMessage;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 地理位置 控制
 * 
 * @author houyankai
 * 
 */
public class LocationRequestMessageImpl extends RequestBean<LocationMessage>
		implements IRequestMessage<LocationMessage> {

	public LocationRequestMessageImpl() {
		this.setBean(new LocationMessage());
		this.setType(Constant.REQ_MESSAGE_TYPE_LOCATION);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String msgId = requestParamMap.get("MsgId");
		this.getBean().setMsgId(Long.parseLong(msgId));
		this.getBean().setLocation_X(requestParamMap.get("Location_X"));
		this.getBean().setLocation_Y(requestParamMap.get("Location_Y"));
		this.getBean().setScale(requestParamMap.get("Scale"));
		this.getBean().setLabel(requestParamMap.get("Label"));
	}

}
