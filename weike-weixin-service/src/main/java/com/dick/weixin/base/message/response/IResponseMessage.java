package com.dick.weixin.base.message.response;

import com.dick.weixin.base.message.bean.request.RequestBasicBean;

public interface IResponseMessage<T> {

	public T getBean();

	public String getResponseXml();

	public void setBasicValue(RequestBasicBean requestBean);
}
