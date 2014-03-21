package com.dick.weixin.base.message.bean.response.message;

import com.dick.weixin.base.message.bean.response.ResponseBasicBean;

/**
 * 视频消息
 */
public class VideoResMessage extends ResponseBasicBean {

	/**
	 * 视频
	 */
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}