package com.activity;

import com.tastesync.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class FilterRestaurant1Activity extends TabActivity {
	String content;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = getTabHost();

		// creat tab Ask
		TabSpec ask_tab = tabHost.newTabSpec("Ask");
		View view1 = getLayoutInflater().from(this).inflate(R.layout.tab_ask,
				null);
		recivedata();
		Intent askIntent = new Intent(this, AskActivity.class);
		askIntent.putExtra("content", content);
		ask_tab.setIndicator(view1);
		ask_tab.setContent(askIntent);

		// creat tab recommend
		TabSpec recommend_tab = tabHost.newTabSpec("Recommend");
		View view2 = getLayoutInflater().from(this).inflate(R.layout.tab_recom,
				null);
		Intent recomdIntent = new Intent(this, RecommendationsActivity.class);
		recommend_tab.setIndicator(view2);
		recommend_tab.setContent(recomdIntent);

		recommend_tab.setIndicator(view2);
		recommend_tab.setContent(recomdIntent);

		// creat tab Restaurants
		TabSpec res_tab = tabHost.newTabSpec("Restaurants");
		View view3 = getLayoutInflater().from(this).inflate(
				R.layout.tab_restaurants, null);
		Intent resIntent = new Intent(this, FilterRestaurantActivity.class);
		
		res_tab.setIndicator(view3);
		res_tab.setContent(resIntent);

		// add TabSpec tr�n v�o TabHost
		tabHost.addTab(ask_tab);
		tabHost.addTab(recommend_tab);
		tabHost.addTab(res_tab);
		tabHost.setCurrentTab(2);
	}
	public void recivedata()
	{
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			content = mBundle.getString("content");
		}
	}
}
