package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class CategoryInfo extends BaseInfo {
	private String id;
	private String title;
	private int count;

	private CategoryInfo(String id, String title, int count, JSONObject json) {
		super(json);

		this.id = id;
		this.title = title;
		this.count = count;
	}

	public static CategoryInfo fromJSON(JSONObject json) throws JSONException {
		return new CategoryInfo(json.getString("id"), json.getString("title"),
				json.getInt("count"), json);
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public int getCount() {
		return count;
	}

}
