package com.leonhuang.xuetangx.data;

import org.json.JSONObject;

public abstract class BaseInfo {
	
	private JSONObject json;
	
	public BaseInfo(JSONObject json) {
		this.json = json;
	}
	
	public JSONObject toJSON() {
		return this.json;
	}
	
	@Override
	public String toString() {
		return json.toString();
	}

}
