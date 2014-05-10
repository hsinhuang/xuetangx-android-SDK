package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class StudentInfo extends BaseInfo {
	private String name;
	private String nickname;

	private StudentInfo(String name, String nickname, JSONObject json) {
		super(json);

		this.name = name;
		this.nickname = nickname;
	}

	public static StudentInfo fromJSON(JSONObject json) throws JSONException {
		return new StudentInfo(json.getString("student.name"),
				json.getString("student.nickname"), json);
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}
}
