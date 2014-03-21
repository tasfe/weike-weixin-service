package com.dick.weixin.advanced.custom;

import java.util.List;

/**
 * 客服接口消息封装类
 * @author lizhen
 *
 */
public class CustomMessage {
	/**
	 * 接受此客服消息的用户openid
	 */
	private String touser;
	/**
	 * 消息类型:text,image,voice,video,music,news
	 */
	private String type;
	/**
	 * 文本消息内容
	 */
	private String content;
	/**
	 * 发送的语音消息，视频消息的媒体ID
	 */
	private String media_id;
	/**
	 * 消息标题（视频消息，音乐消息）
	 */
	private String title;
	/**
	 * 消息描述（视频消息，音乐消息）
	 */
	private String description;
	/**
	 * 音乐链接（音乐消息）
	 */
	private String musicurl;
	/**
	 * 高品质音乐链接，wifi环境优先使用该链接播放音乐（音乐消息）
	 */
	private String hqmusicurl;
	/**
	 * 缩略图的媒体ID（音乐消息）
	 */
	private String thumb_media_id;
	/**
	 * 图文消息数组
	 */
	private List<Article> articles;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMusicurl() {
		return musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
	}

	public String getHqmusicurl() {
		return hqmusicurl;
	}

	public void setHqmusicurl(String hqmusicurl) {
		this.hqmusicurl = hqmusicurl;
	}

	public String getThumb_media_id() {
		return thumb_media_id;
	}

	public void setThumb_media_id(String thumb_media_id) {
		this.thumb_media_id = thumb_media_id;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
