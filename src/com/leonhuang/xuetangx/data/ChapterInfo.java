package com.leonhuang.xuetangx.data;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChapterInfo extends BaseInfo {

	private String title;
	private ArrayList<LectureInfo> lectures;
	private SimpleCourseInfo course;

	private ChapterInfo(String title, ArrayList<LectureInfo> lectures,
			SimpleCourseInfo course, JSONObject json) {
		super(json);

		this.title = title;
		this.lectures = lectures;
		this.course = course;
	}

	public static ChapterInfo fromJSON(JSONObject json, SimpleCourseInfo course)
			throws JSONException {
		ArrayList<LectureInfo> lectures = new ArrayList<LectureInfo>();
		ChapterInfo self = new ChapterInfo(json.getString("chapter_title"),
				lectures, course, json);

		JSONArray lecturesJSON = json.getJSONArray("chapter_lectures");
		for (int i = 0; i < lecturesJSON.length(); i++) {
			lectures.add(LectureInfo.fromJSON(lecturesJSON.getJSONObject(i),
					self));
		}
		return self;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<LectureInfo> getLectures() {
		return lectures;
	}

	public SimpleCourseInfo getCourse() {
		return course;
	}

}
