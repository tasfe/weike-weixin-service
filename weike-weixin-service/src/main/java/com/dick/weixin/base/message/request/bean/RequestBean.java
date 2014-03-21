package com.dick.weixin.base.message.request.bean;

import java.util.Date;
import java.util.Map;

import com.dick.weixin.base.message.bean.request.RequestBasicBean;

/**
 * 请求内置类
 * 
 * @author houyankai
 * 
 * @param <T>
 */
public class RequestBean<T> {

	private T bean;

	private String type;

	public T getBean() {
		return bean;
	}

	public void setBean(T bean) {
		this.bean = bean;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBasicValue(Map<String, String> requestParamMap) {
		RequestBasicBean requestBean = (RequestBasicBean) bean;
		requestBean.setFromUserName(requestParamMap.get("FromUserName"));
		requestBean.setToUserName(requestParamMap.get("ToUserName"));
		requestBean.setMsgType(type);
		requestBean.setCreateTime(new Date().getTime());
	}

}
