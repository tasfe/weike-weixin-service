package com.dick.weixin.base.control.impl;

import java.util.Map;

import com.dick.weixin.base.control.IFlowControl;
import com.dick.weixin.base.dispatcher.Dispatcher;
import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.request.RequestMessageFactory;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * 流程控制实现类
 * 
 * @author Phtlovej
 * 
 */
public class MessageFlowControl implements IFlowControl {
	private static Logger logger = LoggerFactory.getLogger(MessageFlowControl.class);

	/**
	 * 常规流程（用户->微信->后台服务->微信->用户）
	 * 
	 * @param requestParamMap
	 * @return
	 */
	@Override
	public String normalFlowControl(Map<String, String> requestParamMap) {
		logger.debug("MessageFlowControl normalFlowControl requestParamMap = " + requestParamMap);
		// 获取请求控制对象
		IRequestMessage requestMessage = RequestMessageFactory.getRequestMessage(requestParamMap);
		// 送入分发器，调用相应的处理器进行处理，获得响应控制对象
		IResponseMessage responseMessage = Dispatcher.dispatcher(requestMessage);
		// 返回Xml
		return responseMessage.getResponseXml();
	}
}
