package com.dick.weixin.utils;

public class Constant {
	/**
	 * 获取access_token
	 */
	public static final String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";
	/**
	 * 上传
	 */
	public static final String URL_UPLOAD = "http://file.api.weixin.qq.com/cgi-bin/media/upload";
	/**
	 * 下载
	 */
	public static final String URL_DOWNLOAD = "http://file.api.weixin.qq.com/cgi-bin/media/get";
	/**
	 * 获取用户信息
	 */
	public static final String URL_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info";
	/**
	 * 创建带参数的二维码
	 */
	public static final String URL_CREATE_QRCODE = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
	/**
	 * 通过ticket换取二维码
	 */
	public static final String URL_SHOW_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode";
	/**
	 * 创建自定义菜单
	 */
	public static final String URL_CREATE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/create";
	/**
	 * 查询自定义菜单
	 */
	public static final String URL_SHOW_MENU = "https://api.weixin.qq.com/cgi-bin/menu/get";
	/**
	 * 删除自定义菜单
	 */
	public static final String URL_DELETE_MENU = "https://api.weixin.qq.com/cgi-bin/menu/delete";
	/**
	 * 发送客服消息
	 */
	public static final String URL_CUSTOM_SEND_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send";

	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 返回消息类型：音频
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 返回消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅/扫描二维码未订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：SCAN(扫描二维码已订阅)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：LOCATION(上报地理位置)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型：VIEW(自定义菜单链接事件)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";

}
