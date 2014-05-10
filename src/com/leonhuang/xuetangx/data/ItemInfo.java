package com.leonhuang.xuetangx.data;

import org.json.JSONException;
import org.json.JSONObject;

public class ItemInfo {

	private ItemType type;
	private String surl;
	private VideoUrlInfo vurl;

	private ItemInfo(ItemType type, String url) {
		this.type = type;
		this.surl = url;
	}

	private ItemInfo(ItemType type, VideoUrlInfo url) {
		this.type = type;
		this.vurl = url;
	}

	public static ItemInfo fromJSON(JSONObject json) throws JSONException {
		String itemType = json.getString("item_type");
		ItemType type = ItemType.VIDEO;
		if (itemType.equals("problem")) {
			type = ItemType.PROBLEM;
		} else if (!itemType.equals("video")) {
			assert false;
		}

		if (ItemType.VIDEO == type) {
			return new ItemInfo(type, VideoUrlInfo.fromJSON(json
					.getJSONObject("item_url")));
		} else {
			return new ItemInfo(type, json.getString("item_url"));
		}
	}

	public ItemType getType() {
		return type;
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
