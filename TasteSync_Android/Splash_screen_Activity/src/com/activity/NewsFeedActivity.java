package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterNewsFeed;
import com.adapter.FriendAdapter;
import com.model.Profile;
import com.tastesync.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class NewsFeedActivity extends Activity implements OnClickListener {
	ImageView imgProfile;
	private Intent mIntent;
	private ListView mLvNewsFeed;
	private AdapterNewsFeed mAdapter;
	private ArrayList<Profile> mArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newsfeed);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		imgProfile = (ImageView) findViewById(R.id.imageProfile);
		imgProfile.setOnClickListener(this);
		mLvNewsFeed = (ListView) findViewById(R.id.lv_newsfeed);
		mLvNewsFeed.setDividerHeight(0);
		mLvNewsFeed.setClickable(true);
		mArray = new ArrayList<Profile>();

		Profile pf = new Profile();
		pf.setAvatar("");
		pf.setEmail("");
		pf.setImage("");
		pf.setLocation("");
		pf.setUsername("Mr Nam");
		mArray.add(pf);
		Profile pf1 = new Profile();
		pf1.setAvatar("");
		pf1.setEmail("");
		pf1.setImage("");
		pf1.setLocation("");
		pf1.setUsername("Minh Devin");
		mArray.add(pf1);

		mAdapter = new AdapterNewsFeed(this, mArray);
		mLvNewsFeed.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageProfile:
			mIntent = new Intent(v.getContext(), ProfileActivity.class);
			TabGroupActivity parent = (TabGroupActivity)getParent();
			parent.startChildActivity("ProfileActivity", mIntent);
			break;
		default:
			break;
		}
	}

}
