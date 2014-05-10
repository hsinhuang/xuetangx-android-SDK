package com.leonhuang.xuetangx.data;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChapterInfo extends BaseInfo {

	private String title;
	private ArrayList<LectureInfo> lectures;

	private ChapterInfo(String title, ArrayList<LectureInfo> lectures,
			JSONObject json) {
		super(json);

		this.title = title;
		this.lectures = lectures;
	}

	public static ChapterInfo fromJSON(JSONObject json) throws JSONException {
		ArrayList<LectureInfo> lectures = new ArrayList<LectureInfo>();
		JSONArray lecturesJSON = json.getJSONArray("chapter_lectures");
		for (int i = 0; i < lecturesJSON.length(); i++) {
			lectures.add(LectureInfo.fromJSON(lecturesJSON.getJSONObject(i)));
		}
		return new ChapterInfo(json.getString("chapter_title"), lectures, json);
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<LectureInfo> getLectures() {
		return lectures;
	}

}
