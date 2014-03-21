package com.dick.weixin.base.dispatcher;

import com.dick.weixin.base.message.request.IRequestMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.processor.IProcessor;
import com.dick.weixin.base.processor.ProcessorFactory;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * 分发器
 * 
 * @author houyankai
 * 
 */
public class Dispatcher {
	private static Logger logger = LoggerFactory.getLogger(Dispatcher.class);

	/**
	 * 分发处理
	 * 
	 * @param requestMessage
	 * @return
	 */
	public static IResponseMessage dispatcher(IRequestMessage requestMessage) {
		// 通过处理器工厂获取相应的处理器
		IProcessor processor = ProcessorFactory.getProcessor(requestMessage.getType());
		logger.debug("Dispatcher dispatcher processor = " + processor);
		// 对请求进行处理，返回结果控制对象
		IResponseMessage responseMessage = processor.processor(requestMessage.getBean());
		return responseMessage;
	}
}
