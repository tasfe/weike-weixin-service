package com.dick.weixin.base.processor;

import java.util.HashMap;
import java.util.Map;

import com.dick.weixin.base.control.impl.MessageControl;
import com.dick.weixin.base.processor.impl.event.BasicProcessorImpl;
import com.dick.weixin.base.processor.impl.event.ClickProcessorImpl;
import com.dick.weixin.base.processor.impl.event.SweepingProcessorImpl;
import com.dick.weixin.base.processor.impl.message.ImageProcessorImpl;
import com.dick.weixin.base.processor.impl.message.LinkProcessorImpl;
import com.dick.weixin.base.processor.impl.message.LocationProcessorImpl;
import com.dick.weixin.base.processor.impl.message.TextProcessorImpl;
import com.dick.weixin.base.processor.impl.message.VideoProcessorImpl;
import com.dick.weixin.base.processor.impl.message.VoiceProcessorImpl;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * 处理器工厂
 * 
 * @author houyankai
 * 
 */
public class ProcessorFactory {
	private static Logger logger = LoggerFactory.getLogger(ProcessorFactory.class);
	/**
	 * 处理器列表
	 */
	private static Map<String, IProcessor> processorMap = null;

	static {
		processorMap = new HashMap<String, IProcessor>();

		processorMap.put(Constant.REQ_MESSAGE_TYPE_TEXT, new TextProcessorImpl());
		processorMap.put(Constant.REQ_MESSAGE_TYPE_IMAGE, new ImageProcessorImpl());
		processorMap.put(Constant.REQ_MESSAGE_TYPE_LINK, new LinkProcessorImpl());
		processorMap.put(Constant.REQ_MESSAGE_TYPE_LOCATION, new LocationProcessorImpl());
		processorMap.put(Constant.REQ_MESSAGE_TYPE_VIDEO, new VideoProcessorImpl());
		processorMap.put(Constant.REQ_MESSAGE_TYPE_VOICE, new VoiceProcessorImpl());
		processorMap.put(Constant.EVENT_TYPE_CLICK, new ClickProcessorImpl());
		processorMap.put(Constant.EVENT_TYPE_LOCATION, new LocationProcessorImpl());
		processorMap.put(Constant.EVENT_TYPE_SCAN, new SweepingProcessorImpl());
		processorMap.put(Constant.EVENT_TYPE_UNSUBSCRIBE, new BasicProcessorImpl());
		processorMap.put(Constant.EVENT_TYPE_SUBSCRIBE, new BasicProcessorImpl());
	}

	/**
	 * 工具传入的类型获取相应的处理器
	 * 
	 * @param type
	 * @return
	 */
	public static IProcessor getProcessor(String type) {
		logger.debug("ProcessorFactory getProcessor msgType = " + type);
		IProcessor processor = processorMap.get(type);
		return processor;
	}

	public static Map<String, IProcessor> getProcessorMap() {
		return processorMap;
	}

	public static void setProcessorMap(Map<String, IProcessor> processorMap) {
		ProcessorFactory.processorMap = processorMap;
	}
}
