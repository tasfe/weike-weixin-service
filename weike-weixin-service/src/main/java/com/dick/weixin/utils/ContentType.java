package com.dick.weixin.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ContentType和文件后缀名对应关系常量类
 * @author lizhen
 *
 */
public class ContentType {
	private static Map<String, String> map;
	static {
		map = new HashMap<String, String>();
		map.put("application/octet-stream", ".*");
		map.put("application/x-001", ".001");
		map.put("application/x-301", ".301");
		map.put("text/h323", ".323");
		map.put("application/x-906", ".906");
		map.put("application/x-a11", ".a11");
		map.put("application/postscript", ".ai");
		map.put("application/x-anv", ".anv");
		map.put("application/vnd.adobe.workflow", ".awf");
		map.put("application/x-bmp", ".bmp");
		map.put("application/x-bot", ".bot");
		map.put("application/x-c4t", ".c4t");
		map.put("application/x-c90", ".c90");
		map.put("application/x-cals", ".cal");
		map.put("application/vnd.ms-pki.seccat", ".cat");
		map.put("application/x-netcdf", ".cdf");
		map.put("application/x-cdr", ".cdr");
		map.put("application/x-cel", ".cel");
		map.put("application/x-x509-ca-cert", ".cer");
		map.put("application/x-g4", ".cg4");
		map.put("application/x-cgm", ".cgm");
		map.put("application/x-cit", ".cit");
		map.put("application/x-cmp", ".cmp");
		map.put("application/x-cmx", ".cmx");
		map.put("application/x-cot", ".cot");
		map.put("application/pkix-crl", ".crl");
		map.put("application/x-x509-ca-cert", ".crt");
		map.put("application/x-csi", ".csi");
		map.put("application/x-cut", ".cut");
		map.put("application/x-dbf", ".dbf");
		map.put("application/x-dbm", ".dbm");
		map.put("application/x-dbx", ".dbx");
		map.put("application/x-dbm", ".dbm");
		map.put("application/x-dcx", ".dcx");
		map.put("application/x-dgn", ".dgn");
		map.put("application/x-dib", ".dib");
		map.put("application/x-msdownload", ".dll");
		map.put("application/msword", ".doc");
		map.put("application/msword", ".dot");
		map.put("application/x-drw", ".drw");
		map.put("application/x-dwf", ".dwf");
		map.put("application/x-dwg", ".dwg");
		map.put("application/x-dxb", ".dxb");
		map.put("application/x-dxf", "dxf");
		map.put("application/vnd.adobe.edn", ".edn");
		map.put("application/x-emf", ".emf");
		map.put("application/x-ps", ".eps");
		map.put("application/x-epi", ".epi");
		map.put("application/x-ebx", ".ebx");
		map.put("application/x-x-msdownload", ".exe");
		map.put("application/vnd.fdf", ".fdf");
		map.put("application/fractals", ".fif");
		map.put("application/x-frm", ".frm");
		map.put("application/x-gbr", ".gbr");
		map.put("application/x-gl2", ".gl2");
		map.put("application/x-gp4", ".gp4");
		map.put("application/x-hgl", ".hgl");
		map.put("application/x-hpgl", ".hpgl");
		map.put("application/x-hmr", ".hmr");
		map.put("application/x-hpgl", ".hpg");
		map.put("application/x-hpl", ".hpl");
		map.put("application/x-hrf", ".hrf");
		map.put("application/mac-binhex40", ".hqx");
		map.put("application/hta", ".hta");
		map.put("application/x-icb", ".icb");
		map.put("application/x-ico", ".ico");
		map.put("application/x-iff", ".iff");
		map.put("application/x-g4", ".ig4");
		map.put("application/x-igs", ".igs");
		map.put("application/x-iphone", ".iii");
		map.put("application/x-img", ".img");
		map.put("application/x-internet-signup", ".ins");
		map.put("application/x-javascript", ".js");
		map.put("application/x-laplayer-reg", ".lar");
		map.put("application/x-latex", ".latex");
		map.put("application/x-lbm", ".lbm");
		map.put("application/x-ltr", ".ltr");
		map.put("application/x-mac", ".mac");
		map.put("application/x-troff-man", ".man");
		map.put("application/x-mdb", ".mdb");
		map.put("application/msaccess", ".mdb");
		map.put("application/x-shockwave-flash", ".mfp");
		map.put("application/x-mi", ".mi");
		map.put("application/x-mil", ".mil");
		map.put("application/x-mmxp", ".mxp");
		map.put("application/x-nrf", ".nrf");
		map.put("application/x-out", ".out");
		map.put("application/vnd.ms-project", ".mpd");
		map.put("application/pkcs10", ".p10");
		map.put("application/x-pkcs12", ".p12");
		map.put("application/x-pkcs7-certificates", ".p7b");
		map.put("application/pkcs7-mime", ".p7c");
		map.put("application/x-pkcs7-certreqresp", ".p7r");
		map.put("application/pkcs7-signature", ".p7s");
		map.put("application/x-pc5", ".pc5");
		map.put("application/x-pci", ".pci");
		map.put("application/x-pcx", ".pcx");
		map.put("application/x-pcl", ".pcl");
		map.put("application/x-pdf", ".pdf");
		map.put("application/vnd.adobe.pdx", ".pdx");
		map.put("application/x-pkcs12", ".pfx");
		map.put("application/x-pgl", ".pgl");
		map.put("application/x-pic", ".pic");
		map.put("application/x-perl", ".pl");
		map.put("application/x-plt", ".plt");
		map.put("application/x-ppm", ".ppm");
		map.put("application/vnd.ms-pki.pko", ".pko");
		map.put("application/vnd.ms-powerpoint", ".ppt");
		map.put("application/x-ppt", ".ppt");
		map.put("application/x-pr", ".pr");
		map.put("application/x-prn", ".prn");
		map.put("application/x-ps", ".ps");
		map.put("application/x-prn", ".prn");
		map.put("application/x-ptn", ".ptn");
		map.put("application/x-prt", ".prt");
		map.put("application/x-ras", ".ras");
		map.put("application/x-rgb", ".rgb");
		map.put("application/x-red", ".red");
		map.put("application/x-rlc", ".rlc");
		map.put("application/x-rle", ".rle");
		map.put("application/pics-rules", ".prf");
		map.put("application/postscript", ".ps");
		map.put("application/rat-file", ".rat");
		map.put("application/vnd.rn-recording", ".rec");
		map.put("application/vnd.rn-realsystem-rjs", ".rjs");
		map.put("application/vnd.vnd.rn-realsystem-rjt", ".rjt");
		map.put("application/vnd.rn-realmedia", ".rm");
		map.put("application/vnd.adobe.rmf", ".rmf");
		map.put("application/vnd.rn-realsystem-rmj", ".rmj");
		map.put("application/vnd.rn-rn_music_package", ".rmp");
		map.put("application/vnd.rn-realmedia-vbr", ".rmvb");
		map.put("application/vnd.rn-realsystem-rmx", ".rmx");
		map.put("application/vnd.rn-realplayer", ".rnx");
		map.put("application/vnd.rn-rsml", ".rsml");
		map.put("application/x-rtf", ".rtf");
		map.put("application/x-sam", ".sam");
		map.put("application/x-sat", ".sat");
		map.put("application/x-sdw", ".sdw");
		map.put("application/x-sdp", ".sdp");
		map.put("application/x-sdw", ".sdw");
		map.put("application/x-stuffit", ".sit");
		map.put("application/x-sld", ".sld");
		map.put("application/x-slb", ".slb");
		map.put("application/x-slk", ".slk");
		map.put("application/x-smil", ".smi");
		map.put("application/x-smil", ".smil");
		map.put("application/x-smk", ".smk");
		map.put("application/futuresplash", ".spl");
		map.put("application/streamingmedia", ".ssm");
		map.put("application/vnd.ms-pki.certstore", ".sst");
		map.put("application/vnd.ms-pki.stl", ".sst");
		map.put("application/vnd.ms-pki.certstore", ".stl");
		map.put("application/x-sty", ".sty");
		map.put("application/x-shockwave-flash", ".swf");
		map.put("application/x-tdf", ".tdf");
		map.put("application/x-tat", ".tat");
		map.put("application/x-tga", ".tga");
		map.put("application/x-tg4", ".tg4");
		map.put("application/x-tif", ".tif");
		map.put("application/x-bittorrent", ".torrent");
		map.put("application/x-icq", ".uin");
		map.put("application/x-vda", ".vda");
		map.put("application/x-vsd", ".vsd");
		map.put("application/x-vst", ".vst");
		map.put("application/x-wb1", ".wb1");
		map.put("application/x-wb2", ".wb2");
		map.put("application/x-wb3", ".wb3");
		map.put("application/x-vst", ".vst");
		map.put("application/x-wk3", ".wk3");
		map.put("application/x-wk4", ".wk4");
		map.put("application/x-wkq", ".wkq");
		map.put("application/x-wks", ".wds");
		map.put("application/x-wmf", ".wmf");
		map.put("application/x-ms-wmz", ".wmz");
		map.put("application/x-wp6", ".wp6");
		map.put("application/x-wpg", ".wpg");
		map.put("application/x-wpd", ".wpd");
		map.put("application/vnd.visio", ".vsd");
		map.put("application/x-ms-wmd", ".wmd");
		map.put("application/vnd.ms-wpl", ".wpl");
		map.put("application/x-wq1", ".wq1");
		map.put("application/x-wr1", ".wr1");
		map.put("application/x-wri", ".wri");
		map.put("application/x-wrk", ".wrk");
		map.put("application/x-ws", ".ws");
		map.put("application/vnd.adobe.xdp", ".xdp");
		map.put("application/vnd.adobe.xfd", ".xfd");
		map.put("application/vnd.adobe.xfdf", ".xfdf");
		map.put("application/vnd.ms-excel", ".xls");
		map.put("application/x-xls", ".xls");
		map.put("application/x-xlw", ".xlw");
		map.put("application/x-xwd", ".xwd");
		map.put("application/x-x_b", ".x_b");
		map.put("application/x-x_t", ".x_t");
		map.put("application/vnd.symbian.install", ".sis");
		map.put("application/vnd.iphone", ".ipa");
		map.put("application/x-silverlight-app", ".xap");
		map.put("application/vnd.android.package-archive", ".apk");
		map.put("application/json", ".json");
		
		map.put("java/*", ".java");
		
		map.put("Model/vnd.dwf", ".dwf");
		
		map.put("message/rfc822", ".eml");
		map.put("Model/vnd.dwf", ".dwf");
		
		map.put("drawing/907", ".907");
		map.put("drawing/top", ".top");
		
		map.put("audio/x-mei-aac", ".acp");
		map.put("audio/basic", ".au");
		map.put("audio/x-liquid-file", ".la1");
		map.put("audio/x-liquid-secure", ".lavs");
		map.put("audio/x-la-lms", ".lmsff");
		map.put("audio/mpegurl", ".m3u");
		map.put("audio/mid", ".midi");
		map.put("audio/x-musicnet-download", ".mnd");
		map.put("audio/x-musicnet-stream", ".mns");
		map.put("audio/mp1", ".mp1");
		map.put("audio/mp2", ".mp2");
		map.put("audio/mp3", ".mp3");
		map.put("audio/rn-mpeg", ".mpga");
		map.put("audio/scpls", ".pls");
		map.put("audio/x-pn-realaudio", ".ram");
		map.put("audio/vnd.rn-realaudio", ".ra");
		map.put("audio/x-pn-realaudio", ".rmm");
		map.put("audio/x-pn-realaudio-plugin", ".rpm");
		map.put("audio/wav", ".wav");
		map.put("audio/x-ms-wma", ".wma");
		map.put("audio/x-ms-wax", ".wax");
		map.put("audio/scpls", ".xpl");
		
		map.put("image/fax", ".fax");
		map.put("image/gif", ".gif");
		map.put("image/x-icon", ".ico");
		map.put("image/x-ico", ".ico");
		map.put("image/x-jpe", ".jpe");
		map.put("image/jpeg", ".jpg");
		map.put("image/jpg", ".jpg");
		map.put("image/png", ".png");
		map.put("image/x-png", ".png");
		map.put("image/vnd.rn-realpix", ".rp");
		map.put("application/x-jpg", ".jpg");
		map.put("image/tiff", ".tif");
		map.put("image/x-tiff", ".tif");
		map.put("image/vnd.wap.wbmp", ".wbmp");
		
		
		map.put("video/x-ms-asf", ".asf");
		map.put("video/x-ms-asf", ".asx");
		map.put("video/avi", ".avi");
		map.put("video/x-ivf", ".ivf");
		map.put("video/x-mpeg", ".mpe");
		map.put("video/mpeg4", ".mp4");
		map.put("video/mpg", ".mpg");
		map.put("video/x-mpeg", ".mps");
		map.put("video/mpg", ".mpv");
		map.put("video/x-sgi-movie", ".movie");
		map.put("video/vnd.rn-realvideo", ".rv");
		map.put("video/x-ms-wmx", ".wmx");
		map.put("video/x-ms-wmv", ".wmv");
		map.put("video/x-ms-wvx", ".wvx");
		
		
		
		map.put("text/asa", ".asa");
		map.put("text/asp", ".asp");
		map.put("text/xml", ".biz");
		map.put("text/css", ".css");
		map.put("text/x-component", ".htc");
		map.put("text/html", ".html");
		map.put("text/webviewhtml", ".htt");
		map.put("text/x-ms-odc", ".odc");
		map.put("text/vnd.rn-realtext3d", ".r3t");
		map.put("text/vnd.rn-realtext", ".rt");
		map.put("text/plain", ".txt");
		map.put("text/iuls", ".uls");
		map.put("text/vnd.wap.wml", ".wml");
		map.put("text/scriptlet", ".wxc");
	}
	
	/**
	 * 通过contentType类型查询对应的文件后缀名
	 * @param contentType
	 * @return
	 */
	public static String getSuffix(String contentType) {
		String suffix = "";
		if (contentType != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				if (contentType.toLowerCase().indexOf(entry.getKey()) != -1) {
					suffix = entry.getValue();
					break;
				}
			}
		}
		return suffix;
	}
}
