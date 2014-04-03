package com.activity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tastesync.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class RestaurantmoreActivity extends FragmentActivity {

	private GoogleMap mMap;
	private ImageView img_browser, img_call,img_back;
	LinearLayout layout_back;
	String nameshop, price;
	int ratting, size, vitri;
	private TextView tvNameView, tvPriceView, tvOpen;
	private RatingBar RattingView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_more);
		setUpMapIfNeeded();
		init();
		handle();

	}

	private void init() {
		// TODO Auto-generated method stub
		img_browser = (ImageView) findViewById(R.id.img_browser);
		img_call = (ImageView) findViewById(R.id.img_call);
		img_back = (ImageView) findViewById(R.id.imageBack);
		layout_back=(LinearLayout)findViewById(R.id.layout_back);
		
		tvNameView = (TextView) findViewById(R.id.txtName_more);
		tvPriceView = (TextView) findViewById(R.id.txtPrice_more);
		RattingView = (RatingBar) findViewById(R.id.ratingbar_more);
		tvOpen = (TextView) findViewById(R.id.txtOpen_more);
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
		img_browser.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://bluehillfarm.com/home#"));
				startActivity(mIntent);
			}
		});
		img_call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String url = "tel:3334444";
			    Intent mIntent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
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

	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the
		// map.
		if (mMap == null) {
			// Try to obtain the map from the SupportMapFragment.
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			// Check if we were successful in obtaining the map.
			if (mMap != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {
		LatLng mLatLng = new LatLng(40.710721, -73.96564);
		mMap.addMarker(new MarkerOptions().position(mLatLng).title(
				"Marlow & Sons"));
		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 17));
	}
}
