package com.activity;

import java.util.logging.Handler;

import com.tastesync.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileActivity extends Activity implements OnClickListener {

	// private ImageView mImgSetting;
	// private TextView mTvAbout;
	private Intent mIntent;
	TabGroupActivity parent ;
	private LinearLayout mLayoutSetting, mLayoutInfo, mLayoutFollowers,
			mLayoutFollowing, mLayoutFriend, mLayoutRestaurant;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mLayoutSetting = (LinearLayout) findViewById(R.id.layout_setting);
		mLayoutSetting.setOnClickListener(this);
		mLayoutInfo = (LinearLayout) findViewById(R.id.layout_infor);
		mLayoutInfo.setOnClickListener(this);
		// mImgMore = (ImageView) findViewById(R.id.img_arrow);
		// mImgMore.setOnClickListener(this);
		// mTvAbout = (TextView) findViewById(R.id.tv_about_user);
		mLayoutFollowers = (LinearLayout) findViewById(R.id.layout_follower);
		mLayoutFollowers.setOnClickListener(this);
		mLayoutFollowing = (LinearLayout) findViewById(R.id.layout_following);
		mLayoutFollowing.setOnClickListener(this);
		mLayoutFriend = (LinearLayout) findViewById(R.id.layout_friend);
		mLayoutFriend.setOnClickListener(this);
		mLayoutRestaurant = (LinearLayout) findViewById(R.id.layout_restaurant);
		mLayoutRestaurant.setOnClickListener(this);

	}

	// @SuppressWarnings("deprecation")
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_setting:
			mIntent = new Intent(v.getContext(), ProfileSettingActivity.class);
			parent = (TabGroupActivity) getParent();
			parent.startChildActivity("ProfileSettingActivity", mIntent);
			break;
		case R.id.layout_infor:
			mIntent = new Intent(v.getContext(), ProfileEditActivity.class);
			parent = (TabGroupActivity) getParent();
			parent.startChildActivity("ProfileEditActivity", mIntent);
			break;
		// case R.id.img_arrow:
		// mIntent = new Intent(v.getContext(), ProfileMoreActivity.class);
		// startActivity(mIntent);
		// break;
		case R.id.layout_follower:
			mIntent = new Intent(v.getContext(), ProfileFollowersActivity.class);
			parent = (TabGroupActivity) getParent();
			parent.startChildActivity("ProfileFollowersActivity", mIntent);
			break;
		case R.id.layout_following:
			mIntent = new Intent(v.getContext(), ProfileFollowingActivity.class);
			parent = (TabGroupActivity) getParent();
			parent.startChildActivity("ProfileFollowingActivity", mIntent);
			break;
		case R.id.layout_friend:
			mIntent = new Intent(v.getContext(), ProfileFriendActivity.class);
			parent = (TabGroupActivity) getParent();
			parent.startChildActivity("ProfileFriendActivity", mIntent);
			break;
		case R.id.layout_restaurant:
			mIntent = new Intent(v.getContext(),
					ProfileRestaurantActivity.class);
			parent = (TabGroupActivity) getParent();
			parent.startChildActivity("ProfileRestaurantActivity", mIntent);
			break;

		default:
			break;
		}
	}

	public void reloadData() {
		// TODO Auto-generated method stub
		
	}

}
