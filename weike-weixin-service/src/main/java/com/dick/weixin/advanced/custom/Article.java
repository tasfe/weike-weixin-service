package com.dick.weixin.advanced.custom;

/**
 * 客服接口图文信息封装类
 * @author lizhen
 *
 */
public class Article {
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 点击后跳转的链接
	 */
	private String url;
	/**
	 * 图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
	 */
	private String picurl;
	/**
	 * 标题
	 */
	private String title;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
