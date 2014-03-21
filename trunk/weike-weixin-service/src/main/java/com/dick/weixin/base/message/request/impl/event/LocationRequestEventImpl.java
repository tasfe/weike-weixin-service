package com.dick.weixin.base.message.request.impl.event;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.event.LocationEvent;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 地理位置上报 控制
 * 
 * @author houyankai
 * 
 */
public class LocationRequestEventImpl extends RequestBean<LocationEvent>
		implements IRequestMessage<LocationEvent> {

	public LocationRequestEventImpl() {
		this.setBean(new LocationEvent());
		this.setType(Constant.EVENT_TYPE_LOCATION);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		this.getBean().setEvent(requestParamMap.get("Event"));
		this.getBean().setLatitude(requestParamMap.get("Latitude"));
		this.getBean().setLongitude(requestParamMap.get("Longitude"));
		this.getBean().setPrecision(requestParamMap.get("Precision"));
	}

}
