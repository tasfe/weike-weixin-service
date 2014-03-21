package com.dick.weixin.advanced;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.dick.weixin.utils.ConfigUtil;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.HttpRequestUtil;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * accessToken的有效期为2小时，如果过期了自动失效，需要重新获取。
 * 每次取accessToken时，如果发现为null，或者已过期，则去微信服务器重新获取一次， 并同时记录获取时间
 * 
 * @author lizhen
 * 
 */
public class AccessTokenManager {
	private static Logger log = LoggerFactory.getLogger(AccessTokenManager.class);
	/**
	 * 获取到的accessToken有效时间
	 */
	private static long expires;
	/**
	 * 获取到的accessToken
	 */
	private static String accessToken;
	/**
	 * 每次获取新的accessToken时的时间
	 */
	private static long time;

	/**
	 * 获取accessToken
	 * @return
	 * @throws Exception
	 */
	public static synchronized String getAccessToken() throws Exception {
		log.debug("当前的accessToken:" + accessToken);
		log.debug("当前的expires:" + expires);
		log.debug("当前的time:" + time);
		// 如果accessToken为空，或者已失效就去微信服务器重新获取心得accessToken
		if (accessToken == null || time + expires > System.currentTimeMillis()) {
			// 获取新的accessToken
			System.out.println("开始获取accessToken:");

			// 拼装查询参数
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("grant_type", "client_credential");
			params.put("appid", ConfigUtil.APPID);
			params.put("secret", ConfigUtil.SECRET);

			// 发送请求到微信服务器
			String res = HttpRequestUtil.get(Constant.URL_ACCESS_TOKEN, params);

			// 解析请求结果
			JSONObject json = JSONObject.fromObject(res);
			// 更新accessToken和expires
			accessToken = json.getString("access_token");
			expires = json.getLong("expires_in") * 1000;

			// 更新当前时间
			time = System.currentTimeMillis();
			log.debug("获取accessToken:" + accessToken);
			log.debug("获取的expires:" + expires);
			log.debug("新的time:" + time);
		}
		return accessToken;
	}

}
