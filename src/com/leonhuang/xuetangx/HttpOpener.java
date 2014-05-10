package com.leonhuang.xuetangx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpOpener {

	public static String makeRequest(String path, List<NameValuePair> params)
			throws ClientProtocolException, UnsupportedEncodingException,
			IOException {
		HttpClient httpclient = new DefaultHttpClient();

		HttpPost httppost = new HttpPost(path);
		httppost.addHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.154 Safari/537.36");
		httppost.addHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		httppost.addHeader("Accept-Encoding", "gzip,deflate,sdch");
		httppost.addHeader("Accept-Language",
				"en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4,zh-TW;q=0.2");

		if (null != params) {
			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		}

		HttpResponse response = httpclient.execute(httppost);

		GZIPInputStream gzipStream = new GZIPInputStream(response.getEntity()
				.getContent());

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				gzipStream));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}

		return sb.toString();
	}

	public static String makeRequest(String path)
			throws ClientProtocolException, UnsupportedEncodingException,
			IOException {
		return makeRequest(path, null);
	}

}
