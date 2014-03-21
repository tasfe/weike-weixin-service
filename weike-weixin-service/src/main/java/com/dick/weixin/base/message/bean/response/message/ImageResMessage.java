package com.dick.weixin.base.message.bean.response.message;

import com.dick.weixin.base.message.bean.response.ResponseBasicBean;

/**
 * 图片消息
 */
public class ImageResMessage extends ResponseBasicBean {

	/**
	 * 图片
	 */
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}