package com.dick.weixin.base.control;

import java.util.Map;

/**
 * @author houyankai
 * 
 */
public interface IFlowControl {

	/**
	 * 常规流程（用户->微信->后台服务->微信->用户）
	 * 
	 * @param requestParamMap
	 * @return
	 */
	String normalFlowControl(Map<String, String> requestParamMap);

}
