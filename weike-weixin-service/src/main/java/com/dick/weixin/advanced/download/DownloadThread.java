package com.dick.weixin.advanced.download;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.dick.weixin.advanced.AccessTokenManager;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.HttpRequestUtil;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * 下载模块线程，用于下载文件
 * 
 * @author lizhen
 * 
 */
public class DownloadThread implements Runnable {

	private static Logger log = LoggerFactory.getLogger(DownloadThread.class);

	@Override
	public void run() {

		// TODO Auto-generated method stub
		Vector<String> list = Download.getDownloadList();
		if (list != null) {
			Iterator<String> iter = list.iterator();
			while (iter.hasNext()) {
				String mediaId = iter.next();
				log.debug("start down load:" + mediaId);
				try {
					// 拼装查询参数
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("access_token", AccessTokenManager
							.getAccessToken());
					params.put("media_id", mediaId);

					// 发送请求到微信服务器
					String res = HttpRequestUtil.get(Constant.URL_DOWNLOAD,
							params);
				} catch (Exception e) {
					e.printStackTrace();
				}

				log.debug("end down load:" + mediaId);
				iter.remove();
			}
		}
	}

}
