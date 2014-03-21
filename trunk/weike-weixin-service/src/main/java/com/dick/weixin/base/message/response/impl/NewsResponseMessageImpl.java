package com.dick.weixin.base.message.response.impl;

import com.dick.weixin.base.message.bean.response.message.Article;
import com.dick.weixin.base.message.bean.response.message.NewsResMessage;
import com.dick.weixin.base.message.response.IResponseMessage;
import com.dick.weixin.base.message.response.bean.ResponseBean;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.MessageUtil;

public class NewsResponseMessageImpl extends ResponseBean<NewsResMessage>
		implements IResponseMessage<NewsResMessage> {

	public NewsResponseMessageImpl() {
		this.setBean(new NewsResMessage());
		this.setType(Constant.RESP_MESSAGE_TYPE_NEWS);
	}

	@Override
	public String getResponseXml() {
		MessageUtil.xstream.alias("xml", this.getBean().getClass());
		MessageUtil.xstream.alias("item", new Article().getClass());
		return MessageUtil.xstream.toXML(this.getBean());
	}

}
