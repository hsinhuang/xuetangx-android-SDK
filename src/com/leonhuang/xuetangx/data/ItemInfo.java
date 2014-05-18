package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemInfo extends BaseInfo {

	private ItemType type;
	private String title;
	private String surl;
	private VideoUrlInfo vurl;

	private LectureInfo lecture = null;
	private SimpleLectureInfo simpleLecture = null;

	private ItemInfo(ItemType type, String title, String url,
			LectureInfo lecture, JSONObject json) {
		super(json);

		this.title = title;
		this.type = type;
		this.surl = url;
		this.lecture = lecture;
	}

	private ItemInfo(ItemType type, String title, String url,
			SimpleLectureInfo lecture, JSONObject json) {
		super(json);

		this.title = title;
		this.type = type;
		this.surl = url;
		this.simpleLecture = lecture;
	}

	private ItemInfo(ItemType type, String title, VideoUrlInfo url,
			LectureInfo lecture, JSONObject json) {
		super(json);

		this.title = title;
		this.type = type;
		this.vurl = url;
		this.lecture = lecture;
	}

	private ItemInfo(ItemType type, String title, VideoUrlInfo url,
			SimpleLectureInfo lecture, JSONObject json) {
		super(json);

		this.title = title;
		this.type = type;
		this.vurl = url;
		this.simpleLecture = lecture;
	}

	public static ItemInfo fromJSON(JSONObject json, LectureInfo lecture)
			throws JSONException {
		String itemType = json.getString("item_type");
		String title = json.getString("item_title");
		ItemType type = ItemType.VIDEO;
		if (itemType.equals("problem")) {
			type = ItemType.PROBLEM;
		} else if (!itemType.equals("video")) {
			assert false;
		}

		if (ItemType.VIDEO == type) {
			return new ItemInfo(type, title, VideoUrlInfo.fromJSON(json
					.getJSONObject("item_url")), lecture, json);
		} else {
			return new ItemInfo(type, title, json.getString("item_url"),
					lecture, json);
		}
	}

	public static ItemInfo fromJSON(JSONObject json, SimpleLectureInfo lecture)
			throws JSONException {
		String itemType = json.getString("item_type");
		String title = json.getString("item_title");
		ItemType type = ItemType.VIDEO;
		if (itemType.equals("problem")) {
			type = ItemType.PROBLEM;
		} else if (!itemType.equals("video")) {
			assert false;
		}

		if (ItemType.VIDEO == type) {
			return new ItemInfo(type, title, VideoUrlInfo.fromJSON(json
					.getJSONObject("item_url")), lecture, json);
		} else {
			return new ItemInfo(type, title, json.getString("item_url"),
					lecture, json);
		}
	}

	public ItemType getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getProblemPageUrl() {
		if (this.type == ItemType.PROBLEM) {
			return surl;
		} else {
			return null;
		}
	}

	public String[] getHighQualityVideoUrls() {
		if (this.type == ItemType.PROBLEM) {
			return null;
		} else {
			return vurl.getHighQualityUrls();
		}
	}

	public String[] getLowQualityVideoUrls() {
		if (this.type == ItemType.PROBLEM) {
			return null;
		} else {
			return vurl.getLowQualityUrls();
		}
	}

	public String[] getVideoUrls() {
		if (this.type == ItemType.PROBLEM) {
			return null;
		} else {
			return vurl.getUrls();
		}
	}

	public SimpleLectureInfo getSimpleLecture() {
		return simpleLecture;
	}

	public LectureInfo getLecture() {
		return lecture;
	}

}
