package com.dick.weixin.base.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author houyankai
 * 
 */
public interface IControl extends IFlowControl {
	/**
	 * 常规流程（用户->微信->后台服务->微信->用户）
	 * 
	 * @param request
	 * @param response
	 */
	void normalFlowControl(HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 检查signature是否匹配
	 * 
	 * @param request
	 * @param response
	 * @return 检查结果（True/False）
	 */
	boolean checkSignature(HttpServletRequest request,
			HttpServletResponse response);
}
