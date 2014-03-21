package com.dick.weixin.base.message.request;

import java.util.HashMap;
import java.util.Map;

import com.dick.weixin.base.message.request.impl.message.TextRequestMessageImpl;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * 请求控制对象工厂
 * 
 * @author houyankai
 * 
 */
public class RequestMessageFactory {
	private static Logger logger = LoggerFactory.getLogger(RequestMessageFactory.class);
	/**
	 * 请求控制对象表
	 */
	private static Map<String, String> requestMessageMap = null;

	static {
		// 因为每次请求都必须使用新的对象，防止并发时对象冲突，因此这里存储的都是实现类位置
		requestMessageMap = new HashMap<String, String>();

		// 文本
		requestMessageMap.put(Constant.REQ_MESSAGE_TYPE_TEXT,
				"com.dick.weixin.base.message.request.impl.message.TextRequestMessageImpl");
		// 图形
		requestMessageMap.put(Constant.REQ_MESSAGE_TYPE_IMAGE,
				"com.dick.weixin.base.message.request.impl.message.ImageRequestMessageImpl");
		// 链接
		requestMessageMap.put(Constant.REQ_MESSAGE_TYPE_LINK,
				"com.dick.weixin.base.message.request.impl.message.LinkRequestMessageImpl");
		// 地理位置
		requestMessageMap.put(Constant.REQ_MESSAGE_TYPE_LOCATION,
				"com.dick.weixin.base.message.request.impl.message.LocationRequestMessageImpl");
		// 视频
		requestMessageMap.put(Constant.REQ_MESSAGE_TYPE_VIDEO,
				"com.dick.weixin.base.message.request.impl.message.VideoRequestMessageImpl");
		// 音频
		requestMessageMap.put(Constant.REQ_MESSAGE_TYPE_VOICE,
				"com.dick.weixin.base.message.request.impl.message.VoiceRequestMessageImpl");
		// 自定义菜单
		requestMessageMap.put(Constant.EVENT_TYPE_CLICK,
				"com.dick.weixin.base.message.request.impl.event.ClickRequestEventImpl");
		// 地理位置上报
		requestMessageMap.put(Constant.EVENT_TYPE_LOCATION,
				"com.dick.weixin.base.message.request.impl.event.LocationRequestEventImpl");
		// 扫描二维码
		requestMessageMap.put(Constant.EVENT_TYPE_SCAN,
				"com.dick.weixin.base.message.request.impl.event.SweepingRequestEventImpl");
		// 取消订阅
		requestMessageMap.put(Constant.EVENT_TYPE_UNSUBSCRIBE,
				"com.dick.weixin.base.message.request.impl.event.BasicRequestEventImpl");
		// 订阅
		requestMessageMap.put(Constant.EVENT_TYPE_SUBSCRIBE,
				"com.dick.weixin.base.message.request.impl.event.BasicRequestEventImpl");
	}

	/**
	 * 获取控制对象
	 * 
	 * @param requestParamMap
	 * @return
	 */
	public static IRequestMessage getRequestMessage(Map<String, String> requestParamMap) {
		String msgType = requestParamMap.get("MsgType");
		if (Constant.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
			msgType = requestParamMap.get("Event");
			if (Constant.EVENT_TYPE_SUBSCRIBE.equals(msgType)) {
				String eventKey = requestParamMap.get("EventKey");
				if (eventKey != null) {
					msgType = Constant.EVENT_TYPE_SCAN;
				}
			}
		}
		String requestMessagePath = requestMessageMap.get(msgType);
		IRequestMessage requestMessage = null;
		try {
			requestMessage = (IRequestMessage) Class.forName(requestMessagePath).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (requestMessage == null) {
			requestMessage = new TextRequestMessageImpl();
		}
		requestMessage.setBasicValue(requestParamMap);
		requestMessage.setValue(requestParamMap);
		return requestMessage;
	}

	public static Map<String, String> getRequestMessageMap() {
		return requestMessageMap;
	}

	public static void setRequestMessageMap(Map<String, String> requestMessageMap) {
		RequestMessageFactory.requestMessageMap = requestMessageMap;
	}

}
