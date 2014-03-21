package com.dick.weixin.base.message.response.bean;

import java.util.Date;

import com.dick.weixin.base.message.bean.request.RequestBasicBean;
import com.dick.weixin.base.message.bean.response.ResponseBasicBean;

public class ResponseBean<T> {
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

	public void setBasicValue(RequestBasicBean requestBean) {
		ResponseBasicBean responseBean = (ResponseBasicBean) bean;
		responseBean.setFromUserName(requestBean.getToUserName());
		responseBean.setToUserName(requestBean.getFromUserName());
		responseBean.setMsgType(type);
		responseBean.setCreateTime(new Date().getTime());
		responseBean.setFuncFlag(0);
	}

}
