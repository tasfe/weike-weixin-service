package com.dick.weixin.base.message.bean.request.message;

/**
 * 视频消息
 */
public class VideoMessage extends BasicMessage {
	/**
	 * 媒体ID
	 */
	private String MediaId;
	/**
	 * 缩略图媒体ID
	 */
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
