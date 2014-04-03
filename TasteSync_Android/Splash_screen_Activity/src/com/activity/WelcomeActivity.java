package com.activity;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;
import com.tastesync.R;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class WelcomeActivity extends Activity {
	private static String APP_ID = "340085532797158";
	// Instance of Facebook Class
	private Facebook facebook = new Facebook(APP_ID);
	private AsyncFacebookRunner mAsyncRunner;
	String FILENAME = "AndroidSSO_data";
	private SharedPreferences mPrefs;

	Button btn_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		init();
		handle();
	}

	public void init() {
		btn_login = (Button) findViewById(R.id.btn_login_facebook );
	}

	public void handle() {
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final ConnectivityManager conMgr =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
				if (activeNetwork != null && activeNetwork.isConnected()) {
				    //notify user you are online
					loginToFacebook();
				} else {
				    //notify user you are not online
					Toast.makeText(WelcomeActivity.this, "Not connected to Internet", 1000).show();
				} 
			}
		});
	}

	/**
	 * Function to login into facebook
	 * */
	@SuppressWarnings("deprecation")
	public void loginToFacebook() {

		mPrefs = getPreferences(MODE_PRIVATE);
		String access_token = mPrefs.getString("access_token", null);
		long expires = mPrefs.getLong("access_expires", 0);

		if (access_token != null) {
			facebook.setAccessToken(access_token);
			Intent mIntent = new Intent(this, MainActivity.class);
			startActivity(mIntent);

			Log.d("FB Sessions", "" + facebook.isSessionValid());
		}
		if (expires != 0) {
			facebook.setAccessExpires(expires);
		}

		if (!facebook.isSessionValid()) {
			facebook.authorize(this,
					new String[] { "email", "publish_stream" },facebook.FORCE_DIALOG_AUTH,
					new DialogListener() {

						@Override
						public void onCancel() {
							// Function to handle cancel event
						}

						@Override
						public void onComplete(Bundle values) {
							// Function to handle complete event
							// Edit Preferences and update facebook acess_token
							SharedPreferences.Editor editor = mPrefs.edit();
							editor.putString("access_token",
									facebook.getAccessToken());
							editor.putLong("access_expires",
									facebook.getAccessExpires());
							editor.commit();

							Intent mIntent = new Intent(WelcomeActivity.this,
									FistLoginActivity.class);
							startActivity(mIntent);
						}

						@Override
						public void onError(DialogError error) {
							// Function to handle error

						}

						@Override
						public void onFacebookError(FacebookError fberror) {
							// Function to handle Facebook errors

						}

					});
		}
	}

	 @Override
	 public void onActivityResult(int requestCode, int resultCode, Intent
	 data) {
	 super.onActivityResult(requestCode, resultCode, data);
	 facebook.authorizeCallback(requestCode, resultCode, data);
	 }

}
