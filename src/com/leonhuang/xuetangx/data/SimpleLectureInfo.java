package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleLectureInfo extends BaseInfo {

	private String title;
	private String url;
	private SimpleChapterInfo chapter;

	private SimpleLectureInfo(String title, String url,
			SimpleChapterInfo chapter, JSONObject json) {
		super(json);

		this.title = title;
		this.url = url;
		this.chapter = chapter;
	}

	public static SimpleLectureInfo fromJSON(JSONObject json,
			SimpleChapterInfo chapter) throws JSONException {
		return new SimpleLectureInfo(json.getString("lecture_title"),
				json.getString("lecture_url"), chapter, json);
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public SimpleChapterInfo getChapter() {
		return chapter;
	}

}
