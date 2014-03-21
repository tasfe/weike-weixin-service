package com.dick.weixin.utils.logging.jdk;

import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * Creates jdk loggers
 */
public class JdkLoggerFactory extends LoggerFactory {

	@Override
	protected Logger getLoggerImpl(Class<?> cls) {
		return new JdkLogger(java.util.logging.Logger.getLogger(cls.getName()));
	}

	@Override
	protected Logger getLoggerImpl(String name) {
		return new JdkLogger(java.util.logging.Logger.getLogger(name));
	}

}
