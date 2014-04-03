package com.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.adapter.AdapterNeighbor;
import com.adapter.AdapterContact;
import com.model.Contacts;
import com.model.neighbor;
import com.tastesync.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AskfreindActivity extends Activity {

	private ListView listView;
	EditText mEditText;
	Button btn_done;
	AdapterContact objAdapter;
	private List<Contacts> list = new ArrayList<Contacts>();
	private List<Contacts> searchResults = new ArrayList<Contacts>();
	String displayName, address, content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listcontact);
		getWindow().setSoftInputMode(
				   WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		listView = (ListView) findViewById(R.id.list);
		setlistData();
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Contacts bean = (Contacts) listView.getItemAtPosition(position);
				Email(bean.getName(), bean.getEmail());
			}
		});
		mEditText = (EditText) findViewById(R.id.edt_search_contact);
		mEditText.setHint("Search Contacts");
		btn_done = (Button) findViewById(R.id.btn_done_listcontact);
		mEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				String searchString = mEditText.getText().toString();
				int textLength = searchString.length();
				searchResults = new ArrayList<Contacts>();

				// clear the initial data set
				searchResults.clear();

				for (int i = 0; i < list.size(); i++) {
					String values = list.get(i).getName().toString();

					if (textLength <= values.length()) {
						if (searchString.equalsIgnoreCase(values.substring(0,
								textLength)))
							searchResults.add(list.get(i));
						objAdapter = new AdapterContact(
								AskfreindActivity.this, R.layout.item_contact,
								searchResults);
						listView.setAdapter(objAdapter);
					}
				}
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
		btn_done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		objAdapter = new AdapterContact(AskfreindActivity.this,
				R.layout.item_contact, list);
		listView.setAdapter(objAdapter);
	}

	public void Email(String name, String email) {
		String to = email;
		recivedata();
		String message = content;
		Intent mIntent = new Intent(AskfreindActivity.this,
				Email_Activity.class);
		mIntent.putExtra("to", email);
		mIntent.putExtra("content", content);
		startActivity(mIntent);
	}

	public void recivedata() {
		Bundle mBundle = getIntent().getExtras();
		if (mBundle != null) {
			content = mBundle.getString("content");
		}
	}

	public void setlistData() {
		list.add(new Contacts("Dao Quang", "duykhanh.t2@gmail.com", "113", true));
		list.add(new Contacts("An Thai", "123@yahoo.com", "", false));
		list.add(new Contacts("Phu Phan", "test001@gmail.com", "12", false));
		list.add(new Contacts("Hung Truong Duc", "test002@gmail.com", "", true));
	}
}
