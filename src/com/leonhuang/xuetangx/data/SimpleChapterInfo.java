package com.leonhuang.xuetangx.data;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleChapterInfo extends BaseInfo {

	private String title;
	private ArrayList<SimpleLectureInfo> lectures;
	private SimpleCourseInfo course;

	private SimpleChapterInfo(String title,
			ArrayList<SimpleLectureInfo> lectures, SimpleCourseInfo course,
			JSONObject json) {
		super(json);

		this.title = title;
		this.lectures = lectures;
		this.course = course;
	}

	public static SimpleChapterInfo fromJSON(JSONObject json,
			SimpleCourseInfo course) throws JSONException {
		ArrayList<SimpleLectureInfo> lectures = new ArrayList<SimpleLectureInfo>();
		SimpleChapterInfo self = new SimpleChapterInfo(
				json.getString("chapter_title"), lectures, course, json);

		JSONArray lecturesJSON = json.getJSONArray("chapter_lectures");
		for (int i = 0; i < lecturesJSON.length(); i++) {
			lectures.add(SimpleLectureInfo.fromJSON(lecturesJSON
					.getJSONObject(i), self));
		}
		return self;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<SimpleLectureInfo> getLectures() {
		return lectures;
	}

	public SimpleCourseInfo getCourse() {
		return course;
	}

}
