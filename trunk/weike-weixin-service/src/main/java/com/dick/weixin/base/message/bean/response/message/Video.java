package com.dick.weixin.base.message.bean.response.message;

/**
 * 视频model
 */
public class Video {
	/**
	 * 名称
	 */
	private String Title;
	/**
	 * 描述
	 */
	private String Description;
	/**
	 * 媒体ID
	 */
	private String MediaId;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}