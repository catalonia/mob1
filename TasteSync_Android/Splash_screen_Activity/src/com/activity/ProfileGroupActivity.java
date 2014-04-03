package com.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class ProfileGroupActivity extends TabGroupActivity {
	private Handler handler = new Handler();
	public static ProfileGroupActivity group;
	public static ArrayList<View> arrList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ProfileGroupActivity.arrList = new ArrayList<View>();
		group = this;
		// if (GlobalVariable.isLogin) {
		// View view = getLocalActivityManager().startActivity(
		// "Profile",
		// new Intent(this, MyProfileActivity.class)
		// .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
		// .getDecorView();
		// replaceView(view);
		// } else {
		View view = getLocalActivityManager().startActivity(
				"Profile",
				new Intent(this, ProfileActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView();
		replaceView(view);
		// }

	}

	public void replaceView(View view) {
		arrList.add(view);
		setContentView(view);
	}

	public void replaceViewDoubleClick(View view) {
		arrList.add(view);
		setContentView(view);
		Activity activity = (Activity) view.getContext();
		((ProfileActivity) activity).reloadData();
	}

	public void back() {
		if (arrList.size() > 1) {
			arrList.remove(arrList.size() - 1);
			View view = arrList.get(arrList.size() - 1);
			setContentView(view);
			Activity activity = (Activity) view.getContext();
			// if (activity instanceof ProfileLoginFacebookActivity) {
			// ProfileLoginFacebookActivity.myCurrentActivity.reloadData();
			// }
			// if (activity instanceof ProfileFriendActivity) {
			// ((ProfileFriendActivity) activity).reloadData();
			// }
			// if (activity instanceof MyProfileFollowingActivity) {
			// ((MyProfileFollowingActivity) activity).reloadData();
			// }
			// if (activity instanceof MyProfileFollowersActivity) {
			// ((MyProfileFollowersActivity) activity).reloadData();
			// }
			// if (activity instanceof MyProfileFriendActivity) {
			// ((MyProfileFriendActivity) activity).reloadData();
			// }
			// if (activity instanceof ProfileFollowersActivity) {
			// ((ProfileFollowersActivity) activity).reloadData();
			// }
			// if (activity instanceof ProfileFollowingActivity) {
			// ((ProfileFollowingActivity) activity).reloadData();
			// }
			if (activity instanceof ProfileActivity) {
				((ProfileActivity) activity).reloadData();
			}
		} else {
			// this.finish();
		}
	}

	@Override
	public void onBackPressed() {
		if (arrList.size() > 1) {
			ProfileGroupActivity.group.back();
		} else {
			getParent().finish();
		}
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}