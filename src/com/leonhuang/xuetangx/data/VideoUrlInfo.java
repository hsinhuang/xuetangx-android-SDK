package com.leonhuang.xuetangx.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoUrlInfo {
	private String[] highQualityUrls;
	private String[] lowQualityUrls;

	private VideoUrlInfo(String[] highQualityUrls, String[] lowQualityUrls) {
		this.highQualityUrls = highQualityUrls;
		this.lowQualityUrls = lowQualityUrls;
	}

	public static VideoUrlInfo fromJSON(JSONObject json) throws JSONException {
		JSONArray highQualityJSON = json.getJSONArray("high-quality");
		JSONArray lowQualityJSON = json.getJSONArray("low-quality");

		String[] highQualityUrls = new String[highQualityJSON.length()];
		String[] lowQualityUrls = new String[lowQualityJSON.length()];

		for (int i = 0; i < highQualityUrls.length; i++) {
			highQualityUrls[i] = highQualityJSON.getString(i);
		}

		for (int i = 0; i < lowQualityUrls.length; i++) {
			lowQualityUrls[i] = lowQualityJSON.getString(i);
		}

		return new VideoUrlInfo(highQualityUrls, lowQualityUrls);
	}

	public String[] getHighQualityUrls() {
		return highQualityUrls;
	}

	public String[] getLowQualityUrls() {
		return lowQualityUrls;
	}

}
