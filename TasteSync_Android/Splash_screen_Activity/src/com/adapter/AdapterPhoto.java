package com.adapter;

import java.util.ArrayList;

import com.model.photo;
import com.tastesync.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class AdapterPhoto extends ArrayAdapter<photo> {
	Context context;
	int layoutResourceId;
	ArrayList<photo> data = new ArrayList<photo>();

	public AdapterPhoto(Context context, int layoutResourceId,
			ArrayList<photo> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RecordHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);

			holder = new RecordHolder();
			holder.imageItem = (ImageView) row.findViewById(R.id.img_restphoto);
			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}

		photo item = data.get(position);
		holder.imageItem.setImageBitmap(item.getImage());
		return row;

	}

	static class RecordHolder {
		ImageView imageItem;

	}
}