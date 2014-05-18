package com.leonhuang.xuetangx.data;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LectureInfo extends BaseInfo {

	private String title;
	private String url;
	private ArrayList<ItemInfo> items;
	private ChapterInfo chapter;

	private LectureInfo(String title, String url, ArrayList<ItemInfo> items,
			ChapterInfo chapter, JSONObject json) {
		super(json);

		this.title = title;
		this.url = url;
		this.items = items;
		this.chapter = chapter;
	}

	public static LectureInfo fromJSON(JSONObject json, ChapterInfo chapter)
			throws JSONException {
		ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
		LectureInfo self = new LectureInfo(json.getString("lecture_title"),
				json.getString("lecture_url"), items, chapter, json);

		JSONArray itemsJSON = json.getJSONArray("lecture_items");
		for (int i = 0; i < itemsJSON.length(); i++) {
			items.add(ItemInfo.fromJSON(itemsJSON.getJSONObject(i), self));
		}
		return self;
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

	public ChapterInfo getChapter() {
		return chapter;
	}

}
