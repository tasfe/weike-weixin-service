package com.dick.weixin.base.message.request.impl.event;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.event.ClickEvent;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 自定义菜单 点击/链接 事件 控制
 * 
 * @author houyankai
 * 
 */
public class ClickRequestEventImpl extends RequestBean<ClickEvent> implements
		IRequestMessage<ClickEvent> {

	public ClickRequestEventImpl() {
		this.setBean(new ClickEvent());
		this.setType(Constant.EVENT_TYPE_CLICK);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		this.getBean().setEvent(requestParamMap.get("Event"));
		this.getBean().setEventKey(requestParamMap.get("EventKey"));
	}

}
