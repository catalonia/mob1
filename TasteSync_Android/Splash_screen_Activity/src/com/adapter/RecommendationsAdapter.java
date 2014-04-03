package com.adapter;

import java.util.ArrayList;
import java.util.List;

import com.model.Recommendations;
import com.tastesync.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class RecommendationsAdapter extends BaseAdapter implements
		OnClickListener {
	private int resourceID;
	private Context context;
	public ArrayList<Recommendations> list_recommendations;

	public RecommendationsAdapter(Context context,
			ArrayList<Recommendations> list_recommendations) {
		this.context = context;
		this.list_recommendations = list_recommendations;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list_recommendations.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list_recommendations.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		final Recommendations item = list_recommendations.get(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.item_recommandations, null);
		}
		TextView text_name = (TextView) convertView
				.findViewById(R.id.tv_recommandations_name);
		// TextView text_title = (TextView) convertView
		// .findViewById(R.id.tv_recommandations_title);
		TextView text_content = (TextView) convertView
				.findViewById(R.id.tv_recommandations_content);
		ImageView image = (ImageView) convertView
				.findViewById(R.id.recommandations_avatar);
		ImageView icon_reply = (ImageView) convertView
				.findViewById(R.id.icon_reply);
		//item.setReply(false);
		if (item.getReply() == false) {
			icon_reply.setVisibility(View.INVISIBLE);
		} else {
			icon_reply.setVisibility(View.VISIBLE);
		}
		
	
		if(item.getType()==1||item.getType()==3){
			text_name.setText(item.getUsername() + ". " + item.getAction());
			// text_title.setText(item.getAction());
			text_content.setText(item.getDescription());
			image.setImageResource(R.drawable.avatar);
		}else{
			text_name.setText(item.getAction());
			// text_title.setText(item.getAction());
			text_content.setText(item.getDescription());
			image.setImageResource(R.drawable.avatar);
		}

		

		return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
