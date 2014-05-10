package com.leonhuang.xuetangx.data;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleChapterInfo {

	private String title;
	private ArrayList<SimpleLectureInfo> lectures;

	private SimpleChapterInfo(String title,
			ArrayList<SimpleLectureInfo> lectures) {
		this.title = title;
		this.lectures = lectures;
	}

	public static SimpleChapterInfo fromJSON(JSONObject json)
			throws JSONException {
		ArrayList<SimpleLectureInfo> lectures = new ArrayList<SimpleLectureInfo>();
		JSONArray lecturesJSON = json.getJSONArray("chapter_lectures");
		for (int i = 0; i < lecturesJSON.length(); i++) {
			lectures.add(SimpleLectureInfo.fromJSON(lecturesJSON
					.getJSONObject(i)));
		}
		return new SimpleChapterInfo(json.getString("chapter_title"), lectures);
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<SimpleLectureInfo> getLectures() {
		return lectures;
	}

}
