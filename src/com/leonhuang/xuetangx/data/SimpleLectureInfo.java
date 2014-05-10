package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleLectureInfo extends BaseInfo {

	private String title;
	private String url;

	private SimpleLectureInfo(String title, String url, JSONObject json) {
		super(json);

		this.title = title;
		this.url = url;
	}

	public static SimpleLectureInfo fromJSON(JSONObject json)
			throws JSONException {
		return new SimpleLectureInfo(json.getString("lecture_title"),
				json.getString("lecture_url"), json);
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}
}
