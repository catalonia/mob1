package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterAmbience;
import com.google.android.gms.maps.internal.m;
import com.model.Ambience;
import com.tastesync.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;

public class WhowithyouActivity extends Activity {
	Button btn_done;
	ListView list;
	String kq = "";
	AdapterAmbience adapter;
	public ArrayList<Ambience> mArrayList = new ArrayList<Ambience>();
	Boolean check = false;
	public ArrayList<String> mStrings = new ArrayList<String>();
	public ArrayList<String> mStrings_who = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ambience);

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
				if (mStrings.size() == 0) {
					check = true;
				} else {
					check = false;
				}
				mIntent.putStringArrayListExtra("array", mStrings);
				mIntent.putExtra("invi", check);
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
						mStrings.add(mArrayList.get(position).getCompanyName());
					} else {
						kq += mArrayList.get(position).getCompanyName();
						mStrings.add(mArrayList.get(position).getCompanyName());
					}
				}
				adapter.notifyDataSetChanged();
			}
		});

	}

	public void recivedata() {
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			mStrings_who = mBundle.getStringArrayList("array1");
			for (int i = 0; i < mStrings_who.size(); i++) {
				String tam = mStrings_who.get(i);
				mStrings.add(tam);
			}
		}
	}

	public void refreshData() {
		for (int i = 0; i < mStrings_who.size(); i++) {
			String tam = mStrings_who.get(i);
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
		item1.setCompanyName("A Date");
		item1.setImage("date");
		mArrayList.add(item1);

		final Ambience item2 = new Ambience();
		item2.setCompanyName("Colleagues");
		item2.setImage("colleagues");
		mArrayList.add(item2);

		final Ambience item3 = new Ambience();
		item3.setCompanyName("Family");
		item3.setImage("withfamily");
		mArrayList.add(item3);

		final Ambience item4 = new Ambience();
		item4.setCompanyName("Friends");
		item4.setImage("friends");
		mArrayList.add(item4);

		final Ambience item5 = new Ambience();
		item5.setCompanyName("Kids");
		item5.setImage("kids");
		mArrayList.add(item5);

		final Ambience item6 = new Ambience();
		item6.setCompanyName("My Phone");
		item6.setImage("myphone");
		mArrayList.add(item6);

		final Ambience item7 = new Ambience();
		item7.setCompanyName("Teens");
		item7.setImage("teens");
		mArrayList.add(item7);
	}

}
