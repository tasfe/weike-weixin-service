package com.dick.weixin.advanced;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.dick.weixin.advanced.custom.CustomMessage;
import com.dick.weixin.advanced.download.Download;
import com.dick.weixin.advanced.download.DownloadObserver;
import com.dick.weixin.advanced.menu.Button;
import com.dick.weixin.utils.Constant;
import com.dick.weixin.utils.HttpRequestUtil;
import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * 微信高级接口操作类
 * @author lizhen
 *
 */
public class Advanced {
	
	private static Logger log = LoggerFactory.getLogger(Advanced.class);

	/**
	 * 下载文件
	 * 
	 * @param mediaId
	 *            文件mediaId
	 * 
	 */
	public static void download(String mediaId) {
		Download d = new Download();
		DownloadObserver dob = new DownloadObserver(d);
		d.download(mediaId);
	}

	/**
	 * 查询用户基本信息
	 * 
	 * @param openId
	 *            用户openId
	 * @param language
	 *            返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @throws Exception
	 */
	public static JSONObject getUserInfo(String openId, String language)
			throws Exception {
		// 拼装查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("access_token", AccessTokenManager.getAccessToken());
		params.put("openid", openId);
		params.put("lang", language);

		// 发送请求到微信服务器
		String res = HttpRequestUtil.get(Constant.URL_USER_INFO, params);

		// 解析请求结果
		JSONObject json = JSONObject.fromObject(res);
		log.debug("查询的用户信息:" + json);
		return json;
	}

	/**
	 * 生成带参数的二维码
	 * 
	 * @param sceneId
	 *            场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @param expire
	 *            该二维码有效时间，以秒为单位。 最大不超过1800。-1表示永久二维码
	 * @throws Exception
	 */
	public static String createQrcode(int sceneId, int expire) throws Exception {
		// 拼装查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("scene_id", sceneId);
		Map<String, Object> scene = new HashMap<String, Object>();
		scene.put("scene_id", sceneId);
		Map<String, Object> actionInfo = new HashMap<String, Object>();
		actionInfo.put("scene", scene);
		params.put("action_info", actionInfo);
		if (expire == -1) {
			params.put("action_name", "QR_LIMIT_SCENE");
		} else {
			params.put("action_name", "QR_SCENE");
			params.put("expire_seconds", expire);
		}

		Map<String, Object> query = new HashMap<String, Object>();
		query.put("access_token", AccessTokenManager.getAccessToken());

		// 发送请求到微信服务器
		String res = HttpRequestUtil.post(Constant.URL_CREATE_QRCODE, query,
				JSONObject.fromObject(params));
		log.debug("创建二维码信息:" + res);
		return res;
	}

	/**
	 * 下载带参数的二维码
	 * 
	 * @param ticket
	 *            二维码ticket
	 * @return
	 * @throws Exception
	 */
	public static String showQrcode(String ticket) throws Exception {
		// 拼装查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ticket", ticket);

		// 发送请求到微信服务器
		String res = HttpRequestUtil.get(Constant.URL_SHOW_QRCODE, params);
		log.debug("返回二维码图片保存地址:" + res);
		return res;
	}

	/**
	 * 创建自定义菜单
	 * 
	 * @param buttons
	 * @return
	 * @throws Exception
	 */
	public static String createMenu(List<Button> buttons) throws Exception {
		// 拼装查询参数
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("access_token", AccessTokenManager.getAccessToken());

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("button", buttons);

		// 发送请求到微信服务器
		String res = HttpRequestUtil.post(Constant.URL_CREATE_MENU, query,
				JSONObject.fromObject(params));
		log.debug("创建自定义菜单返回结果:" + res);
		return res;
	}

	/**
	 * 查询自定义菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String showMenu() throws Exception {
		// 拼装查询参数
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("access_token", AccessTokenManager.getAccessToken());

		// 发送请求到微信服务器
		String res = HttpRequestUtil.get(Constant.URL_SHOW_MENU, query);
		log.debug("创建自定义菜单返回结果:" + res);
		return res;
	}

	/**
	 * 删除自定义菜单
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String deleteMenu() throws Exception {
		// 拼装查询参数
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("access_token", AccessTokenManager.getAccessToken());

		// 发送请求到微信服务器
		String res = HttpRequestUtil.get(Constant.URL_DELETE_MENU, query);
		log.debug("删除自定义菜单返回结果:" + res);
		return res;
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 *            需要上传的文件
	 * @param type
	 *            媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图
	 *            ）
	 * @return
	 * @throws Exception
	 */
	public static String upload(File file, String type) throws Exception {
		// 拼装查询参数
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("access_token", AccessTokenManager.getAccessToken());
		query.put("type", type);

		// 发送请求到微信服务器
		String res = HttpRequestUtil.upload(Constant.URL_UPLOAD, query, file);
		log.debug("删除自定义菜单返回结果:" + res);
		return res;
	}

	/**
	 * 发送客服消息
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static String sendCustomMessage(CustomMessage message)
			throws Exception {
		if (message.getTouser() == null || message.getType() == null) {
			return null;
		}
		// 拼装查询参数
		Map<String, Object> query = new HashMap<String, Object>();
		query.put("access_token", AccessTokenManager.getAccessToken());

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("touser", message.getTouser());
		param.put("msgtype", message.getType());
		param.put(message.getType(), message);

		JSONObject json = JSONObject.fromObject(param);

		// 发送请求到微信服务器
		String res = HttpRequestUtil.post(Constant.URL_CUSTOM_SEND_MESSAGE,
				query, json);
		log.debug("删除自定义菜单返回结果:" + res);
		return res;
		// return null;
	}

//	public static void main(String args[]) throws Exception {
//		// download("dd");
//		// download("ee");
//		// try {
//		// Thread.sleep(2000);
//		// }
//		// catch (InterruptedException e) {
//		// // TODO Auto-generated catch block
//		// e.printStackTrace();
//		// }
//		// download("gg");
//
//		// getUserInfo("oqv9DuH7pThY0HtTU_LvpeysbxaM", "zh_CN");
//
//		// createQrcode(1, -1);
//
//		// showQrcode("gQE+8ToAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2kwTk1LaGZsYzhRS3VGZlZtRzF1AAIErLQnUwMEsAQAAA==");
//
//		// Button button1 = new Button();
//		// button1.setName("今日歌曲");
//		// button1.setKey("ddddddd");
//		// button1.setType("click");
//		// Button button2 = new Button();
//		// button2.setName("点菜");
//		// button2.setUrl("http://www.baidu.com");
//		// button2.setType("view");
//		// List<Button> list = new ArrayList<Button>();
//		// list.add(button2);
//		// list.add(button1);
//		// Button b1 = new Button();
//		// b1.setName("菜单");
//		// b1.setSub_button(list);
//		// Button b2 = new Button();
//		// b2.setName("qq");
//		// b2.setUrl("http://www.baidu.com");
//		// b2.setType("view");
//		// List<Button> menu = new ArrayList<Button>();
//		// menu.add(b1);
//		// menu.add(b2);
//		// createMenu(menu);
//
//		showMenu();
//
//		// upload();
//		// download("Ke85FbVA2qZizfIF4qmw-j0_vMaUpWfZ99KSuirrlaLHn7zwt_afaBWndHZ0Kq01");
//
//		// CustomMessage message = new CustomMessage();
//		// message.setTouser("oqv9DuH7pThY0HtTU_LvpeysbxaM");
//		// message.setType("news");
//		// Article a1 = new Article();
//		// a1.setTitle("a1");
//		// a1.setDescription("ddddddd");
//		// a1.setPicurl("http://www.weke.com");
//		// a1.setUrl("http://www.weke.com");
//		// Article a2 = new Article();
//		// a2.setTitle("a2");
//		// a2.setDescription("ddddddd");
//		// a2.setPicurl("http://www.weke.com");
//		// a2.setUrl("http://www.weke.com");
//		// List<Article> list = new ArrayList<Article>();
//		// list.add(a1);
//		// list.add(a2);
//		// message.setArticles(list);
//		// sendCustomMessage(message);
//
//	}
}
