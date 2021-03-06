package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class TeacherInfo extends BaseInfo {
	private String name;
	private String title;

	private TeacherInfo(String name, String title, JSONObject json) {
		super(json);

		this.name = name;
		this.title = title;
	}

	public static TeacherInfo fromJSON(JSONObject json) throws JSONException {
		String name = json.getString("name");
		String title = json.getString("title");
		if (name.isEmpty() || title.isEmpty()) {
			return null;
		} else {
			return new TeacherInfo(name, title, json);
		}
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

}
