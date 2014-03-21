package com.dick.weixin.advanced.download;

import java.util.Observable;
import java.util.Vector;

/**
 * 下载模块，如果客户端调用下载接口，会自动启动下载线程，从微信服务器下载文件
 * 
 * @author lizhen
 * 
 */
public class Download extends Observable {
	/**
	 * 要下载文件队列
	 */
	private static Vector<String> downloadList = new Vector<String>();

	/**
	 * 需要调用下载功能时，传入要下载文件的mediaId，将mediaId放入下载队列，通知下载线程进行下载
	 * 
	 * @param mediaId
	 *            微信服务器返回的文件mediaId，用于从微信服务器下载文件
	 */
	public void download(String mediaId) {
		downloadList.add(mediaId);
		super.setChanged();
		super.notifyObservers();
	}

	public static Vector<String> getDownloadList() {
		return downloadList;
	}
}
