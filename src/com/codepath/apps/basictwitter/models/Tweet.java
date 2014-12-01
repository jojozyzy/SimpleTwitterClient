package com.codepath.apps.basictwitter.models;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {
	private String body;
	private long uid;
	private String createdAt;
	private User user;

	public String getBody() {
		return body;
	}

	public long getUid() {
		return uid;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public User getUser() {
		return user;
	}

	public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray) {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>(jsonArray.length());
	      // Process each result in json array, decode and convert to business object
	      for (int i=0; i < jsonArray.length(); i++) {
	          JSONObject businessJson = null;
	          try {
	          	businessJson = jsonArray.getJSONObject(i);
	          } catch (Exception e) {
	              e.printStackTrace();
	              continue;
	          }

	          Tweet tweet = Tweet.fromJSON(businessJson);
	          if (tweet != null) {
	        	  tweets.add(tweet);
	          }
	      }

	      return tweets;
	}

	public static Tweet fromJSON(JSONObject jsonObject) {
		Tweet tweet = new Tweet();
		try {
			tweet.body = jsonObject.getString("text");
			tweet.uid = jsonObject.getLong("uid");
			tweet.createdAt = jsonObject.getString("createdAt");
			tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tweet;
	}

	@Override
	public String toString() {
		return getBody() + " - " + getUser().getScreenName();
	}
}
