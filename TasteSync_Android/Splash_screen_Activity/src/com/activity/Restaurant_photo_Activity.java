package com.activity;

import java.util.ArrayList;

import com.adapter.AdapterPhoto;
import com.model.photo;
import com.tastesync.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class Restaurant_photo_Activity extends Activity {
	GridView mGridView;
	ImageView img_back;
	LinearLayout layout_back;
	AdapterPhoto mAdapter;
	static ArrayList<photo> mArrayList = new ArrayList<photo>();
	String nameshop, price;
	int ratting, size, vitri;
	private TextView tvNameView, tvPriceView;
	private RatingBar RattingView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_photo);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		mGridView = (GridView) findViewById(R.id.gridview_photo);
		img_back = (ImageView) findViewById(R.id.imageBack);
		layout_back = (LinearLayout)findViewById(R.id.layout_back);
		
		tvNameView = (TextView) findViewById(R.id.txtName_pt);
		tvPriceView = (TextView) findViewById(R.id.txtPrice_pt);
		RattingView = (RatingBar) findViewById(R.id.ratingbar_pt);
	}

	private void handle() {
		// TODO Auto-generated method stub
		Intent i = getIntent();

		nameshop = i.getStringExtra("nameshop");
		price = i.getStringExtra("price");
		ratting = i.getIntExtra("ratting", -1);
		size = i.getIntExtra("size", -1);

		Bundle bundle = i.getBundleExtra("sendname");
		vitri = bundle.getInt("vitri");
		for (int j = 0; j <= size; j++) {
			if (vitri == j) {
				tvNameView.setText("" + nameshop);
				tvPriceView.setText("" + price);
				RattingView.setRating(ratting);
			}

		}
		
		
		layout_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		setList();
		mAdapter = new AdapterPhoto(this, R.layout.item_img_gridview,
				mArrayList);
		mGridView.setAdapter(mAdapter);
		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(Restaurant_photo_Activity.this,
						ViewPhotoRestActivity.class);
				startActivity(mIntent);
			}
		});
		img_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void setList() {
		Bitmap img1 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.frame2);
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
		mArrayList.add(new photo(img1));
	}

}
