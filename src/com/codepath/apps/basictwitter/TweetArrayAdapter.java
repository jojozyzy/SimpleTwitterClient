package com.codepath.apps.basictwitter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.basictwitter.models.Tweet;
import com.nostra13.universalimageloader.core.ImageLoader;

public class TweetArrayAdapter extends ArrayAdapter<Tweet> {
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
	   Tweet tweet = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view
	   View v;
	   if (convertView == null) {
		   LayoutInflater inflact = LayoutInflater.from(getContext());
		   v = inflact.inflate(R.layout.tweet_item, parent, false);
       } else {
    	   v = convertView;
       }
       // Lookup view for data population
	   ImageView ivProfileImage = (ImageView) v.findViewById(R.id.ivProfileImage);
       TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
       TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);
       ivProfileImage.setImageResource(android.R.color.transparent);
       ImageLoader imageLoader = ImageLoader.getInstance();
       // Populate the data into the template view using the data object
       imageLoader.displayImage(tweet.getUser().getProfileImageUrl(), ivProfileImage);
       tvUserName.setText(tweet.getUser().getScreenName());
       tvBody.setText(tweet.getBody());
       // Return the completed view to render on screen
       return v;
	}

	public TweetArrayAdapter(Context context, List<Tweet> tweets) {
		super(context, 0, tweets);
	}
}
