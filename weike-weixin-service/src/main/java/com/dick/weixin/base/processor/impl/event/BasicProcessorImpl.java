package com.dick.weixin.base.processor.impl.event;

import com.dick.weixin.base.message.bean.request.event.BasicEvent;
import com.dick.weixin.base.message.bean.response.message.TextResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.ResponseMessageFactory;
import com.dick.weixin.base.processor.IProcessor;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.TestConstant;

public class BasicProcessorImpl implements IProcessor<BasicEvent> {

	@Override
	public IResponseMessage processor(BasicEvent basicEvent) {
		IResponseMessage responseMessage = ResponseMessageFactory.getRequestMessage(Constant.RESP_MESSAGE_TYPE_TEXT,
				basicEvent);
		TextResMessage textMessageTemp = (TextResMessage) responseMessage.getBean();
		if (Constant.EVENT_TYPE_SUBSCRIBE.equals(basicEvent.getEvent())) {
			textMessageTemp.setContent(TestConstant.TEXT_SUBSCRIBE);
		} else {
			textMessageTemp.setContent(TestConstant.TEXT_UNSUBSCRIBE);
		}
		return responseMessage;
	}

}
