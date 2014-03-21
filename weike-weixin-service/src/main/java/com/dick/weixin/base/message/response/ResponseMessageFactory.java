package com.dick.weixin.base.message.response;

import java.util.HashMap;
import java.util.Map;

import com.dick.weixin.base.message.bean.request.RequestBasicBean;
import com.dick.weixin.base.message.response.impl.TextResponseMessageImpl;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

public class ResponseMessageFactory {
	private static Logger logger = LoggerFactory.getLogger(ResponseMessageFactory.class);

	private static Map<String, String> responseMessageMap = null;

	static {
		responseMessageMap = new HashMap<String, String>();

		responseMessageMap.put(Constant.REQ_MESSAGE_TYPE_TEXT,
				"com.dick.weixin.base.message.response.impl.TextResponseMessageImpl");
		responseMessageMap.put(Constant.RESP_MESSAGE_TYPE_IMAGE,
				"com.dick.weixin.base.message.response.impl.ImageResponseMessageImpl");
		responseMessageMap.put(Constant.RESP_MESSAGE_TYPE_MUSIC,
				"com.dick.weixin.base.message.response.impl.MusicResponseMessageImpl");
		responseMessageMap.put(Constant.RESP_MESSAGE_TYPE_NEWS,
				"com.dick.weixin.base.message.response.impl.NewsResponseMessageImpl");
		responseMessageMap.put(Constant.RESP_MESSAGE_TYPE_VIDEO,
				"com.dick.weixin.base.message.response.impl.VideoResponseMessageImpl");
		responseMessageMap.put(Constant.RESP_MESSAGE_TYPE_VOICE,
				"com.dick.weixin.base.message.response.impl.VoiceResponseMessageImpl");
	}

	public static IResponseMessage getRequestMessage(String msgType, RequestBasicBean requestBean) {
		logger.debug("ResponseMessageFactory getRequestMessage msgType = " + msgType);
		String responseMessagePath = responseMessageMap.get(msgType);
		IResponseMessage responseMessage = null;
		try {
			responseMessage = (IResponseMessage) Class.forName(responseMessagePath).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (responseMessage == null) {
			responseMessage = new TextResponseMessageImpl();
		}
		responseMessage.setBasicValue(requestBean);
		return responseMessage;
	}

	public static Map<String, String> getResponseMessageMap() {
		return responseMessageMap;
	}

	public static void setResponseMessageMap(Map<String, String> responseMessageMap) {
		ResponseMessageFactory.responseMessageMap = responseMessageMap;
	}

}
