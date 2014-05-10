package com.leonhuang.xuetangx.data;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LectureInfo {

	private String title;
	private String url;
	private ArrayList<ItemInfo> items;

	private LectureInfo(String title, String url, ArrayList<ItemInfo> items) {
		this.title = title;
		this.url = url;
		this.items = items;
	}

	public static LectureInfo fromJSON(JSONObject json) throws JSONException {
		ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
		JSONArray itemsJSON = json.getJSONArray("lecture_items");
		for (int i = 0; i < itemsJSON.length(); i++) {
			items.add(ItemInfo.fromJSON(itemsJSON.getJSONObject(i)));
		}
		return new LectureInfo(json.getString("lecture_title"),
				json.getString("lecture_url"), items);
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public ArrayList<ItemInfo> getItems() {
		return items;
	}

}
