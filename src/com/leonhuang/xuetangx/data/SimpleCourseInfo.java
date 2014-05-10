package com.leonhuang.xuetangx.data;

import java.util.Calendar;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleCourseInfo extends BaseInfo {
	private SimpleCourseStatus status;
	private String university;
	private String id;
	private String title;
	private Calendar startDate;
	private String imgUrl;
	private String courseInfoUrl = null;

	private SimpleCourseInfo(SimpleCourseStatus status, String university,
			String id, String title, Calendar startDate, String imgUrl,
			String courseInfoUrl, JSONObject json) {
		super(json);

		this.status = status;
		this.university = university;
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.imgUrl = imgUrl;
		if (status != SimpleCourseStatus.UPCOMING) {
			this.courseInfoUrl = courseInfoUrl;
		}
	}

	public static SimpleCourseInfo fromJSON(JSONObject json,
			SimpleCourseStatus status) throws JSONException {
		JSONObject dateJSON = json.getJSONObject("start_date");
		Calendar date = Calendar.getInstance();
		date.set(dateJSON.getInt("year"), dateJSON.getInt("month"),
				dateJSON.getInt("day"));
		if (status != SimpleCourseStatus.UPCOMING) {
			return new SimpleCourseInfo(status, json.getString("university"),
					json.getString("id"), json.getString("title"), date,
					json.getString("img_url"),
					json.getString("course_info_url"), json);
		} else {
			return new SimpleCourseInfo(status, json.getString("university"),
					json.getString("id"), json.getString("title"), date,
					json.getString("img_url"), null, json);
		}
	}

	public String getUniversity() {
		return university;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public SimpleCourseStatus getStatus() {
		return status;
	}

	public String getCourseInfoUrl() {
		return courseInfoUrl;
	}

}
