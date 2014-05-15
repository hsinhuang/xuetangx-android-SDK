package com.leonhuang.xuetangx;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.util.Pair;

import com.leonhuang.xuetangx.data.CategoryInfo;
import com.leonhuang.xuetangx.data.ChapterInfo;
import com.leonhuang.xuetangx.data.CourseInfo;
import com.leonhuang.xuetangx.data.ItemInfo;
import com.leonhuang.xuetangx.data.SimpleChapterInfo;
import com.leonhuang.xuetangx.data.SimpleCourseInfo;
import com.leonhuang.xuetangx.data.SimpleCourseStatus;
import com.leonhuang.xuetangx.data.SimpleLectureInfo;

public class Courses {

	public static String URL_SELECTED = "http://xuetangxserver.sinaapp.com/courses/selected/";
	public static String URL_UPCOMING = "http://xuetangxserver.sinaapp.com/courses/upcoming/";
	public static String URL_CURRENT = "http://xuetangxserver.sinaapp.com/courses/current/";
	public static String URL_PAST = "http://xuetangxserver.sinaapp.com/courses/past/";
	public static String URL_CATEGORIES = "http://xuetangxserver.sinaapp.com/courses/categories/";
	public static String URL_SEARCH = "http://xuetangxserver.sinaapp.com/courses/search/";
	public static String URL_UNENROLL = "http://xuetangxserver.sinaapp.com/courses/unenroll/";
	public static String URL_ENROLL = "http://xuetangxserver.sinaapp.com/courses/enroll/";
	public static String URL_LECTURES = "http://xuetangxserver.sinaapp.com/courses/lectures/";
	public static String URL_LECTURE = "http://xuetangxserver.sinaapp.com/courses/lecture/";
	public static String URL_WARE = "http://xuetangxserver.sinaapp.com/courses/ware/";

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<SimpleCourseInfo> selected(String email,
			String password) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_SELECTED, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<SimpleCourseInfo> courses = new ArrayList<SimpleCourseInfo>();

			JSONArray coursesJSON = json.getJSONArray("courses.upcoming");
			for (int i = 0; i < coursesJSON.length(); i++) {
				JSONObject courseJSON = coursesJSON.getJSONObject(i);
				courses.add(SimpleCourseInfo.fromJSON(courseJSON,
						SimpleCourseStatus.UPCOMING));
			}

			coursesJSON = json.getJSONArray("courses.current");
			for (int i = 0; i < coursesJSON.length(); i++) {
				JSONObject courseJSON = coursesJSON.getJSONObject(i);
				courses.add(SimpleCourseInfo.fromJSON(courseJSON,
						SimpleCourseStatus.CURRENT));
			}

			coursesJSON = json.getJSONArray("courses.past");
			for (int i = 0; i < coursesJSON.length(); i++) {
				JSONObject courseJSON = coursesJSON.getJSONObject(i);
				courses.add(SimpleCourseInfo.fromJSON(courseJSON,
						SimpleCourseStatus.PAST));
			}

			return courses;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<SimpleCourseInfo> upcoming(String email,
			String password) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_UPCOMING, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<SimpleCourseInfo> courses = new ArrayList<SimpleCourseInfo>();

			JSONArray coursesJSON = json.getJSONArray("courses.upcoming");
			for (int i = 0; i < coursesJSON.length(); i++) {
				JSONObject courseJSON = coursesJSON.getJSONObject(i);
				courses.add(SimpleCourseInfo.fromJSON(courseJSON,
						SimpleCourseStatus.UPCOMING));
			}

			return courses;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<SimpleCourseInfo> current(String email,
			String password) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_CURRENT, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<SimpleCourseInfo> courses = new ArrayList<SimpleCourseInfo>();

			JSONArray coursesJSON = json.getJSONArray("courses.current");
			for (int i = 0; i < coursesJSON.length(); i++) {
				JSONObject courseJSON = coursesJSON.getJSONObject(i);
				courses.add(SimpleCourseInfo.fromJSON(courseJSON,
						SimpleCourseStatus.CURRENT));
			}

			return courses;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<SimpleCourseInfo> past(String email, String password)
			throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_PAST, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<SimpleCourseInfo> courses = new ArrayList<SimpleCourseInfo>();

			JSONArray coursesJSON = json.getJSONArray("courses.past");
			for (int i = 0; i < coursesJSON.length(); i++) {
				JSONObject courseJSON = coursesJSON.getJSONObject(i);
				courses.add(SimpleCourseInfo.fromJSON(courseJSON,
						SimpleCourseStatus.PAST));
			}

			return courses;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<CategoryInfo> categories() throws IOException {
		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_CATEGORIES);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<CategoryInfo> categories = new ArrayList<CategoryInfo>();

			JSONArray categoriesJSON = json.getJSONArray("courses.categories");
			for (int i = 0; i < categoriesJSON.length(); i++) {
				JSONObject categoryJSON = categoriesJSON.getJSONObject(i);
				categories.add(CategoryInfo.fromJSON(categoryJSON));
			}

			return categories;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @param "" for String, false for boolean, -1 for int means not required in
	 * all fields.
	 * 
	 * @param cid means category id.
	 * 
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect, -1 for right of Pair if no more nextOffset
	 */
	public static Pair<ArrayList<CourseInfo>, Integer> search(String query,
			String cid, boolean started, boolean hasTA, int offset, int limit)
			throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		if (!query.isEmpty()) {
			params.add(new BasicNameValuePair("query", query));
		}
		if (!cid.isEmpty()) {
			params.add(new BasicNameValuePair("cid", cid));
		}
		if (started) {
			params.add(new BasicNameValuePair("started", "true"));
		} else {
			params.add(new BasicNameValuePair("started", "false"));
		}
		if (hasTA) {
			params.add(new BasicNameValuePair("hasTA", "true"));
		} else {
			params.add(new BasicNameValuePair("hasTA", "false"));
		}
		if (-1 != offset) {
			params.add(new BasicNameValuePair("offset", String.valueOf(offset)));
		}
		if (-1 != limit) {
			params.add(new BasicNameValuePair("limit", String.valueOf(limit)));
		}

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_SEARCH, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			int nextOffset = json.getInt("next_offset");

			ArrayList<CourseInfo> courses = new ArrayList<CourseInfo>();
			JSONArray coursesJSON = json.getJSONArray("courses.search");
			for (int i = 0; i < coursesJSON.length(); i++) {
				JSONObject categoryJSON = coursesJSON.getJSONObject(i);
				courses.add(CourseInfo.fromJSON(categoryJSON));
			}

			return new Pair<ArrayList<CourseInfo>, Integer>(courses, nextOffset);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return false if email/password incorrect or error happens
	 */
	public static boolean unenroll(String email, String password,
			SimpleCourseInfo course) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("url", course.getCourseInfoUrl()));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_UNENROLL, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return false;
			}

			return json.getBoolean("courses.unenroll");

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return false;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return false if email/password incorrect or error happens
	 */
	public static boolean enroll(String email, String password,
			CourseInfo course) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("url", course.getCourseAboutUrl()));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_ENROLL, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return false;
			}

			return json.getBoolean("courses.enroll");

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return false;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<ChapterInfo> ware(String email, String password,
			SimpleCourseInfo course) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("url", course.getCourseInfoUrl()));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_WARE, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<ChapterInfo> chapters = new ArrayList<ChapterInfo>();
			JSONArray chaptersJSON = json.getJSONArray("courses.ware");
			for (int i = 0; i < chaptersJSON.length(); i++) {
				chapters.add(ChapterInfo.fromJSON(chaptersJSON.getJSONObject(i)));
			}

			return chapters;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<ItemInfo> lecture(String email, String password,
			SimpleLectureInfo lecture) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("url", lecture.getUrl()));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_LECTURE, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
			JSONArray itemsJSON = json.getJSONArray("courses.lecture");
			for (int i = 0; i < itemsJSON.length(); i++) {
				items.add(ItemInfo.fromJSON(itemsJSON.getJSONObject(i)));
			}

			return items;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

	/*
	 * @throws IOException if Internet or Server error occur
	 * 
	 * @return null if email/password incorrect
	 */
	public static ArrayList<SimpleChapterInfo> lectures(String email,
			String password, SimpleCourseInfo lecture) throws IOException {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("email", email));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("url", lecture.getCourseInfoUrl()));

		String jsonString = "";
		try {
			jsonString = HttpOpener.makeRequest(URL_LECTURES, params);
		} catch (ClientProtocolException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			JSONObject json = new JSONObject(jsonString);
			assert json.getBoolean("valid");
			if (json.getBoolean("error")) {
				throw new IOException("Server is inaccessible");
			}

			if (!json.getBoolean("authen")) {
				return null;
			}

			ArrayList<SimpleChapterInfo> chapters = new ArrayList<SimpleChapterInfo>();
			JSONArray chaptersJSON = json.getJSONArray("courses.lectures");
			for (int i = 0; i < chaptersJSON.length(); i++) {
				chapters.add(SimpleChapterInfo.fromJSON(chaptersJSON
						.getJSONObject(i)));
			}

			return chapters;

		} catch (JSONException e) {
			e.printStackTrace();
		}

		Log.e("XuetangX SDK", "Json string from server: " + jsonString);
		return null;
	}

}
