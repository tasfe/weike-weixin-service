package com.dick.weixin.base.message.request.impl.event;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.event.BasicEvent;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;

/**
 * 订阅/取消订阅 事件 控制
 * 
 * @author houyankai
 * 
 */
public class BasicRequestEventImpl extends RequestBean<BasicEvent> implements
		IRequestMessage<BasicEvent> {

	public BasicRequestEventImpl() {
		this.setBean(new BasicEvent());
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		String event = requestParamMap.get("event");
		this.getBean().setEvent(event);
		this.setType(event);
	}

}
