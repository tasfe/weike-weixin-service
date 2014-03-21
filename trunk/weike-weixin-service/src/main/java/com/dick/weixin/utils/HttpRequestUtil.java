package com.dick.weixin.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


import com.dick.weixin.utils.logging.Logger;
import com.dick.weixin.utils.logging.LoggerFactory;

/**
 * 发送http/https请求工具类
 * @author lizhen
 *
 */
public class HttpRequestUtil {
	
	private static Logger log = LoggerFactory.getLogger(HttpRequestUtil.class);

	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的HTML
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String get(String url, Map<String, Object> params)
			throws Exception {
		if (url == null) {
			return "";
		}

		String strResult = "";

		StringBuffer query = new StringBuffer(url);
		if (params != null && !params.isEmpty()) {
			query.append("?");
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				query.append(entry.getKey()).append("=").append(
						entry.getValue()).append("&");
			}
			query.deleteCharAt(query.length() - 1);
		}

		HttpGet httpGet = new HttpGet(query.toString());

		CloseableHttpClient client = getClient(httpGet.getURI().getScheme());
		httpGet.addHeader("Content-type", "text/html;charset=utf-8");
		HttpResponse httpResponse = null;
		try {
			httpResponse = client.execute(httpGet);
			strResult = handleResponse(httpResponse);
			log.debug("微信服务器返回结果strResult:" + strResult);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			// 关闭流并释放资源
			client.close();
		}

		return strResult;
	}

	/**
	 * 不带参数的get请求
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String get(String url) throws Exception {
		return get(url, null);
	}

	/**
	 * 执行一个POST请求，返回请求响应的结果
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @return 返回请求响应的结果
	 * @throws Exception
	 */
	public static String post(String url, Map<String, String> params)
			throws Exception {
		HttpPost post = new HttpPost(url);
		List<BasicNameValuePair> postData = new ArrayList<BasicNameValuePair>();
		if (params != null) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				postData.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
		}

		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postData,
				HTTP.UTF_8);// 过时了?
		post.setEntity(entity);
		return doPost(post);
	}

	/**
	 * 执行一个POST请求，返回请求响应的结果，post数据为json格式
	 * @param url 请求的url
	 * @param json 发送的json数据
	 * @return 返回响应结果
	 * @throws Exception
	 */
	public static String post(String url, JSONObject json) throws Exception {
		HttpPost post = new HttpPost(url);
		StringEntity se = new StringEntity(json.toString(), HTTP.UTF_8);
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		post.setEntity(se);
		return doPost(post);
	}

	/**
	 * 执行一个POST请求，返回请求响应的结果，post数据为json格式，请求url带相关查询参数
	 * @param url 请求url
	 * @param params url带的相关参数
	 * @param json 发送的json数据
	 * @return 返回响应结果
	 * @throws Exception
	 */
	public static String post(String url, Map<String, Object> params,
			JSONObject json) throws Exception {

		StringBuffer query = new StringBuffer(url);
		if (params != null && !params.isEmpty()) {
			query.append("?");
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				query.append(entry.getKey()).append("=").append(
						entry.getValue()).append("&");
			}
			query.deleteCharAt(query.length() - 1);
		}

		HttpPost post = new HttpPost(query.toString());

		StringEntity se = new StringEntity(json.toString(), HTTP.UTF_8);
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/json"));
		post.setEntity(se);
		return doPost(post);
	}
	
	/**
	 * 执行一个POST请求，返回请求响应的结果，post数据为xml格式
	 * @param url
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, String xml) throws Exception {

		StringBuffer query = new StringBuffer(url);

		HttpPost post = new HttpPost(query.toString());

		StringEntity se = new StringEntity(xml, HTTP.UTF_8);
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
				"application/xml"));
		post.setEntity(se);
		return doPost(post);
	}

	/**
	 * 上传文件到指定url
	 * @param url 请求的url
	 * @param params 相关参数
	 * @param file 要上传的文件
	 * @return 返回请求结果
	 * @throws Exception
	 */
	public static String upload(String url, Map<String, Object> params,
			File file) throws Exception {
		StringBuffer query = new StringBuffer(url);
		if (params != null && !params.isEmpty()) {
			query.append("?");
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				query.append(entry.getKey()).append("=").append(
						entry.getValue()).append("&");
			}
			query.deleteCharAt(query.length() - 1);
		}

		HttpPost post = new HttpPost(query.toString());

		HttpEntity req = MultipartEntityBuilder.create().setMode(
				HttpMultipartMode.BROWSER_COMPATIBLE).addPart("media",
				new FileBody(file)).build();
		post.setEntity(req);

		return doPost(post);
	}

	/**
	 * 处理post请求
	 * @param post post实例对象
	 * @return
	 * @throws Exception
	 */
	private static String doPost(HttpPost post) throws Exception {
		String strResult = "";

		CloseableHttpClient client = getClient(post.getURI().getScheme());

		HttpResponse httpResponse = null;
		try {
			httpResponse = client.execute(post);
			strResult = handleResponse(httpResponse);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			// 关闭流并释放资源
			client.close();
		}
		return strResult;
	}

	/**
	 * 根据请求协议，获取httpClient对象
	 * 
	 * @param protocol
	 *            协议类型：http/https
	 * @return
	 */
	private static CloseableHttpClient getClient(String protocol) {
		// HttpClient
		CloseableHttpClient client = null;

		if ("https".equals(protocol)) {
			SSLContext sslContext = null;
			try {
				sslContext = SSLContext.getInstance("SSL"); // 或SSL/TLS
				X509TrustManager[] xtmArray = new X509TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] chain,
							String authType) throws CertificateException {
					}

					public void checkServerTrusted(X509Certificate[] chain,
							String authType) throws CertificateException {
					}

					public X509Certificate[] getAcceptedIssuers() {
						return new X509Certificate[] {};
					}
				} };
				sslContext.init(null, xtmArray,
						new java.security.SecureRandom());
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
						sslContext);
				client = HttpClients.custom().setSSLSocketFactory(sslsf)
						.build();

			} catch (GeneralSecurityException e) {
				log.error(e.getMessage(), e);
			}
		} else {
			// 创建HttpClientBuilder
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			client = httpClientBuilder.build();
		}
		return client;
	}

	/**
	 * 处理响应结果
	 * 
	 * @param response 响应结果对象
	 * @return 如果返回类型为文本或json，则直接返回。如果为媒体类型，则下载文件到响应目录，并返回文件名和路径
	 * @throws Exception
	 */
	private static String handleResponse(HttpResponse response)
			throws Exception {
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			String contentType = response.getHeaders(HTTP.CONTENT_TYPE)[0]
					.getValue();
			String suffix = ContentType.getSuffix(contentType);
			
			String type = contentType.split("/")[0];
			if (("text").equals(type) || suffix.equals(".json")) {
				return EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
			}
			
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			File dir = new File(ConfigUtil.FILE_PATH + type);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File storeFile = new File(ConfigUtil.FILE_PATH + type + "/" + name + suffix);

			FileOutputStream fileOutputStream = new FileOutputStream(storeFile);
			FileOutputStream output = fileOutputStream;
			output.write(EntityUtils.toByteArray(response.getEntity()));
			output.close();
			return storeFile.getName();
		}
		return null;
	}

}
