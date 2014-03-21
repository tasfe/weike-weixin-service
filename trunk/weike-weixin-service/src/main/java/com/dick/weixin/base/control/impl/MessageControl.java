package com.dick.weixin.base.control.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dick.weixin.base.control.IControl;
import com.dick.weixin.utils.ConfigUtil;
import com.dick.weixin.utils.HttpUtil;
import com.dick.weixin.utils.MessageUtil;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

public class MessageControl extends MessageFlowControl implements IControl {
	private static Logger logger = LoggerFactory.getLogger(MessageControl.class);

	@Override
	public void normalFlowControl(HttpServletRequest request, HttpServletResponse response) {
		HttpUtil.responseMessageToWX(response, this.normalFlowControl(HttpUtil.parseXml(request)));
	}

	@Override
	public boolean checkSignature(HttpServletRequest request, HttpServletResponse response) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		logger.debug("MessageControl checkSignature signature = " + signature + " timestamp = " + timestamp
				+ " nonce = " + nonce);
		if (MessageUtil.checkSignature(signature, timestamp, nonce, ConfigUtil.TOKEN)) {
			HttpUtil.responseMessageToWX(response, echostr);
			return true;
		}
		return false;
	}
}
