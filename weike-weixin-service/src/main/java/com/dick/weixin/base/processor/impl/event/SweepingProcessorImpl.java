package com.dick.weixin.base.processor.impl.event;

import com.dick.weixin.base.message.bean.request.event.SweepingEvent;
import com.dick.weixin.base.message.bean.response.message.TextResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.ResponseMessageFactory;
import com.dick.weixin.base.processor.IProcessor;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.TestConstant;

public class SweepingProcessorImpl implements IProcessor<SweepingEvent> {

	@Override
	public IResponseMessage processor(SweepingEvent sweepingEvent) {
		IResponseMessage responseMessage = ResponseMessageFactory.getRequestMessage(Constant.RESP_MESSAGE_TYPE_TEXT,
				sweepingEvent);
		TextResMessage textMessageTemp = (TextResMessage) responseMessage.getBean();
		if (Constant.EVENT_TYPE_SUBSCRIBE.equals(sweepingEvent.getEvent())) {
			textMessageTemp.setContent(TestConstant.TEXT_SCAN_SUBSCRIBE);
		} else {
			textMessageTemp.setContent(TestConstant.TEXT_SCAN);
		}
		return responseMessage;
	}

}
