package com.dick.weixin.base.processor;

import com.dick.weixin.base.message.response.IResponseMessage;

/**
 * 处理器接口
 * 
 * @author houyankai
 * 
 */
public interface IProcessor<T> {

	/**
	 * 执行处理器，返回响应控制对象
	 * 
	 * @param t
	 * @return
	 */
	public IResponseMessage processor(T t);
}
