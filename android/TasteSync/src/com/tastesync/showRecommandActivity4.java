package com.tastesync;

import com.activity.AskActivity;
import com.activity.Recommandations4Activity;
import com.activity.RecommendActivity;
import com.activity.RestaurantsActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class showRecommandActivity4 extends TabActivity {
	String position = null, size = null;

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
		Intent recomdIntent = new Intent(this, Recommandations4Activity.class);
		recivedata();
		recomdIntent.putExtra("position", "" + position);
		recomdIntent.putExtra("size", "" + size);
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
	public void recivedata()
	{
		Bundle data = getIntent().getExtras();
		if (data != null) {
			position = data.getString("position");
			size = data.getString("size");
		}
	}
}
