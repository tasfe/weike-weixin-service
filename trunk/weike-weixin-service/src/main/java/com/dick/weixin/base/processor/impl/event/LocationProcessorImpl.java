package com.dick.weixin.base.processor.impl.event;

import com.dick.weixin.base.message.bean.request.event.LocationEvent;
import com.dick.weixin.base.message.bean.response.message.TextResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.ResponseMessageFactory;
import com.dick.weixin.base.processor.IProcessor;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.TestConstant;

public class LocationProcessorImpl implements IProcessor<LocationEvent> {

	@Override
	public IResponseMessage processor(LocationEvent locationEvent) {
		IResponseMessage responseMessage = ResponseMessageFactory.getRequestMessage(Constant.RESP_MESSAGE_TYPE_TEXT,
				locationEvent);
		TextResMessage textMessageTemp = (TextResMessage) responseMessage.getBean();
		textMessageTemp.setContent(TestConstant.TEXT_EVENT_LOCATION);
		return responseMessage;
	}

}
