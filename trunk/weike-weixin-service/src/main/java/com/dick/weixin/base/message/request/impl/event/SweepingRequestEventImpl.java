package com.dick.weixin.base.message.request.impl.event;

import java.util.Map;

import com.dick.weixin.base.message.bean.request.event.SweepingEvent;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.bean.RequestBean;
import com.dick.weixin.utils.Constant;

/**
 * 二维码扫描 未订阅/已订阅 控制
 * 
 * @author houyankai
 * 
 */
public class SweepingRequestEventImpl extends RequestBean<SweepingEvent>
		implements IRequestMessage<SweepingEvent> {

	public SweepingRequestEventImpl() {
		this.setBean(new SweepingEvent());
		this.setType(Constant.EVENT_TYPE_SCAN);
	}

	@Override
	public void setValue(Map<String, String> requestParamMap) {
		this.getBean().setEvent(requestParamMap.get("Event"));
		this.getBean().setEventKey(requestParamMap.get("EventKey"));
		this.getBean().setTicket(requestParamMap.get("Ticket"));
	}

}
