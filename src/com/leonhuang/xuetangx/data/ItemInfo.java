package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemInfo extends BaseInfo {

	private ItemType type;
	private String title;
	private String surl;
	private VideoUrlInfo vurl;

	private ItemInfo(ItemType type, String title, String url, JSONObject json) {
		super(json);

		this.title = title;
		this.type = type;
		this.surl = url;
	}

	private ItemInfo(ItemType type, String title, VideoUrlInfo url,
			JSONObject json) {
		super(json);

		this.title = title;
		this.type = type;
		this.vurl = url;
	}

	public static ItemInfo fromJSON(JSONObject json) throws JSONException {
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
					.getJSONObject("item_url")), json);
		} else {
			return new ItemInfo(type, title, json.getString("item_url"), json);
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

}
