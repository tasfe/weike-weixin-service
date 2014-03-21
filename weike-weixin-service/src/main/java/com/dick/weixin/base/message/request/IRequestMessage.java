package com.dick.weixin.base.message.request;

import java.util.Map;

/**
 * 请求控制接口
 * 
 * @author houyankai
 * 
 * @param <T>
 */
public interface IRequestMessage<T> {
	/**
	 * 获取内置对象
	 * 
	 * @return
	 */
	public T getBean();

	/**
	 * 设置通用属性
	 * 
	 * @param requestParamMap
	 */
	public void setBasicValue(Map<String, String> requestParamMap);

	/**
	 * 设置独有属性
	 * 
	 * @param requestParamMap
	 */
	public void setValue(Map<String, String> requestParamMap);

	/**
	 * 设置处理器类型
	 * 
	 * @return
	 */
	public String getType();

}
