package com.adapter;

import java.util.ArrayList;
import java.util.List;

import com.model.Profile;
import com.tastesync.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class AdapterNewsFeed extends BaseAdapter implements
		OnClickListener {
	// private int resourceID;
	private Context context;
	public ArrayList<Profile> list_profile;

	public AdapterNewsFeed(Context context,
			ArrayList<Profile> list_profile) {
		this.context = context;
		this.list_profile = list_profile;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list_profile.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list_profile.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		final Profile item = list_profile.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_newsfeed, null);
		}
		TextView text_name = (TextView) convertView
				.findViewById(R.id.txt_newsfeed_username);
		ImageView avatar = (ImageView) convertView
				.findViewById(R.id.img_newsfeed_avatar);
		text_name.setText(""+item.getUsername());
		avatar.setImageResource(R.drawable.avatar);

		return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
