package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterAmbience;
import com.model.Ambience;
import com.tastesync.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;

public class PriceActivity extends Activity {
	Button btn_done;
	ListView list;
	String kq = "", price = "";
	AdapterAmbience adapter;
	public ArrayList<Ambience> mArrayList = new ArrayList<Ambience>();
	Boolean check = false;
	public ArrayList<String> mStrings = new ArrayList<String>();
	public ArrayList<String> mStrings_recive = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ambience);
		getWindow().setSoftInputMode(
				   WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		/******** Take some data in Arraylist ( mArrayList ) ***********/
		setListData();
		recivedata();
		refreshData();

		Resources res = getResources();
		list = (ListView) findViewById(R.id.list);
		btn_done = (Button) findViewById(R.id.btn_done_ambience);
		/**************** Create Custom Adapter *********/
		adapter = new AdapterAmbience(this, mArrayList, res);
		list.setAdapter(adapter);
		btn_done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent();
				Log.d(STORAGE_SERVICE, "" + kq);
				mIntent.putExtra("data", kq);
				kq = kq.replace(" ", "");
				if (mStrings.size() == 0) {
					check = true;
				} else {
					check = false;
				}
				mIntent.putStringArrayListExtra("array", mStrings);
				mIntent.putExtra("invi", check);
				setResult(RESULT_OK, mIntent);

				finish();
			}
		});
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				if (mArrayList.get(position).isVisible()) {
					mArrayList.get(position).setVisible(false);
					kq = kq.replace("/"
							+ mArrayList.get(position).getCompanyName(), "");
					kq = kq.replace(mArrayList.get(position).getCompanyName(),
							"");
					if (mStrings.size() > 0) {
						for (int i = 0; i < mStrings.size(); i++) {
							if (mStrings.get(i).equals(
									mArrayList.get(position).getCompanyName())) {
								mStrings.remove(i);
							}
						}
					}
				} else {
					mArrayList.get(position).setVisible(true);
					if (kq.length() != 0) {
						kq += "/" + mArrayList.get(position).getCompanyName();
						switch (mArrayList.get(position).getCompanyName()
								.trim().length()) {
						case 1:
							price = "a budget";
							break;
						case 2:
							price = "an affordable";
							break;
						case 3:
							price = "an affordable";
							break;
						case 4:
							price = "an upscale";
							break;
						case 5:
							price = "an upscale";
							break;

						default:
							break;
						}
						mStrings.add(price);
					} else {
						kq += mArrayList.get(position).getCompanyName();
						switch (mArrayList.get(position).getCompanyName()
								.trim().length()) {
						case 1:
							price = "a budget";
							break;
						case 2:
							price = "an affordable";
							break;
						case 3:
							price = "an affordable";
							break;
						case 4:
							price = "an upscale";
							break;
						case 5:
							price = "an upscale";
							break;

						default:
							break;
						}
						mStrings.add(price);
					}
				}
				adapter.notifyDataSetChanged();
			}
		});

	}

	public void recivedata() {
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			mStrings_recive = mBundle.getStringArrayList("array1");
			for (int i = 0; i < mStrings_recive.size(); i++) {
				String tam = mStrings_recive.get(i);
				mStrings.add(tam);
			}
		}
	}

	public void refreshData() {
		for (int i = 0; i < mStrings_recive.size(); i++) {
			String tam = mStrings_recive.get(i);
			for (int j = 0; j < mArrayList.size(); j++) {
				String tam1 = mArrayList.get(j).getCompanyName();
				if (tam1.equals(tam)) {
					mArrayList.get(j).setVisible(true);
				}
			}
		}
	}

	/****** Function to set data in ArrayList *************/
	public void setListData() {
		final Ambience item1 = new Ambience();
		item1.setCompanyName("  $  ");
		item1.setImage("onedollar");
		mArrayList.add(item1);

		final Ambience item2 = new Ambience();
		item2.setCompanyName("  $$  ");
		item2.setImage("twodollar");
		mArrayList.add(item2);

		final Ambience item3 = new Ambience();
		item3.setCompanyName("  $$$  ");
		item3.setImage("threedollar");
		mArrayList.add(item3);

		final Ambience item4 = new Ambience();
		item4.setCompanyName("  $$$$  ");
		item4.setImage("fourdollar");
		mArrayList.add(item4);

		final Ambience item5 = new Ambience();
		item5.setCompanyName("  $$$$$  ");
		item5.setImage("fivedollar");
		mArrayList.add(item5);

	}

}
