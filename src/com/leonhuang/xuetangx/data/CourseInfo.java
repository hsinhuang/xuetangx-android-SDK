package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class CourseInfo {

	private String owner;
	private String university;
	private String id;
	private String title;
	private String imgUrl;
	private String courseAboutUrl;
	private TeacherInfo teacher = null;
	private String updateInfo;
	private int serializedNo;
	private boolean hasTA;
	private String subtitle;

	private CourseInfo(String owner, String university, String id, String title,
			String imgUrl, String courseAboutUrl, TeacherInfo teacher,
			String updateInfo, int serializeNo, boolean hasTA, String subtitle) {
		this.owner = owner;
		this.university = university;
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.courseAboutUrl = courseAboutUrl;
		this.teacher = teacher;
		this.updateInfo = updateInfo;
		this.serializedNo = serializeNo;
		this.hasTA = hasTA;
		this.subtitle = subtitle;
	}

	public static CourseInfo fromJSON(JSONObject json) throws JSONException {
		return new CourseInfo(json.getString("owner"),
				json.getString("university"), json.getString("id"),
				json.getString("title"), json.getString("img_url"),
				json.getString("course_about_url"), TeacherInfo.fromJSON(json
						.getJSONObject("teacher")),
				json.getString("update_info"), json.getInt("serialized_no"),
				json.getBoolean("hasTA"), json.getString("subtitle"));
	}

	public String getOwner() {
		return owner;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public String getCourseAboutUrl() {
		return courseAboutUrl;
	}

	public TeacherInfo getTeacher() {
		return teacher;
	}

	public String getUpdateInfo() {
		return updateInfo;
	}

	public int getSerializedNo() {
		return serializedNo;
	}

	public boolean isHasTA() {
		return hasTA;
	}

	public String getSubtitle() {
		return subtitle;
	}

}
