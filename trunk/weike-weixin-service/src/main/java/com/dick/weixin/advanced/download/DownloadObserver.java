package com.dick.weixin.advanced.download;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 下载模块观察者类
 * 
 * @author lizhen
 * 
 */
public class DownloadObserver implements Observer {
	private static ExecutorService pool = Executors.newSingleThreadExecutor();

	public DownloadObserver(Observable o) {
		o.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		pool.execute(new DownloadThread());
	}

}
