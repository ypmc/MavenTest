package net.chengqiao.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.chengqiao.pojo.Result;

public class HttpUtils {

	public static Result isValid(String address, String cookie, String characterEncoding) {
		System.setProperty("http.proxyHost", "localhost");
		System.setProperty("http.proxyPort", "8888");
		System.setProperty("https.proxyHost", "localhost");
		System.setProperty("https.proxyPort", "8888");
		Result result = new Result();
		result.setUrl(address);
		try {
			URL url = new URL(address);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setUseCaches(true);
			connection.setDoOutput(true);
			connection.setReadTimeout(1000);
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko");
			connection.setRequestProperty("Accept", "text/html, application/xhtml+xml, */*");
			connection.setRequestProperty("Accept-Language", "zh-CN");

			if (!"".equals(cookie) && cookie != null) {
				connection.setRequestProperty("Cookie", cookie);
			}
			HttpURLConnection.setFollowRedirects(true);
			connection.connect();
			System.out.println(connection.getResponseCode());
			result.setStatus(connection.getResponseCode() + "");
			InputStream urlStream = connection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlStream, characterEncoding));
			String ss = null;
			StringBuilder total = new StringBuilder();
			while ((ss = bufferedReader.readLine()) != null) {
				System.out.println(ss);
				total.append(ss);
			}
			bufferedReader.close();
			connection.disconnect();
			result.setResponse(total.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result.setStatus(e.getMessage());
			result.setResponse(e.getMessage());
		}

		return result;
	}

}
