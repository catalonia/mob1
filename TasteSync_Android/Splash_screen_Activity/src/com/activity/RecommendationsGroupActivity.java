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
public class RecommendationsGroupActivity extends TabGroupActivity {
	private Handler handler = new Handler();
	public static RecommendationsGroupActivity group;
	public static ArrayList<View> arrList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		RecommendationsGroupActivity.arrList = new ArrayList<View>();
		group = this;
//		if (GlobalVariable.isLogin) {
//			View view = getLocalActivityManager().startActivity(
//					"Profile",
//					new Intent(this, RecommendationsActivity.class)
//							.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//					.getDecorView();
//			replaceView(view);
//		} else {
			View view = getLocalActivityManager().startActivity(
					"Recommendation",
					new Intent(this, RecommendationsActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
					.getDecorView();
			replaceView(view);
//		}

	}

	public void replaceView(View view) {
		arrList.add(view);
		setContentView(view);
	}

	public void replaceViewDoubleClick(View view) {
		arrList.add(view);
		setContentView(view);
		Activity activity = (Activity) view.getContext();
		if (activity instanceof RecommendationsActivity) {
			((RecommendationsActivity) activity).reloadData();
		}
	}

	public void back() {
		if (arrList.size() > 1) {
			arrList.remove(arrList.size() - 1);
//			if (arrList.size() == 1) {
//				View view = getLocalActivityManager().startActivity(
//						"RecommendationsActivity",
//						new Intent(this, RecommendationsActivity.class)
//								.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//						.getDecorView();
//				setContentView(view);
//				Activity activity = (Activity) view.getContext();
//				//((RecommendationsActivity) activity).reloadData();
//			} else {
				View view = arrList.get(arrList.size() - 1);
				setContentView(view);
				Activity activity = (Activity) view.getContext();
				if(activity instanceof RecommendationsActivity){
					((RecommendationsActivity)activity).reloadData();
				}
			// }
		} else {
			this.finish();
			//MyAplication.ArrayRecomendation.clear();
		}
	}

	@Override
	public void onBackPressed() {
		RecommendationsGroupActivity.group.back();
	}
}

//package com.activity;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//
//public class RecommendationsGroupActivity extends TabGroupActivity {
//
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		super.onCreate(savedInstanceState);
//		startChildActivity("RecommendationsActivity", new Intent(this,
//				RecommendationsActivity.class));
//		// View view = getLocalActivityManager().startActivity(
//		// "RecommendationsActivity",
//		// new Intent(this, RecommendationsActivity.class)
//		// .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//		// .getDecorView();
//		// setContentView(view);
//	}
//	
//}
