package com.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tastesync.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.app.Activity;

public class SearchFriendAdapter extends ArrayAdapter<HashMap<String, Object>> {
	private Context context;
	private int textViewResourceId;
	public ArrayList<HashMap<String, Object>> list_obj;

	// public SearchFriendAdapter(Context context,
	// ArrayList<Profile> list_profile) {
	// this.context = context;
	// this.list_profile = list_profile;
	// }
	public SearchFriendAdapter(Context context, int textViewResourceId,
			ArrayList<HashMap<String, Object>> objects) {
		super(context, textViewResourceId, objects);
		this.context = context;
		this.textViewResourceId = textViewResourceId;
		this.list_obj = objects;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		final HashMap<String, Object> item = list_obj.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_friend, null);
		}
		TextView text_name = (TextView) convertView
				.findViewById(R.id.tv_following_friend_name_item);
		ImageView avatar = (ImageView) convertView
				.findViewById(R.id.img_folowing_friend_item_avatar);
		text_name.setText(item.get("username").toString());
		avatar.setImageResource(R.drawable.avatar);

		return convertView;
	}

}
