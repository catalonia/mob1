package com.activity;

import java.util.ArrayList;

import com.adapter.Adapterrecommandations;
import com.adapter.recommandations;
import com.tastesync.R;
import com.tastesync.showRecommandActivity1;
import com.tastesync.showRecommandActivity2;
import com.tastesync.showRecommandActivity3;
import com.tastesync.showRecommandActivity4;
import com.tastesync.showRecommandActivity5;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;

public class RecommendActivity extends Activity {
	TextView tv_numberRecommand;
	ListView list;
	Adapterrecommandations adapter;
	public RecommendActivity CustomListView = null;
	public ArrayList<recommandations> CustomListViewValuesArr = new ArrayList<recommandations>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recomend);

		CustomListView = this;
		setListData();
		tv_numberRecommand = (TextView) findViewById(R.id.tv_number_recommand);
		Resources res = getResources();
		list = (ListView) findViewById(R.id.lv_recommendations);
		adapter = new Adapterrecommandations(CustomListView,
				CustomListViewValuesArr, res);
		list.setAdapter(adapter);
		tv_numberRecommand.setText(adapter.getCount() + " NOTIFICATIONS");
	}

	/****** Function to set data in ArrayList *************/
	public void setListData() {

		final recommandations data = new recommandations();

		/******* Firstly take data in model object ******/
		data.settitle("needs a recomme...");
		data.setName("Person 1. ");
		data.setImage("image");
		data.setconttent("Person wrote: this message is test for prototype ...more");
		CustomListViewValuesArr.add(data);
		
		final recommandations data1 = new recommandations();
		
		data1.settitle("Restaurants Rec...");
		data1.setName("Person 2. ");
		data1.setImage("image");
		data1.setconttent("Person wrote: this message is test for prototype ...more");
		CustomListViewValuesArr.add(data1);

		final recommandations data2 = new recommandations();

		data2.settitle("Send you a message");
		data2.setName("Person 3. ");
		data2.setImage("image");
		data2.setconttent("Person wrote: this message is test for prototype ...more");
		CustomListViewValuesArr.add(data2);
		
		final recommandations data3 = new recommandations();

		data3.settitle("has a follow-up...");
		data3.setName("Person 4. ");
		data3.setImage("image");
		data3.setconttent("Person wrote: this message is test for prototype ...more");
		CustomListViewValuesArr.add(data3);

		final recommandations data4 = new recommandations();

		data4.settitle("Like your recom...");
		data4.setName("Person 5. ");
		data4.setImage("image");
		data4.setconttent("Person wrote: this message is test for prototype ...more");
		CustomListViewValuesArr.add(data4);
	}

	public void onItemClick(int mPosition) {
		int check, send;
		recommandations tempValues = (recommandations) CustomListViewValuesArr
				.get(mPosition);
		send = mPosition + 1;
		String s = tempValues.getName();
		check = Integer.parseInt("" + s.charAt(s.length() - 3));
		switch (check) {
		case 1:
			Intent mIntent = new Intent(this, showRecommandActivity1.class);
			mIntent.putExtra("position", "" + send);
			mIntent.putExtra("size", "" + adapter.getCount());
			startActivity(mIntent);
			break;
		case 2:
			Intent mIntent1 = new Intent(this, showRecommandActivity2.class);
			startActivity(mIntent1);
			break;
		case 3:
			Intent mIntent2 = new Intent(this, showRecommandActivity3.class);
			mIntent2.putExtra("position", "" + send);
			mIntent2.putExtra("size", "" + adapter.getCount());
			startActivity(mIntent2);
			break;
		case 4:
			Intent mIntent3 = new Intent(this, showRecommandActivity4.class);
			mIntent3.putExtra("position", "" + send);
			mIntent3.putExtra("size", "" + adapter.getCount());
			startActivity(mIntent3);
			break;
		case 5:
			Intent mIntent4 = new Intent(this, showRecommandActivity5.class);
			mIntent4.putExtra("position", "" + send);
			mIntent4.putExtra("size", "" + adapter.getCount());
			startActivity(mIntent4);
			break;
		default:
			break;
		}
	}

}
