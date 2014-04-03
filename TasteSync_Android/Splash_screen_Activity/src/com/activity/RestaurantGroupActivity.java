package com.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class RestaurantGroupActivity extends TabGroupActivity {
	private Handler handler = new Handler();
	public static RestaurantGroupActivity group;
	public static ArrayList<View> arrList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		RestaurantGroupActivity.arrList = new ArrayList<View>();
		group = this;

		View view = getLocalActivityManager().startActivity(
				"Restaurant",
				new Intent(this, RestaurantsActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
				.getDecorView();
		replaceView(view);
	}

	public void replaceView(View view) {
		arrList.add(view);
		setContentView(view);
	}
	public void replaceViewDoubleClick(View view) {
		arrList.add(view);
		setContentView(view);
		Activity activity = (Activity) view.getContext();
		//((RestaurantFindActivity)activity).reloadData();
	}

	public void back() {
		if (arrList.size() > 1) {
			arrList.remove(arrList.size() - 1);
				View view = arrList.get(arrList.size() - 1);
				setContentView(view);
				Activity activity = (Activity) view.getContext();
				if(activity instanceof RestaurantsActivity){
					((RestaurantsActivity)activity).reloadData();
				}
//				if(activity instanceof RestaurantFindActivity){
//					((RestaurantFindActivity)activity).reloadData();
//				}
		} else {
			this.finish();
		}
	}

	@Override
	public void onBackPressed() {
//		TabActivity tabActivity4 = (TabActivity) getParent();
//		if (GlobalVariable.isSwitchRecommendToRestaurant) {
//			GlobalVariable.isSwitchRecommendToRestaurant = false;
//			tabActivity4.getTabHost().setCurrentTab(1);
//			RestaurantGroupActivity.group.back();
//		} else {
//			if (GlobalVariable.isSwitchProfileToRestaurant) {
//				GlobalVariable.isSwitchProfileToRestaurant = false;
//				tabActivity4.getTabHost().setCurrentTab(3);
//				RestaurantGroupActivity.group.back();
//			} else {
//				RestaurantGroupActivity.group.back();
//			}
//		}
		RestaurantGroupActivity.group.back();
	}
}

//package com.activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//public class RestaurantGroupActivity extends TabGroupActivity {
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		startChildActivity("RestaurantsActivity", new Intent(this, RestaurantsActivity.class));
//	}
//
//}
