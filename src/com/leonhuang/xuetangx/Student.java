package com.leonhuang.xuetangx;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.leonhuang.xuetangx.data.StudentInfo;

import android.util.Log;

public class Student {

	public static String URL_VERIFY = "http://xuetangxserver.sinaapp.com/student/verify/";
	public static String URL_INFO = "http://xuetangxserver.sinaapp.com/student/info/";

	/*
	 * @throws IOException if Internet or Server error occur
	 */
	public static boolean verify(String email, String password)
			throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_VERIFY, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}
			assert json.getBoolean("authen") == json
					.getBoolean("student.verify");
			return json.getBoolean("student.verify");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return false;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static StudentInfo info(String email, String password)
			throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_INFO, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");

			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			} else {
				return StudentInfo.fromJSON(json);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

}
