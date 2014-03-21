package com.dick.weixin.base.processor.impl.message;

import com.dick.weixin.base.message.bean.request.message.VideoMessage;
import com.dick.weixin.base.message.bean.response.message.TextResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.ResponseMessageFactory;
import com.dick.weixin.base.processor.IProcessor;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.TestConstant;

public class VideoProcessorImpl implements IProcessor<VideoMessage> {

	@Override
	public IResponseMessage processor(VideoMessage videoMessage) {
		IResponseMessage responseMessage = ResponseMessageFactory.getRequestMessage(Constant.RESP_MESSAGE_TYPE_TEXT,
				videoMessage);
		TextResMessage textMessageTemp = (TextResMessage) responseMessage.getBean();
		textMessageTemp.setContent(TestConstant.TEXT_TEST);
		return responseMessage;
	}

}
