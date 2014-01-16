package com.activity;

import java.util.ArrayList;

import com.adapter.Database_Taste;
import com.adapter.MyAdapterString;
import com.adapter.restaurant;
import com.tastesync.R;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class RestaurantsActivity extends Activity {

	public ListView lsData;
	public MyAdapterString arrayAdapter;
	public ArrayList<restaurant> arrayList;
	private Database_Taste dbManager;
	private EditText edSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurants);
		dbManager = new Database_Taste(this);

		final ArrayList<restaurant> list = getAllList();

		lsData = (ListView) findViewById(R.id.lv_find_restaurant);

		arrayAdapter = new MyAdapterString(this, list);
		lsData.setAdapter(arrayAdapter);
		lsData.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				Toast.makeText(getBaseContext(), "View " + arg2, 1000).show();

			}
		});
		edSearch = (EditText) findViewById(R.id.ed_search);
		edSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				arrayAdapter.getFilter().filter(s);

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}
		});
	}

	public ArrayList<restaurant> getAllList() {
		ArrayList<restaurant> list = dbManager.getnamelist();
		return list;
	}
}
