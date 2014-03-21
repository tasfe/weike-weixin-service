package com.dick.weixin.base.message.bean.response.message;

import com.dick.weixin.base.message.bean.response.ResponseBasicBean;

/**
 * 音乐消息
 */
public class MusicResMessage extends ResponseBasicBean {
	/**
	 * 音乐
	 */
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}