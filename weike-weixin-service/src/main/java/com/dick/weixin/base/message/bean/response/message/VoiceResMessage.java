package com.dick.weixin.base.message.bean.response.message;

import com.dick.weixin.base.message.bean.response.ResponseBasicBean;

/**
 * 音频消息
 */
public class VoiceResMessage extends ResponseBasicBean {

	/**
	 * 音频
	 */
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

}