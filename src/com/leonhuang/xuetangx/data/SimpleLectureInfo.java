package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleLectureInfo {

	private String title;
	private String url;

	private SimpleLectureInfo(String title, String url) {
		this.title = title;
		this.url = url;
	}

	public static SimpleLectureInfo fromJSON(JSONObject json)
			throws JSONException {
		return new SimpleLectureInfo(json.getString("lecture_title"),
				json.getString("lecture_url"));
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}
}
