package com.adapter;

import java.util.ArrayList;

import com.model.Tips;
import com.model.neighbor;
import com.tastesync.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter_tips extends BaseAdapter {

	public Context context;
	public ArrayList<Tips> listtip;

	public Adapter_tips(Context context, ArrayList<Tips> items) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.listtip = items;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listtip.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listtip.get(position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Tips item = listtip.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_buzz, null);

		}

		TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title2);
		TextView tv_content = (TextView) convertView
				.findViewById(R.id.tv_content2);

		tv_title.setText(item.getTitle());
		tv_content.setText(item.getContent());
		return convertView;
	}

}
