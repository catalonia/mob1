package com.activity;

import com.tastesync.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RestaurantmenuActivity extends Activity {
	WebView mWebView;
	ImageView mImageView;
	LinearLayout layout_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurant_menu);
		init();
		handle();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		
		mWebView = (WebView) findViewById(R.id.web_view);
		mImageView = (ImageView) findViewById(R.id.imageBack);
		layout_back = (LinearLayout) findViewById(R.id.layout_back);
		mImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void handle() {
		// TODO Auto-generated method stub
		startWebView("https://foursquare.com/v/the-sunburnt-cow-new-york-ny/40f1d480f964a5206b0a1fe3/menu");
		layout_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	private void startWebView(String url) {

		// Create new webview Client to show progress dialog
		// When opening a url or click on link

		mWebView.setWebViewClient(new WebViewClient() {
			ProgressDialog progressDialog;

			// If you will not use this method url links are opeen in new brower
			// not in webview
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			// Show loader on url load
			public void onLoadResource(WebView view, String url) {
				if (progressDialog == null) {
					// in standard case YourActivity.this
					progressDialog = new ProgressDialog(
							RestaurantmenuActivity.this);
					progressDialog.setMessage("Loading...");
					progressDialog.show();
				}
			}

			public void onPageFinished(WebView view, String url) {
				try {
					if (progressDialog.isShowing()) {
						progressDialog.dismiss();
						progressDialog = null;
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}

		});
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl(url);

	}
}
