package com.tastesync;

import com.activity.AskActivity;
import com.activity.Recommandations2Activity;
import com.activity.RecommendActivity;
import com.activity.RestaurantsActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class showRecommandActivity2 extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		// creat tab Ask
		TabSpec ask_tab = tabHost.newTabSpec("Ask");
		View view1 = getLayoutInflater().from(this).inflate(R.layout.tab_ask,
				null);
		Intent askIntent = new Intent(this, AskActivity.class);

		ask_tab.setIndicator(view1);
		ask_tab.setContent(askIntent);

		// creat tab recommend
		TabSpec recommend_tab = tabHost.newTabSpec("Recommend");
		View view2 = getLayoutInflater().from(this).inflate(R.layout.tab_recom,
				null);
		Intent recomdIntent = new Intent(this, Recommandations2Activity.class);
		recommend_tab.setIndicator(view2);
		recommend_tab.setContent(recomdIntent);

		recommend_tab.setIndicator(view2);
		recommend_tab.setContent(recomdIntent);

		// creat tab Restaurants
		TabSpec res_tab = tabHost.newTabSpec("Restaurants");
		View view3 = getLayoutInflater().from(this).inflate(
				R.layout.tab_restaurants, null);
		Intent resIntent = new Intent(this, RestaurantsActivity.class);
		res_tab.setIndicator(view3);
		res_tab.setContent(resIntent);

		// add TabSpec trên vào TabHost
		tabHost.addTab(ask_tab);
		tabHost.addTab(recommend_tab);
		tabHost.addTab(res_tab);
		tabHost.setCurrentTab(1);
	}
}
