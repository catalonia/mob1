package com.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;

/**
 * The purpose of this Activity is to manage the activities in a tab. Note:
 * Child Activities can handle Key Presses before they are seen here.
 * 
 * @author Eric Harlow
 */
@SuppressWarnings("deprecation")
public class TabGroupActivity extends ActivityGroup {

	ArrayList<String> mIdList;

	 static TabGroupActivity group;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		group = this;
		if (mIdList == null)
			mIdList = new ArrayList<String>();
	}

	/**
	 * This is called when a child activity of this one calls its finish method.
	 * This implementation calls {@link LocalActivityManager#destroyActivity} on
	 * the child activity and starts the previous activity. If the last child
	 * activity just called finish(),this activity (the parent), calls finish to
	 * finish the entire group.
	 */
	@Override
	public void finishFromChild(Activity child) {
		LocalActivityManager manager = getLocalActivityManager();
		int index = mIdList.size() - 1;

		if (index < 1) {
			finish();
			return;
		}

		manager.destroyActivity(mIdList.get(index), true);
		mIdList.remove(index);
		index--;
		String lastId = mIdList.get(index);
		Intent lastIntent = manager.getActivity(lastId).getIntent();
		Window newWindow = manager.startActivity(lastId, lastIntent);
		setContentView(newWindow.getDecorView());
	}

	// public void finishAllChild(){
	// LocalActivityManager manager = getLocalActivityManager();
	// for(int i=1;i<mIdList.size();i++){
	// manager.destroyActivity(mIdList.get(i), true);
	// mIdList.remove(i);
	// }
	// Intent intent=new Intent();
	// Window window = manager.startActivity(mIdList.get(0),
	// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
	// setContentView(window.getDecorView());
	// }

	public void startChildActivity(String Id, Intent intent) {
		// Id += System.currentTimeMillis();
		int position = 0;
		boolean isExist = false;
		for (int i = 0; i < mIdList.size(); i++) {
			if (mIdList.get(i).equals(Id)) {
				position = i;
				isExist = true;
				break;
			}
		}
		if (isExist) {
			for (int j = mIdList.size() - 1; j >= position; j--) {
				Window window = getLocalActivityManager().destroyActivity(
						mIdList.get(j), true);
				if (window != null) {
					mIdList.remove(j);
				}
			}
		}
		Window windowCurrent = getLocalActivityManager().startActivity(Id,
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
		if (windowCurrent != null) {
			mIdList.add(Id);
			setContentView(windowCurrent.getDecorView());
		}

	}

	/**
	 * The primary purpose is to prevent systems before
	 * android.os.Build.VERSION_CODES.ECLAIR from calling their default
	 * KeyEvent.KEYCODE_BACK during onKeyDown.
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// preventing default implementation previous to
			// android.os.Build.VERSION_CODES.ECLAIR
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/**
	 * Overrides the default implementation for KeyEvent.KEYCODE_BACK so that
	 * all systems call onBackPressed().
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	/**
	 * If a Child Activity handles KeyEvent.KEYCODE_BACK. Simply override and
	 * add this method.
	 */
	@SuppressLint("Override")
	public void onBackPressed() {
		int length = mIdList.size();
		if (length > 1) {
			Activity current = getLocalActivityManager().getActivity(
					mIdList.get(length - 1));
			current.finish();
		}
	}

	// public void onBackPressed() {
	// int length = mIdList.size();
	// for (int i = length - 1; i > 1; i--) {
	// Activity current = getLocalActivityManager().getActivity(
	// mIdList.get(i));
	// current.finish();
	// }
	//
	// }

	@SuppressLint("ParserError")
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 5 || requestCode == 1 || requestCode == 2
				|| requestCode == 3 || requestCode == 4) {
			if (resultCode == Activity.RESULT_OK) {
				AskActivity activity = (AskActivity) getLocalActivityManager()
						.getCurrentActivity();
				activity.onActivityResult(requestCode, resultCode, data);
			}
		}
		if (requestCode == 11 || requestCode == 6 || requestCode == 7
				|| requestCode == 8 || requestCode == 9 || requestCode == 10) {
			if (resultCode == Activity.RESULT_OK) {
				FilterRestaurantActivity activity = (FilterRestaurantActivity) getLocalActivityManager()
						.getCurrentActivity();
				activity.onActivityResult(requestCode, resultCode, data);
			}
		}
		if (requestCode == 12) {
			if (resultCode == Activity.RESULT_OK) {
				RecommendationsActivity activity = (RecommendationsActivity) getLocalActivityManager()
						.getCurrentActivity();
				activity.onActivityResult(requestCode, resultCode, data);
			}
		}

	}
}
