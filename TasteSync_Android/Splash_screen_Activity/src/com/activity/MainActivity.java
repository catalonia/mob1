package com.activity;

import com.tastesync.R;
import com.tastesync.R.layout;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends TabActivity {

	String neighbor, ambience, price, whowithyou, cusine;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final TabHost tabHost = getTabHost();

		// creat tab Ask
		TabSpec ask_tab = tabHost.newTabSpec("Ask");
		View view1 = getLayoutInflater().from(this).inflate(R.layout.tab_ask,
				null);
		Intent askIntent = new Intent(this, AskGroupActivity.class);

		//recivedata();
		askIntent.putExtra("neighbor", neighbor);
		askIntent.putExtra("ambience", ambience);
		askIntent.putExtra("price", price);
		askIntent.putExtra("whowithyou", whowithyou);
		askIntent.putExtra("cusine", cusine);

		ask_tab.setIndicator(view1);
		ask_tab.setContent(askIntent);

		// creat tab recommend
		TabSpec recommend_tab = tabHost.newTabSpec("Recommend");
		View view2 = getLayoutInflater().from(this).inflate(R.layout.tab_recom,
				null);
		Intent recomdIntent = new Intent(this,
				RecommendationsGroupActivity.class);
		//recivedata();
		recommend_tab.setIndicator(view2);
		recommend_tab.setContent(recomdIntent);

		// creat tab Restaurants
		TabSpec res_tab = tabHost.newTabSpec("Restaurants");
		View view3 = getLayoutInflater().from(this).inflate(
				R.layout.tab_restaurants, null);
		Intent resIntent = new Intent(this, RestaurantGroupActivity.class);
		//recivedata();
		askIntent.putExtra("neighbor", neighbor);
		askIntent.putExtra("ambience", ambience);
		askIntent.putExtra("price", price);
		askIntent.putExtra("whowithyou", whowithyou);
		askIntent.putExtra("cusine", cusine);
		res_tab.setIndicator(view3);
		res_tab.setContent(resIntent);

//		// creat tab recommend
//		TabSpec pro_tab = tabHost.newTabSpec("Profile");
//		View view4 = getLayoutInflater().from(this).inflate(R.drawable.btn_profile,
//				null);
//		Intent profileIntent = new Intent(this,
//				ProfileGroupActivity.class);
//		//recivedata();
//		pro_tab.setIndicator(view4);
//		pro_tab.setContent(profileIntent);

		// add TabSpec trên vào TabHost
		tabHost.addTab(ask_tab);
		tabHost.addTab(recommend_tab);
		tabHost.addTab(res_tab);
//		tabHost.addTab(pro_tab);
		
		// tabHost.getTabWidget().getChildTabViewAt(3)
		// .setVisibility(View.GONE);

		// tabHost.setOnTouchListener(new OnTouchListener(){
		// @Override
		// public void onTabChanged(String tabId) {
		// Log.i("TabId :", tabId);
		// if(tabId.equals("TAB2")){
		// Log.i("TAB1", "TAB1 Changed");
		// Intent intent1 = new Intent().setClass(getApplicationContext(),
		// Tab1Activity.class);
		// sp1.setIndicator("TAB1").setContent(intent1);
		// tabHost.setCurrentTab(0);
		// }
		// }
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent arg1) {
		// // TODO Auto-generated method stub
		// return false;
		// }
		// });

		// getTabWidget().setOnTouchListener(new View.OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// // TODO Auto-generated method stub
		// if (tabHost.getCurrentTab() == 0) {
		// // String view = TabGroupActivity.mIdList.get(0);
		// // TabGroupActivity.group.mIdList.clear();
		// AskGroupActivity.group.startChildActivity("AskActivity",
		// new Intent(MainActivity.this, AskActivity.class));
		// }
		// if (tabHost.getCurrentTab() == 1) {
		// // String view = TabGroupActivity.mIdList.get(0);
		// // TabGroupActivity.group.mIdList.clear();
		// RecommendationsGroupActivity.group.startChildActivity(
		// "Recommendations", new Intent(MainActivity.this,
		// RecommendationsActivity.class));
		// }
		// if (tabHost.getCurrentTab() == 2) {
		// // String view = TabGroupActivity.mIdList.get(0);
		// // TabGroupActivity.group.mIdList.clear();
		// RestaurantGroupActivity.group.startChildActivity(
		// "RestaurantsActivity", new Intent(
		// MainActivity.this,
		// RestaurantsActivity.class));
		// }
		// return false;
		// }
		// });
		// tabHost.getTabWidget().getChildAt(0)
		// .setOnTouchListener(new View.OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// // TODO Auto-generated method stub
		// if (tabHost.getCurrentTab() == 0) {
		// // String view = TabGroupActivity.mIdList.get(0);
		// // TabGroupActivity.group.mIdList.clear();
		// AskGroupActivity.group.startChildActivity(
		// "AskActivity", new Intent(
		// MainActivity.this,
		// AskActivity.class));
		// }
		// return false;
		// }
		// });
		getTabWidget().getChildAt(0).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTab(0);
				View view = AskGroupActivity.arrList.get(0);
				AskGroupActivity.group.arrList.clear();
				AskGroupActivity.group.replaceView(view);
				// if (tabHost.getCurrentTab() == 0) {
				// Toast.makeText(MainActivity.this, "Ask", 5000).show();
				// AskGroupActivity.group.startChildActivity("AskActivity",
				// new Intent(getBaseContext(), AskActivity.class));
				// }

			}
		});
		getTabWidget().getChildAt(1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTab(1);
				// Toast.makeText(MainActivity.this, "Recommendations", 5000)
				// .show();
				// if (tabHost.getCurrentTab() == 1) {
				// RecommendationsGroupActivity.group.startChildActivity(
				// "Recommendations", new Intent(getBaseContext(),
				// RecommendationsActivity.class));
				// }
				View view = RecommendationsGroupActivity.arrList.get(0);
				RecommendationsGroupActivity.group.arrList.clear();
				RecommendationsGroupActivity.group.replaceView(view);

			}
		});
		getTabWidget().getChildAt(2).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTab(2);
				// Toast.makeText(MainActivity.this, "Restaurant", 5000).show();
				// if (tabHost.getCurrentTab() == 1) {
				// RestaurantGroupActivity.group.startChildActivity(
				// "RestaurantsActivity", new Intent(getBaseContext(),
				// RestaurantsActivity.class));
				View view = RestaurantGroupActivity.arrList.get(0);
				RestaurantGroupActivity.group.arrList.clear();
				RestaurantGroupActivity.group.replaceViewDoubleClick(view);
				// }

			}
		});
		// tabHost.getTabWidget().getChildAt(1)
		// .setOnTouchListener(new View.OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// // TODO Auto-generated method stub
		// if (tabHost.getCurrentTab() == 1) {
		// // String view = TabGroupActivity.mIdList.get(0);
		// // TabGroupActivity.group.mIdList.clear();
		// RecommendationsGroupActivity.group
		// .startChildActivity(
		// "Recommendations",
		// new Intent(
		// MainActivity.this,
		// RecommendationsActivity.class));
		// }
		// return false;
		// }
		// });
		// tabHost.getTabWidget().getChildAt(2)
		// .setOnTouchListener(new View.OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// // TODO Auto-generated method stub
		// if (tabHost.getCurrentTab() == 2) {
		// // String view = TabGroupActivity.mIdList.get(0);
		// // TabGroupActivity.group.mIdList.clear();
		// RestaurantGroupActivity.group.startChildActivity(
		// "RestaurantsActivity", new Intent(
		// MainActivity.this,
		// RestaurantsActivity.class));
		// }
		// return false;
		// }
		// });
	}

	public void recivedata() {
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			neighbor = mBundle.getString("neighbor");
			ambience = mBundle.getString("ambience");
			price = mBundle.getString("price");
			whowithyou = mBundle.getString("whowithyou");
			cusine = mBundle.getString("cusine");
		}
	}

}
