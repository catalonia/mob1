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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;

public class AmbienceActivity extends Activity {
	ImageView img_profile;
	Button btn_done;
	ListView list;
	String kq = "", test = "";
	AdapterAmbience adapter;
	public ArrayList<Ambience> listAmbience = new ArrayList<Ambience>();
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
		img_profile = (ImageView) findViewById(R.id.imageProfile);
		btn_done = (Button) findViewById(R.id.btn_done_ambience);
		/**************** Create Custom Adapter *********/
		adapter = new AdapterAmbience(this, listAmbience, res);
		list.setAdapter(adapter);
		img_profile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(AmbienceActivity.this,
						ProfileActivity.class);
				startActivity(mIntent);
			}
		});
		btn_done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent mIntent = new Intent();
				// Intent mIntent = new Intent();
				// Log.d(STORAGE_SERVICE, "" + kq);
				// mIntent.putExtra("data", kq);
				// kq = kq.replace(" ", "");
				// if (mStrings.size() == 0) {
				// check = true;
				// } else {
				// check = false;
				// }
				// mIntent.putStringArrayListExtra("array", mStrings);
				// mIntent.putExtra("invi", check);
				// setResult(RESULT_OK, mIntent);

				Intent mIntent = new Intent(AmbienceActivity.this,
						AskActivity.class);
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
				if (listAmbience.get(position).isVisible()) {
					listAmbience.get(position).setVisible(false);
					kq = kq.replace("/"
							+ listAmbience.get(position).getCompanyName(), "");
					kq = kq.replace(
							listAmbience.get(position).getCompanyName(), "");
					if (mStrings.size() > 0) {
						for (int i = 0; i < mStrings.size(); i++) {
							if (mStrings.get(i)
									.equals(listAmbience.get(position)
											.getCompanyName())) {
								mStrings.remove(i);
							}
						}
					}

				} else {
					listAmbience.get(position).setVisible(true);
					if (kq.length() != 0) {
						kq += "/" + listAmbience.get(position).getCompanyName();
						mStrings.add(listAmbience.get(position)
								.getCompanyName());
					} else {
						kq += listAmbience.get(position).getCompanyName();
						mStrings.add(listAmbience.get(position)
								.getCompanyName());
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
			for (int j = 0; j < listAmbience.size(); j++) {
				String tam1 = listAmbience.get(j).getCompanyName();
				if (tam1.equals(tam)) {
					listAmbience.get(j).setVisible(true);
				}
			}
		}
	}

	/****** Function to set data in ArrayList *************/
	public void setListData() {
		final Ambience item1 = new Ambience();
		item1.setCompanyName("Romantic");
		item1.setImage("romantic");
		listAmbience.add(item1);

		final Ambience item2 = new Ambience();
		item2.setCompanyName("Trendy");
		item2.setImage("trendy");
		listAmbience.add(item2);

		final Ambience item3 = new Ambience();
		item3.setCompanyName("Relaxed");
		item3.setImage("relaxed");
		listAmbience.add(item3);

		final Ambience item4 = new Ambience();
		item4.setCompanyName("Intimate");
		item4.setImage("intimate");
		listAmbience.add(item4);

		final Ambience item5 = new Ambience();
		item5.setCompanyName("Fine Dining");
		item5.setImage("finedining");
		listAmbience.add(item5);

		final Ambience item6 = new Ambience();
		item6.setCompanyName("Gourmet");
		item6.setImage("gourmet");
		listAmbience.add(item6);

		final Ambience item7 = new Ambience();
		item7.setCompanyName("Casual");
		item7.setImage("casual");
		listAmbience.add(item7);

		final Ambience item8 = new Ambience();
		item8.setCompanyName("Business Friendly");
		item8.setImage("business");
		listAmbience.add(item8);

		final Ambience item9 = new Ambience();
		item9.setCompanyName("Late nights");
		item9.setImage("latenight");
		listAmbience.add(item9);

		final Ambience item10 = new Ambience();
		item10.setCompanyName("Live music");
		item10.setImage("livemusic");
		listAmbience.add(item10);

		final Ambience item11 = new Ambience();
		item11.setCompanyName("Bar scene");
		item11.setImage("bar1");
		listAmbience.add(item11);

		final Ambience item12 = new Ambience();
		item12.setCompanyName("BYOB");
		item12.setImage("byob");
		listAmbience.add(item12);

		final Ambience item13 = new Ambience();
		item13.setCompanyName("Extensive wine list");
		item13.setImage("winelist");
		listAmbience.add(item13);

		final Ambience item14 = new Ambience();
		item14.setCompanyName("Group Friendly");
		item14.setImage("group");
		listAmbience.add(item14);

		final Ambience item15 = new Ambience();
		item15.setCompanyName("Family Friendly");
		item15.setImage("family");
		listAmbience.add(item15);

		final Ambience item16 = new Ambience();
		item16.setCompanyName("BBQ joint");
		item16.setImage("bbq");
		listAmbience.add(item16);

		final Ambience item17 = new Ambience();
		item17.setCompanyName("Steakhouse");
		item17.setImage("steak");
		listAmbience.add(item17);

		final Ambience item18 = new Ambience();
		item18.setCompanyName("Open kitchen");
		item18.setImage("openkitchen");
		listAmbience.add(item18);

		final Ambience item19 = new Ambience();
		item19.setCompanyName("Organic food");
		item19.setImage("organic");
		listAmbience.add(item19);

		final Ambience item20 = new Ambience();
		item20.setCompanyName("Scenic");
		item20.setImage("scenic");
		listAmbience.add(item20);

		final Ambience item21 = new Ambience();
		item21.setCompanyName("Cafe");
		item21.setImage("cafe");
		listAmbience.add(item21);

		final Ambience item22 = new Ambience();
		item22.setCompanyName("Bakery");
		item22.setImage("bakery");
		listAmbience.add(item22);

		final Ambience item23 = new Ambience();
		item23.setCompanyName("Dinner");
		item23.setImage("dinner");
		listAmbience.add(item23);

		final Ambience item24 = new Ambience();
		item24.setCompanyName("Brunch");
		item24.setImage("brunch");
		listAmbience.add(item24);

		final Ambience item25 = new Ambience();
		item25.setCompanyName("Breakfast");
		item25.setImage("bkfst");
		listAmbience.add(item25);

		final Ambience item26 = new Ambience();
		item26.setCompanyName("Lunch");
		item26.setImage("lunch");
		listAmbience.add(item26);

		final Ambience item27 = new Ambience();
		item27.setCompanyName("Coffee");
		item27.setImage("coffee");
		listAmbience.add(item27);
	}

}
