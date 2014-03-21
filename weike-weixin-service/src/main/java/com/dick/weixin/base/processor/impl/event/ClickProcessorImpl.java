package com.dick.weixin.base.processor.impl.event;

import com.dick.weixin.base.message.bean.request.event.ClickEvent;
import com.dick.weixin.base.message.bean.response.message.TextResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.ResponseMessageFactory;
import com.dick.weixin.base.processor.IProcessor;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.TestConstant;

public class ClickProcessorImpl implements IProcessor<ClickEvent> {

	@Override
	public IResponseMessage processor(ClickEvent clickEvent) {
		IResponseMessage responseMessage = ResponseMessageFactory.getRequestMessage(Constant.RESP_MESSAGE_TYPE_TEXT,
				clickEvent);
		TextResMessage textMessageTemp = (TextResMessage) responseMessage.getBean();
		if (Constant.EVENT_TYPE_CLICK.equals(clickEvent.getEvent())) {
			textMessageTemp.setContent(TestConstant.TEXT_CLICK);
		} else {
			textMessageTemp.setContent(TestConstant.TEXT_VIEW);
		}
		return responseMessage;
	}

}
