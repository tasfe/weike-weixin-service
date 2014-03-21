package com.dick.weixin.utils.logging.commons;

import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

import org.apache.commons.logging.LogFactory;
/**
 * Creates commons-logging-backed loggers
 */
public class CommonsLoggerFactory extends LoggerFactory {

	@Override
	protected Logger getLoggerImpl(Class<?> cls) {
		return new CommonsLogger(LogFactory.getLog(cls));
	}

	@Override
	protected Logger getLoggerImpl(String name) {
		return new CommonsLogger(LogFactory.getLog(name));
	}

}
