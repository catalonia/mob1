package com.adapter;

import java.util.ArrayList;

import com.model.Itemhorizantal;
import com.tastesync.R;

import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class AdapterLVhorizantal extends BaseAdapter {
	
	public Context mContext;
	public ArrayList<Itemhorizantal> mList;

	public AdapterLVhorizantal(Context mContext, ArrayList<Itemhorizantal> mList) {
		super();
		this.mContext = mContext;
		this.mList = mList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Itemhorizantal mItem = mList.get(position);
		if(convertView==null)
		{
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_horizantal, null);
		}
		Button mButton = (Button)convertView.findViewById(R.id.btn_test);
		mButton.setText(mItem.getText());
		if (mItem.isCheck() == false) {
			Log.d("test",""+ mItem.isCheck());
			mButton.setBackgroundColor(16777216);
		} else {
			mButton.setBackgroundColor(Color.parseColor("#464646"));
		}
		return convertView;
	}

}
