package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class StudentInfo {
	private String name;
	private String nickname;

	private StudentInfo(String name, String nickname) {
		this.name = name;
		this.nickname = nickname;
	}
	
	public static StudentInfo fromJSON(JSONObject json) throws JSONException {
		return new StudentInfo(json.getString("student.name"),
				json.getString("student.nickname"));
	}

	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}
}
